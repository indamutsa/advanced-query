FROM node:lts-alpine

RUN apk update && apk add bash

# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY package.json .
RUN npm install
COPY . .


EXPOSE 3000

CMD [ ]