const winston = require("winston");
const mongoose = require("mongoose");
const config = require("config");
const logger = require("../middleware/logger");
const { computeMetrics } = require("./batchExecution");

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
      .then(async (client) => {
        const collection = await client.model("Metamodel");

        const pipeline = [
          {
            $match: {
              $or: [
                {
                  "updateDescription.updatedFields.description": {
                    $exists: true,
                  },
                  operationType: "update",
                },
                {
                  "fullDocument.description": { $exists: true },
                  operationType: "insert",
                },
              ],
            },
          },
        ];

        let changeStream = collection.watch(pipeline);
        console.log(`Connected to database --> `);

        changeStream.on("change", async (object) => {
          if (object.operationType == "update") {
            console.log("Update event!!");
            await computeMetrics(object.documentKey._id);
          } else if (object.operationType == "insert") {
            console.log("Insert event!!");
            await computeMetrics(object.fullDocument._id);
          }
        });
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
