# # Base image version argument
# ARG ELK_VERSION

# # Use official Elasticsearch image as the base
# FROM docker.elastic.co/elasticsearch/elasticsearch:${ELK_VERSION}

# # Switch to root user for installing additional packages
# USER root

# # Update packages list and install curl
# RUN apt-get update && apt-get install -y curl

# # Clean up to keep the image size down
# RUN apt-get clean && rm -rf /var/lib/apt/lists/*

# # Switch back to elasticsearch user for running the service
# USER elasticsearch


FROM docker.elastic.co/elasticsearch/elasticsearch:7.15.1

# Switch to root user for installing additional packages
USER root

COPY ./config/elasticsearch.yml /usr/share/elasticsearch/config/elasticsearch.yml

# Check if curl is already installed
RUN curl --version || echo "curl is not installed"

# Switch back to elasticsearch user for running the service
USER elasticsearch


