# Use official MongoDB image as base image
FROM mongo:4.2

# Update packages and install required tools in single step
RUN apt-get update && apt-get install -y \
    curl \
    wget \
    net-tools \
    dnsutils \
    inetutils-ping

# Create app directory 
RUN mkdir -p /app

# Set working directory
WORKDIR /app

# Copy source code
COPY . .

# Give execute permissions to setup script
RUN chmod +x ./setup.sh 

# Run setup script when container starts
CMD ["./setup.sh"]