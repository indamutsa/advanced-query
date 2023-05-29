FROM mongo:4.2

#Create app directory
RUN mkdir -p /home/app
WORKDIR /home/app
# Install dependencies
COPY . .


# Finally run this script
RUN ["chmod", "+x", "./setup.sh"]
CMD ["./setup.sh"]