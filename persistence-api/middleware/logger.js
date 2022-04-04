const { createLogger, format, transports } = require("winston");
const dotenv = require("dotenv");

/**
 * Requiring `winston-mongodb` will expose
 * `winston.transports.MongoDB`
 */
require("winston-mongodb");

dotenv.config();

module.exports = createLogger({
  transports: [
    new transports.Console({
      level: "info",
      colorize: true,
      prettyPrint: true,
    }),
    // File transport
    new transports.File({
      filename: "logs/server.log",
      format: format.combine(
        format.timestamp({ format: "MMM-DD-YYYY HH:mm:ss" }),
        format.align(),
        format.printf(
          (info) => `${info.level}: ${[info.timestamp]}: ${info.message}`
        )
      ),
    }),

    // MongoDB transport
    new transports.MongoDB({
      level: "info",
      //mongo database connection link
      db: process.env.MONGO_URL,
      options: {
        useUnifiedTopology: true,
      },
      // A collection to save json formatted logs
      collection: "server_logs",
      format: format.combine(
        format.timestamp(),
        // Convert logs to a json format
        format.json()
      ),
    }),
  ],
});
