const Eureka = require("eureka-js-client").Eureka;
const eurekaHost =
  process.env.EUREKA_CLIENT_SERVICEURL_DEFAULTZONE || "127.0.0.1";
const eurekaPort = 8761;
const hostName = process.env.HOSTNAME || "localhost";
const ipAddr = "172.0.0.1";

exports.registerWithEureka = function (appName, PORT) {
  const client = new Eureka({
    instance: {
      app: appName,
      hostName: hostName,
      instanceId: "persistence-api",
      ipAddr: "0.0.0.0",
      status: "UP",
      statusPageUrl: "http://localhost:3200",
      port: {
        $: PORT,
        "@enabled": "true",
      },
      vipAddress: appName,
      dataCenterInfo: {
        "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
        name: "MyOwn",
      },
    },

    eureka: {
      host: eurekaHost,
      port: eurekaPort,
      servicePath: "/eureka/apps",
      // maxRetries: 5,
      // requestRetryDelay: 2000,
    },
  });

  client.logger.level("debug");

  client.start((error) => {
    console.log(error || "Persistence api registered!");
  });

  function exitHandler(options, exitCode) {
    client.stop();
    process.exit();
  }

  client.on("deregistered", () => {
    process.exit();
    console.log("After deregistered");
  });

  client.on("started", () => {
    console.log("Eureka host " + eurekaHost);
  });

  process.on("SIGINT", exitHandler.bind(null, { exit: true }));
};
