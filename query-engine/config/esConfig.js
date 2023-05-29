const elasticsearch = require("elasticsearch");
const config = require(".");

const client = new elasticsearch.Client({
<<<<<<< HEAD
  host: `https://${config.es_user}:${config.es_pass}@elasticsearch:${config.es_port}`,
  // host: `https://${config.es_user}:${config.es_pass}@178.238.238.209.sslip.io/repo/elastic`,
=======
  host: `https://${config.es_user}:${config.es_pass}@178.238.238.209.sslip.io/repo/elastic`,
>>>>>>> eac889988eaa001bbb110548cab4098c97cf68e4
  // host: `http://${config.es_user}:${config.es_pass}@${config.es_host}:${config.es_port}`,
  // log: "trace",
});

module.exports.esClient = client;
