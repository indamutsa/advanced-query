const express = require("express");
// const { graphqlHTTP } = require("express-graphql");
const path = require("path");
const helmet = require("helmet");
const cors = require("cors");
const dotenv = require("dotenv");
const fs = require("fs");
const multer = require("multer");
const { schema } = require("../route/graphql-legacy/Schema");

// openapi packages
const swaggerUI = require("swagger-ui-express");
const swaggerJsDoc = require("swagger-jsdoc");

dotenv.config();

const forms = multer();

// To document HTTP request and give information about it such as type, time stretch, ...
const morgan = require("morgan");

// Setting up OpenAPI 3.0 specification
const options = {
  definition: {
    openapi: "3.0.0",
    info: {
      title: "MDEForge Persistence API documentation",
      version: "1.0.0",
      description:
        "This is the documentation of persistence api of MDEForge repository! It uses openapi 3.0 specification with swagger 2.0",
    },
    servers: [
      {
        url: "http://localhost:3200",
        description: "The local server",
      },
      {
        url: "http://34.67.33.7:3200",
        description: "Cloud server",
      },
    ],
  },
  apis: ["./route/rest-api/*.js"],
};

const specs = swaggerJsDoc(options);

// Routes
const user = require("../route/rest-api/user");
const workspace = require("../route/rest-api/workspace");
const project = require("../route/rest-api/project");
const { artifactRouter } = require("../route/rest-api/artifact");
const operation = require("../route/rest-api/modelOperation");
const fileUpload = require("../route/rest-api/fileUpload");

//Middleware
const error = require("../middleware/error");
const logger = require("../middleware/logger");

// Routes middleware
module.exports = function (app) {
  // ------------- Built-in Express middleware ------------------ //

  app.use(cors());
  // app.use(forms.array());
  app.use(express.json());
  app.use(express.urlencoded({ extended: true })); // for form data
  app.use(
    helmet({
      contentSecurityPolicy:
        process.env.NODE_ENV === "production" ? undefined : false,
    })
  );

  // log all requests to access.log
  // log only 4xx and 5xx responses to console
  // app.use(
  //   morgan("combined", {
  //     skip: function (req, res) {
  //       console.log(res.statusCode);
  //       return res.statusCode === 400;
  //     },
  //   })
  // );

  // log all requests to access.log
  app.use(
    morgan(
      "[:date[clf]] ':method :url HTTP/:http-version' :status :res[content-length] ':referrer :user-agent' - :response-time ms",
      {
        skip: function (req, res) {
          // return res.statusCode === 200 && req.headers["x-apollo-tracing"];\
          return req.headers["x-apollo-tracing"] !== undefined;
        },
        stream: {
          write: (str) => {
            fs.createWriteStream(path.join(__dirname, "../logs/server.log"), {
              flags: "a",
            });
            logger.info(str);
          },
        },
      }
    )
  );

  // Setting up swagger
  app.use("/store/api-docs", swaggerUI.serve, swaggerUI.setup(specs));

  //Self-defined middleware
  app.use("/store/user", user);
  app.use("/store/workspace", workspace);
  app.use("/store/project", project);
  app.use("/store/artifact", artifactRouter);
  app.use("/store/operation", operation);
  app.use("/store/files", fileUpload);

  // app.use(
  //   "/graphql",
  //   graphqlHTTP({
  //     schema,
  //     graphiql: true,
  //   })
  // );

  // Middleware to handle the errors
  app.use(error);
  // app.use((req, res, next) => {
  //   console.log("I run on every request!");
  //   next();
  // });
};
