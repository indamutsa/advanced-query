FROM node:lts-alpine

RUN apk update && apk add bash

# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY . .
RUN yarn

EXPOSE 3200

CMD [ ]