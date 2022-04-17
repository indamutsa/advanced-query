const util = require("util");
const multer = require("multer");
// const maxSize = 2 * 1024 * 1024;
let storage = multer.diskStorage({
  destination: (req, file, cb) => {
    // var total = req.baseUrl.match(/[^\\]*\/(\w+)$/);
    // var extension = total[1];

    let folder = req.body.folder;

    const modelExts = ["models", "metamodels", "scripts"];
    const valid = modelExts.includes(folder);
    if (valid) {
      if (folder === "models") {
        cb(null, "./public/models");
      } else if (folder === "metamodels") {
        cb(null, "./public/metamodels");
      } else if (folder === "scripts") {
        cb(null, "./public/scripts");
      }
    } else {
      console.log("Folder not valid!");
    }
  },
  filename: (req, file, cb) => {
    // console.log(file.originalname);
    cb(null, file.originalname);
  },
});
let uploadFile = multer({
  storage: storage,
}).single("file");

let uploadFileMiddleware = util.promisify(uploadFile);
module.exports = uploadFileMiddleware;
