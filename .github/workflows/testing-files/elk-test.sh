#!/bin/sh

# Elasticsearch
curl -XPUT 'http://elasticsearch:9200/testindex/_doc/1' -H 'Content-Type: application/json' -d '{"title":"Test Document"}'
curl 'http://elasticsearch:9200/testindex/_search?q=title:Test'
elasticsearch_health=$(curl -s 'http://elasticsearch:9200/_cluster/health?pretty' | grep status | awk '{print $2}' | tr -d '"')
if [ "$elasticsearch_health" != "green" ]; then
  echo "Elasticsearch cluster health check failed"
  exit 1
fi

# Kibana
response=$(curl -Is http://kibana:5601 | head -1) 
if [[ ! $response =~ "200 OK" ]]; then
  echo "Error: Kibana not reachable"
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