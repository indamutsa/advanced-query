/**
 * MDEForge PERSISTENCE API ENTRY POINT
 *
 * This api developed using Node.js persists data
 * The persisted data might be model artifacts or its metadata.
 * It consumes the search engine as well.
 */

// // Requiring core modules
const express = require("express");
const app = express();
const dotenv = require("dotenv");
const { loadInitData } = require("./startup/loadInitData");
const { runMetricsInInterval } = require("./startup/batchExecution");
const { ApolloServer, gql } = require("apollo-server-express");
const {
  ApolloServerPluginLandingPageGraphQLPlayground,
  ApolloServerPluginLandingPageDisabled,
} = require("apollo-server-core");

// Setting up the api route and storage folder
app.use("/static", express.static(__dirname + "/public"));
app.use("/files", express.static(__dirname + "/localStorage/artifacts"));

async function runServer() {
  // Requiring auxiliary operations
  const logging = require("./startup/logging");
  const { connectDb } = require("./startup/database");
  const init_app = require("./startup/routes");
  const validate = require("./startup/validation");
  const logger = require("./middleware/logger");
  const eurekaDiscovery = require("./startup/eureka-discovery");
  const { typeDefs } = require("./route/graphql/type-defs");
  const { resolvers } = require("./route/graphql/resolvers");

  // We define the port
  const PORT = process.env.PORT || 3200;

  // Expose Env variables
  dotenv.config();

  /**
   * Bootstrapping the application
   */
  logging();
  connectDb();

  // Start the apollo server - GraphQL
  const server = new ApolloServer({
    typeDefs,
    resolvers,
    introspection: true,
    plugins: [
      ApolloServerPluginLandingPageGraphQLPlayground({
        settings: { "schema.polling.enable": true },
      }),
      // ApolloServerPluginLandingPageDisabled(),
    ],
    context: ({ req }) => {
      return { name: "Indamutsa", req };
    },
    // ({ req, res }) => ({ req, res }),
  });

  init_app(app);
  validate();
  loadInitData();
  // runMetricsInInterval();

  await server.start();
  server.applyMiddleware({ app });
  // eurekaDiscovery.registerWithEureka("persistence-api", PORT);

  app.listen(PORT, () => {
    logger.info(`Listening on port ${PORT}...`);
  });
}

runServer();
