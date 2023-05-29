# ARG ELK_VERSION

# # https://www.docker.elastic.co/
# FROM docker.elastic.co/logstash/logstash:${ELK_VERSION}

# # Copy configuration files from host to container
# COPY ./config/logstash.yml /usr/share/logstash/config/logstash.yml
# COPY ./pipeline/logstash.conf /usr/share/logstash/pipeline/logstash.conf

# RUN bin/logstash-plugin install logstash-input-beats

# # Add your logstash plugins setup here
# # Example: RUN logstash-plugin install logstash-filter-json


# ----------------------------------------

# Use the official Logstash image from the Elastic Docker registry
FROM docker.elastic.co/logstash/logstash:7.15.1

# Copy configuration files from host to container
COPY ./config/logstash.yml /usr/share/logstash/config/logstash.yml
COPY ./pipeline/logstash.conf /usr/share/logstash/pipeline/logstash.conf

# Ensure that the logstash user has permissions to access the copied files
USER root
RUN chown -R logstash:logstash /usr/share/logstash/config/logstash.yml
RUN chown -R logstash:logstash /usr/share/logstash/pipeline/logstash.conf

# Install Beats input plugin
# RUN bin/logstash-plugin install logstash-input-beats

# Switch back to the logstash user
USER logstash

