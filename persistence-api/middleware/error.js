const winston = require("winston");

module.exports = function (err, req, res, next) {
  // Logging exceptions
  // It's gonna log metadata (err.message, err)
  winston.error(err.message, err);

  res
    .status(500)
    .json("Error occurred, Please check the error below: \n" + err);
};
