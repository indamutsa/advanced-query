# Use an appropriate base image
FROM ubuntu:18.04

# Copy the script into the container
COPY elk-test.sh /elk-test.sh

# Set the script as executable
RUN chmod +x /elk-test.sh

# Execute the script (or you can use CMD depending on your needs)
ENTRYPOINT ["/elk-test.sh"]
