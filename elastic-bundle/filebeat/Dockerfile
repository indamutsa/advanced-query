# FROM docker.elastic.co/beats/filebeat:7.10.2
# COPY filebeat.yml /usr/share/filebeat/filebeat.yml
# USER root
# RUN chown root:filebeat /usr/share/filebeat/filebeat.yml
# RUN chmod go-rw /usr/share/filebeat/filebeat.yml
# USER filebeat


# ARG ELK_VERSION

# https://www.docker.elastic.co/
FROM docker.elastic.co/beats/filebeat:7.15.1

# Copying logs directory and filebeat configuration file
COPY ./logs /logs
COPY ./filebeat.yml /usr/share/filebeat/filebeat.yml

USER root
RUN chmod go-w /usr/share/filebeat/filebeat.yml
USER filebeat
