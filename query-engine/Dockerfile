FROM node:lts-alpine

RUN apk update && apk add bash

# Create app directory
RUN mkdir -p /app
WORKDIR /app

COPY . .

RUN npm install

EXPOSE 3300


# CMD ["yarn", "server"]
CMD ["npm", "run", "serve"]


