const multer = require("multer");
const path = require("path");

//---------------------------------------------------------------------------------

// Save ARTIFACT
const uploadFile = () => {
  // Uploading files to the disk rather into the database

  const storage = multer.diskStorage({
    destination: (req, file, cb) => {
      // var total = req.baseUrl.match(/[^\\]*\/(\w+)$/);
      // var extension = total[1];
      // console.log(req.body);
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
      cb(null, file.originalname);
    },
  });

  var upload = multer({ storage: storage }).single("file");
  return upload;
};

const writeFileName = (file, cb) => {
  let datafile = file.originalname.match(/(.*)\.(.*)/);
  let fileName = datafile[1];
  let ext = datafile[2];
  cb(
    null,
    fileName +
      "-" +
      Date.now() +
      "-" +
      Math.round(Math.random() * 100).toString() +
      "." +
      ext
  );
};

const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    // console.log(file);
    if (req.body.folder === "models") {
      cb(null, "./public/models");
    } else if (req.body.folder === "metamodels") {
      cb(null, "./public/metamodels");
    } else if (req.body.folder === "scripts") {
      cb(null, "./public/scripts");
    }
  },
});

//---------------------------------------------------------------------------------
// Deleting the file
const deleteFile = async (link) => {
  setTimeout(() => {
    link = path.resolve(__dirname + "/../../" + link);
    fs.access(link, fs.F_OK, async (err, ac) => {
      if (err) {
        return "Error occurred while deleting...";
      } else {
        await fs.unlink(link, (ferr, fc) => {
          if (ferr) {
            return "Error Occurred On File Deletion!";
          } else {
            return "File deleted successfully!";
          }
        });
      }
    });
  }, 5000);
};

module.exports = {
  uploadFile,
};
