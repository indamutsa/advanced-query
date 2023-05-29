ARG ELK_VERSION

# https://www.docker.elastic.co/
FROM docker.elastic.co/logstash/logstash:${ELK_VERSION}
RUN bin/logstash-plugin install logstash-input-beats

<<<<<<< HEAD
COPY ./config/logstash.yml /work/elastic-bundle/logstash/config/logstash.yml
COPY ./config/pipeline/ /work/elastic-bundle/logstash/pipeline/
=======

>>>>>>> eac889988eaa001bbb110548cab4098c97cf68e4
# Add your logstash plugins setup here
# Example: RUN logstash-plugin install logstash-filter-json
