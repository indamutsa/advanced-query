#!/bin/bash

# Create required directories
mkdir -p elasticsearch logstash logstash/pipeline kibana filebeat

# Write the docker-compose configuration
cat <<EOF > docker-compose.yml
version: "3.4"

services:
  # ELASTICSEARCH CLUSTER
  ################################################################################
  es-master:
    container_name: es-master
    # build:
    #   context: ./elasticsearch
    #   dockerfile: Dockerfile
    image: indamutsa/elasticsearch:v1.0.0
    environment:
      - node.name=es-master
      - node.master=true
      - node.data=false
      - cluster.initial_master_nodes=es-master
      - ES_JAVA_OPTS=-Xmx256m -Xms256m
      - ELASTIC_USERNAME=elastic
      - ELASTIC_PASSWORD=changeme
    volumes:
      - es-master-data:/usr/share/elasticsearch/data
    ports:
      - 9200:9200
    networks:
      - search-engine

  es-worker1:
    container_name: es-worker1
    # build:
    #   context: ./elasticsearch
    #   dockerfile: Dockerfile
    image: indamutsa/elasticsearch:v1.0.0
    environment:
      - node.name=es-worker1
      - node.master=false
      - node.data=true
      - discovery.seed_hosts=es-master
      - ES_JAVA_OPTS=-Xmx256m -Xms256m
      - ELASTIC_USERNAME=elastic
      - ELASTIC_PASSWORD=changeme
    volumes:
      - es-worker1-data:/usr/share/elasticsearch/data
    networks:
      - search-engine
    depends_on:
      - es-master

  es-worker2:
    container_name: es-worker2
    # build:
    #   context: ./elasticsearch
    #   dockerfile: Dockerfile
    image: indamutsa/elasticsearch:v1.0.0
    environment:
      - node.name=es-worker2
      - node.master=false
      - node.data=true
      - node.ingest=true
      - discovery.seed_hosts=es-master
      - ES_JAVA_OPTS=-Xmx256m -Xms256m
      - ELASTIC_USERNAME=elastic
      - ELASTIC_PASSWORD=changeme
    volumes:
      - es-worker2-data:/usr/share/elasticsearch/data
    networks:
      - search-engine
    depends_on:
      - es-master

  logstash:
    container_name: logstash
    # build:
    #   context: ./logstash
    #   dockerfile: Dockerfile
    image: indamutsa/logstash:v1.0.0
    ports:
      - "5044:5044"
      - "5000:5000/tcp"
      - "5000:5000/udp"
      - "9600:9600"
    networks:
      - search-engine
    depends_on:
      - es-master
    restart: on-failure

  kibana:
    container_name: kibana
    # build:
    #   context: ./kibana
    #   dockerfile: Dockerfile
    image: indamutsa/kibana:v1.0.0
    ports:
      - "5601:5601"
    networks:
      - search-engine
    depends_on:
      - es-master
    restart: on-failure

  filebeat:
    container_name: filebeat
    # build:
    #   context: ./filebeat
    #   dockerfile: Dockerfile
    image: indamutsa/filebeat:v1.0.0
    volumes:
      - "/var/lib/docker/containers:/var/lib/docker/containers:ro"
      - "/var/run/docker.sock:/var/run/docker.sock"
    networks:
      - search-engine
    restart: on-failure


# Defining the network
######################################################
networks:
  search-engine:
    external: false

volumes:
  es-master-data:
  es-worker1-data:
  es-worker2-data:

EOF

# Write the Elasticsearch Dockerfile and configuration
cat <<EOF > elasticsearch/Dockerfile
FROM docker.elastic.co/elasticsearch/elasticsearch:7.15.1
COPY elasticsearch.yml /usr/share/elasticsearch/config/
EOF

cat <<EOF > elasticsearch/elasticsearch.yml
cluster.name: "docker-cluster"
network.host: 0.0.0.0
xpack.security.enabled: true
EOF

# Write the Logstash Dockerfile and configuration
cat <<EOF > logstash/Dockerfile
FROM docker.elastic.co/logstash/logstash:7.15.1
COPY logstash.yml /usr/share/logstash/config/
COPY pipeline/ /usr/share/logstash/pipeline/
EOF

cat <<EOF > logstash/logstash.yml
http.host: "0.0.0.0"
xpack.monitoring.elasticsearch.username: "elastic"
xpack.monitoring.elasticsearch.password: "changeme"
EOF

cat <<EOF > logstash/pipeline/logstash.conf
input {
  beats {
    port => 5044
  }
}
output {
  elasticsearch {
    hosts => ["http://es-master:9200"]
    user => "elastic"
    password => "changeme"
    index => "%{[@metadata][beat]}-%{[@metadata][version]}-%{+YYYY.MM.dd}"
  }
}
EOF

# Write the Kibana Dockerfile and configuration
cat <<EOF > kibana/Dockerfile
FROM docker.elastic.co/kibana/kibana:7.15.1
COPY kibana.yml /usr/share/kibana/config/
EOF

cat <<EOF > kibana/kibana.yml
server.name: kibana
server.host: "0.0.0.0"
elasticsearch.username: "elastic"
elasticsearch.password: "changeme"
elasticsearch.hosts: [ "http://es-master:9200" ]
xpack.security.enabled: true
EOF

# Write the Filebeat Dockerfile
cat <<EOF > filebeat/Dockerfile
FROM docker.elastic.co/beats/filebeat:7.15.1
COPY filebeat.yml /usr/share/filebeat/filebeat.yml
USER root
RUN chmod go-w /usr/share/filebeat/filebeat.yml && chown root:filebeat /usr/share/filebeat/filebeat.yml
USER filebeat
EOF



# Write the Filebeat configuration
cat <<EOF > filebeat/filebeat.yml
filebeat.inputs:
- type: log
  enabled: true
  paths:
    - /var/lib/docker/containers/*/*.log

output.elasticsearch:
  hosts: ["es-master:9200"]
  username: "elastic"
  password: "changeme"

logging.level: warning

EOF

