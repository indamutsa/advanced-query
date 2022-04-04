const router = require("express").Router();
const multer = require("multer");
const controller = require("../../services/file.controller");

// Uploading files to the disk rather into the database
const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, "localStorage/artifacts");
  },
  filename: (req, file, cb) => {
    cb(null, req.body.name);
  },
});

// Upload method
const upload = multer({ storage: storage });
router.post("/api/upload", upload.single("file"), (req, res) => {
  try {
    return res.status(200).json("File Uploaded Successfully!");
  } catch (err) {
    console.error(err);
  }
});

router.post("/cloud-upload", controller.upload);
router.get("/", controller.getListFiles);
router.get("/:name", controller.download);

module.exports = router;
