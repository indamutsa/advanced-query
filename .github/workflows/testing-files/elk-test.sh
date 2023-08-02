#!/bin/sh

# Elasticsearch
# Wait for Elasticsearch to become healthy, up to 30 seconds, and then put the document
echo 'Wait for Elasticsearch to become healthy'

#  Sleep for 3 mins while running this: docker-compose -f .github/workflows/testing-files/elk-compose.yml logs
min_count=0
while [ $min_count -lt 10 ]; do
  echo "Logging docker-compose logs for 18 seconds"
  docker-compose -f .github/workflows/testing-files/elk-compose.yml logs
  sleep 18
  min_count=$((min_count + 1))
done

count=0
while [ $count -lt 6 ]; do
  elasticsearch_health=$(curl -s 'http://elasticsearch:9200/_cluster/health?pretty' | grep status | awk '{print $2}' | tr -d '"')
  if [ "$elasticsearch_health" = "green" ]; then
    echo "Elasticsearch is healthy"
    curl -XPUT 'http://elasticsearch:9200/testindex/_doc/1' -H 'Content-Type: application/json' -d '{"title":"Test Document"}'
    # Test if the document went through
    test_result=$(curl 'http://elasticsearch:9200/testindex/_search?q=title:Test')
    if [[ $test_result = *"Test Document"* ]]; then
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

if [ $count -eq 6 ] && [ "$elasticsearch_health" != "green" ]; then
  echo "Elasticsearch did not become healthy within 30 seconds."
  exit 1
fi


# Kibana
# Wait for Kibana to become healthy, up to 10 seconds
echo 'Wait for Kibana to become healthy, up to 10 seconds'
count=0
while [ $count -lt 2 ]; do
  response=$(curl -Is http://kibana:5601 | head -1)
  if [[ $response =~ "200 OK" ]]; then
    echo "Kibana is healthy"
    break
  fi
  echo "Waiting for Kibana..."
  sleep 5
  count=$((count + 1))
done

if [ $count -eq 2 ] && [[ ! $response =~ "200 OK" ]]; then
  echo "Kibana did not become healthy within 10 seconds."
  exit 1
fi


# Logstash
echo '{"message":"Test log event"}' | nc logstash 5044
sleep 5
logstash_docs=$(curl 'http://elasticsearch:9200/logstash*/_count?q=message:Test')
if [[ $logstash_docs -eq 0 ]]; then
  echo "Logstash events not indexed"
  exit 1
fi

# Filebeat
filebeat test -e -d "publish" 
sleep 5 
filebeat_docs=$(curl 'http://elasticsearch:9200/filebeat*/_count?q=message:Test')
if [[ $filebeat_docs -eq 0 ]]; then
  echo "Filebeat logs not indexed" 
  exit 1
fi

echo "All checks passed"