const logger = require("../middleware/logger");

// Module to handle async error ( Alternative to the async catch function)
require("express-async-errors");

// We can use debug instead of console.log
const debug = require("debug")("app:startup");
const dbDebugger = require("debug")("app:db");

module.exports = function () {
  // Catching the exception raised anywhere in the application
  process.on("uncaughtException", (exception) => {
    logger.error("We got an an uncaught exception");
    logger.error(exception.message, exception);
    process.exit(1);
  });
  // Catching unhandledRejection
  process.on("unhandledRejection", (rejection) => {
    console.log(rejection);
    logger.error("We got an unhandled rejection");
    logger.error(exception.message);
    process.exit(1);
  });
};
