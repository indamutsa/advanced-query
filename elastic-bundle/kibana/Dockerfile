# ARG ELK_VERSION

# # https://www.docker.elastic.co/
# FROM docker.elastic.co/kibana/kibana:${ELK_VERSION}

# # Add your kibana plugins setup here
# # Example: RUN kibana-plugin install <name|url>

# -----------------

# https://www.docker.elastic.co/
FROM docker.elastic.co/kibana/kibana:7.15.1

# Copying kibana configuration file
COPY ./config/kibana.yml /usr/share/kibana/config/kibana.yml

# Add your kibana plugins setup here
# Example: RUN kibana-plugin install <name|url>
