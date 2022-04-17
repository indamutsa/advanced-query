const express = require("express");
const cors = require("cors");
const bodyParser = require("body-parser");
const multer = require("multer");
const router = require("../controller");

module.exports = function (app) {
  // Setting up the api route and storage folder
  app.use("/file", express.static("public"));
  app.use(cors());
  app.use(bodyParser.json());
  app.use(bodyParser.urlencoded({ extended: true })); // for form data

  // Route
  app.use("/api/upload", router);
};
