const express = require("express");
const bodyParser = require("body-parser");
<<<<<<< HEAD
const cors = require("cors");
=======
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b

require("dotenv").config({
  path: process.env.NODE_ENV ? `.env.${process.env.NODE_ENV}` : ".env",
});

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

<<<<<<< HEAD
app.use(cors())
=======
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
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
