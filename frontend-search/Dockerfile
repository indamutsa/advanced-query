FROM node:14

ENV PORT 3500

# Create app directory
RUN mkdir -p /app
WORKDIR /app

# Installing dependencies
COPY . .
RUN yarn


# Build the app
RUN yarn build
EXPOSE 3500

# RUN THE APP
CMD "yarn" "dev"
