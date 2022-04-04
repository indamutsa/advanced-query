const express = require("express");
const bodyParser = require("body-parser");
require("dotenv").config();
// require("./utility").resetIndex(); // To reindex data, uncomment this
const app = express();

const { ApolloServer } = require("apollo-server-express");
const {
  ApolloServerPluginLandingPageGraphQLPlayground,
  // ApolloServerPluginLandingPageDisabled,
} = require("apollo-server-core");

const esconfig = require("./config/esConfig");
const client = esconfig.esClient;
const router = require("./router");

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use("/", router);

app.set("port", process.env.APP_PORT || 3300);

async function runServer() {
  const { typeDefs } = require("./graphql/schema/type-defs");
  const { resolvers } = require("./graphql/resolvers");

  /**
   * Bootstrapping the application
   */
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
  });

  await server.start();
  server.applyMiddleware({ app });

  client.ping(
    {
      // requestTimeout: 20000,
    },
    function (error) {
      if (error) {
        console.log("ES Cluster is down", error);
      } else {
        console.log("ES Cluster is up!");
      }
    }
  );

  app.listen(app.get("port"), () => {
    console.log(`Express server listening on port, ${app.get("port")}`);
  });
}

runServer();
