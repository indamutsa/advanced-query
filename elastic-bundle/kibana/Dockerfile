ARG ELK_VERSION

# https://www.docker.elastic.co/
FROM docker.elastic.co/kibana/kibana:${ELK_VERSION}

COPY ./config/kibana.yml /work/elastic-bundle/config/kibana.yml

# Add your kibana plugins setup here
# Example: RUN kibana-plugin install <name|url>
