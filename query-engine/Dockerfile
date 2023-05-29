FROM node:lts-alpine

RUN apk update && apk add bash

# Create app directory
RUN mkdir -p /app
WORKDIR /app

COPY . .
<<<<<<< HEAD

RUN npm install

EXPOSE 3300


# CMD ["yarn", "server"]
CMD ["npm", "run", "serve"]


=======
RUN yarn

EXPOSE 3300

CMD ["yarn", "server"]
>>>>>>> eac889988eaa001bbb110548cab4098c97cf68e4
