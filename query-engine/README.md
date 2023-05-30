
<!-- README.<!-- markdownlint-capture --> -->

This readme documents the data sets and libraries utilized in building this application. As per the data set used, the link can be credited to this github repo, `https://vega.github.io/vega-datasets/data/cars.json`.


To start the application for the first time, run `npm install --save` to install all the depenndencies. To start the project, run `npm start` from your terminal. This triggers the start script in our `package.json` file...




## Dependencies

In this tutorial, we have made use of the elastic builder library, `https://elastic-builder.js.org/`. This library has been used to build our queries for search, instead of relying on raw elastic search queries.

Although there are other libraries that we can use, we have decided to make use of this because of its ease and clean syntax.


We also made use of the official es client for Node JS (`https://elastic-builder.js.org/`). All these dependencies can be found on npm...


Please, open an issue, if you run into one. Thanks...




etl transformation: http://178.238.238.209:8085/mms/api-docs/transform
etl query: http://178.238.238.209:8087/mms/api-docs/query
etl metrics: http://178.238.238.209:8186/mms/api-docs/metrics
etl validate: http://178.238.238.209:8086/mms/api-docs/validate
api http://178.238.238.209:3200/store/api-docs/


------

<!-- 

apk add --no-cache docker curl py-pip python3-dev libffi-dev openssl-dev gcc libc-dev make  zip bash openssl git && pip install docker-compose && echo "http://dl-cdn.alpinelinux.org/alpine/v3.14/community" >> /etc/apk/repositories && apk update && apk add mongodb-tools && mongoimport --version && mongoexport --version -->