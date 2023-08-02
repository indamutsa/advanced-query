#!/bin/sh

# Elasticsearch
# Wait for Elasticsearch to become healthy, up to 30 seconds, and then put the document
echo 'Wait for Elasticsearch to become healthy'

# Sleep for 3 mins while running this: docker-compose -f .github/workflows/testing-files/elk-compose.yml logs
sleep 180

docker-compose -f .github/workflows/testing-files/elk-compose.yml logs
sleep 10


count=0
while [ $count -lt 6 ]; do
  elasticsearch_health=$(curl -s -u elastic:changeme 'http://localhost:9200/_cluster/health?pretty' | grep status | awk '{print $3}' | tr -d '",')
  echo "Elasticsearch health---------->>>>>: $elasticsearch_health"
  if [ "$elasticsearch_health" = "yellow" ]; then
    echo "Elasticsearch is healthy"
    curl -XPUT -u elastic:changeme 'http://localhost:9200/testindex/_doc/1' -H 'Content-Type: application/json' -d '{"title":"Test Document"}' >/dev/null 2>&1
    
    # Test if the document went through
    test_result=$(curl -u elastic:changeme -s -o /dev/null -w '%{http_code}' 'http://localhost:9200/testindex/_search?q=title:Test' 2>/dev/null)
    
    if [ $test_result -eq "200" ]; then
      echo "Document indexed successfully"
    else
      echo "Error: Document not indexed"
      exit 1
    fi
    break
  fi
  echo "Waiting for Elasticsearch..."
  sleep 10
  count=$((count + 1))
done

if [ $count -eq 6 ] && [ "$elasticsearch_health" != "yellow" ]; then
  echo "Elasticsearch did not become healthy within 30 seconds."
  exit 1
fi


# Kibana
# Wait for Kibana to become healthy, up to 10 seconds
echo 'Wait for Kibana to become healthy, up to 10 seconds'
count=0
while [ $count -lt 2 ]; do
  response=$(curl -Is http://localhost:5601 | head -1 | grep 302 | awk '{print $2}')
  if [ $response -eq "302" ]; then
    echo "Kibana is healthy"
    break
  fi
  echo "Waiting for Kibana..."
  sleep 5
  count=$((count + 1))
done

if [ $count -eq 2 ] && [ ! $response = "302" ]; then
  echo "Kibana did not become healthy within 10 seconds."
  exit 1
fi


sleep 5
logstash_docs=$(curl -u elastic:changeme 'http://localhost:9200/logstash*/_count?q=message:Test' 2>/dev/null)
successful_count=$(echo "$logstash_docs" | grep -o '"successful":[0-9]*' | awk -F: '{print $2}')

if [ "$successful_count" -eq 1 ]; then
  echo "Logstash events indexed successfully"
else
  echo "Logstash events not indexed"
  exit 1
fi


# Filebeat
filebeat test -e -d "publish" >/dev/null 2>&1
sleep 5 

filebeat_docs=$(curl -u elastic:changeme 'http://localhost:9200/filebeat*/_count?q=message:Test' 2>/dev/null)
fail_count=$(echo "$filebeat_docs" | grep -o '"failed":[0-9]*' | awk -F: '{print $2}')

if [ "$fail_count" -eq 0 ]; then
  echo "Filebeat indexed"
else
  echo "Filebeat events not indexed"
  exit 1
fi

echo "All checks passed"
