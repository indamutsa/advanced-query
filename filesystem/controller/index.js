const express = require("express");
const router = express.Router();
const service = require("../service");
const { uploadFile } = require("../util");

router.post("/", uploadFile(), service.fileHandler);
router.get("/files", service.getListFiles);
router.get("/files/:name", service.download);

module.exports = router;
