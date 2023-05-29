ARG ELK_VERSION

# https://www.docker.elastic.co/
FROM docker.elastic.co/elasticsearch/elasticsearch:${ELK_VERSION}
COPY ./config/elasticsearch.yml /work/elastic-bundle/config/elasticsearch.yml

# Add your elasticsearch plugins setup here
# Example: RUN elasticsearch-plugin install analysis-icu
