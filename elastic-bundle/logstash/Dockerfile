ARG ELK_VERSION

# https://www.docker.elastic.co/
FROM docker.elastic.co/logstash/logstash:${ELK_VERSION}
RUN bin/logstash-plugin install logstash-input-beats

COPY ./config/logstash.yml /work/elastic-bundle/logstash/config/logstash.yml
COPY ./config/pipeline/ /work/elastic-bundle/logstash/pipeline/
# Add your logstash plugins setup here
# Example: RUN logstash-plugin install logstash-filter-json
