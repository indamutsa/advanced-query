const express = require("express");
const logger = require("./middleware/logger");
require("dotenv").config();

// Variables
const PORT = process.env.PORT || 3201;
const app = express();

const initializeApp = require("./route");
initializeApp(app);

app
  .listen(PORT, () => logger.info("Server started successfully!"))
  .on("error", (err) =>
    logger.info("An error occurred while uploading the file: ", err.message)
  );
