const winston = require("winston");
const mongoose = require("mongoose");
const config = require("config");
const logger = require("../middleware/logger");

const connectDb = async () => {
  const db = config.get("db");

  try {
    await mongoose
      .connect(process.env.MONGO_URL, {
        useNewUrlParser: true,
        useUnifiedTopology: true,
        useFindAndModify: false,
        useCreateIndex: true,
      })
      .then(() => {
        logger.info(`Connected to database --> ${db} ...`);
      })
      .catch((err) => {
        logger.error(`Error connecting to the database. \n${err}`);
      });
  } catch (err) {
    logger.error(err.message);
    process.exit(1);
  }
};

module.exports = { connectDb };
