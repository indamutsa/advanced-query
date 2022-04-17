const { createLogger, format, transports } = require("winston");

module.exports = createLogger({
  transports: [
    new transports.Console({
      level: "info",
      colorize: true,
      prettyPrint: true,
    }),
    // File transport
    new transports.File({
      filename: "logs/serverLog.log",
      format: format.combine(
        format.timestamp({ format: "MMM-DD-YYYY HH:mm:ss" }),
        format.align(),
        format.printf(
          (info) => `${info.level}: ${[info.timestamp]}: ${info.message}`
        )
      ),
    }),
  ],
});
