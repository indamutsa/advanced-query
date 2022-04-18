var axios = require("axios");
var http = require("http");

var FormData = require("form-data");
var fs = require("fs");
const processFile = require("../middleware/upload");
const { format } = require("util");
const { Storage } = require("@google-cloud/storage");
const { deleteFile } = require("../route/utilities");
const logger = require("../middleware/logger");

const storage = new Storage({ keyFilename: "lowcomote-storage.json" });
const bucket = storage.bucket("model-artifacts-storage");
let data = new FormData();

const uploadOnCloud = async (folder, req) => {
  // console.log(req.file);
  req.file.folder = folder;
  const publicUrl = await serverUpload("private", req);
  // console.log("Inside the upload on cloud", publicUrl);
  await deleteFile(req.file.path);

  return publicUrl;
};

const serverUpload = async (type, req) => {
  let filename = req.file.filename;
  let filepath = req.file.path;
  let folder = req.file.folder;
  let path = `${folder}/${filename}`;
  let publicUrl = "";

  try {
    switch (type) {
      case "local":
        publicUrl = `http://${req.get("host")}/files/${path}`;
        break;

      case "private":
        // data.append("folder", folder);
        // data.append("file", fs.createReadStream(filepath));

        // console.log(filepath);
        var unirest = require("unirest");
        var req = await unirest("POST", process.env.UPLOAD_URL)
          .field("folder", folder)
          .attach("file", filepath)
          .end(function (res) {
            if (res.error) console.log(res);
            console.log(res.raw_body);
          });

        // console.log("Inside the function", req.method);

        break;

      case "cloud":
        let options = {
          destination: path,
          gzip: true,
          resumable: true,
        };

        await bucket.upload("./" + filepath, options);

        // `mediaLink` is the URL for the raw contents of the file.
        // const url = res[0].metadata.mediaLink;

        // Need to make the file public before you can access it.
        await bucket.file(folder + "/" + filename).makePublic();

        publicUrl = format(
          `https://storage.googleapis.com/${bucket.name}/${path}`
        );

        break;

      default:
        break;
    }
  } catch (err) {
    console.log(err);
    // logger.error(err.message);
  }
  publicUrl = `http://localhost:3201/file/${folder}/${filename}`;
  return publicUrl;
};

const getListFiles = async (req, res) => {
  try {
    const [files] = await bucket.getFiles();
    let fileInfos = [];

    files.forEach((file) => {
      fileInfos.push({
        name: file.name,
        url: file.metadata.mediaLink,
      });
    });

    res.status(200).send(fileInfos);
  } catch (err) {
    console.log(err);

    res.status(500).send({
      message: "Unable to read list of files!",
    });
  }
};

const download = async (req, res) => {
  try {
    const [metaData] = await bucket.file(req.params.name).getMetadata();
    res.redirect(metaData.mediaLink);
  } catch (err) {
    res.status(500).send({
      message: "Could not download the file. " + err,
    });
  }
};

const upload = async (req, res) => {
  try {
    await processFile(req, res);
    // console.log(req.folder);
    // req.folder = "metamodels";
    if (!req.file) {
      return res.status(400).send({ message: "Please upload a file!" });
    }

    const blob = bucket.file(`${req.folder}/` + req.file.originalname);

    const blobStream = blob.createWriteStream({
      resumable: false,
      gzip: true,
      public: true,
    });

    blobStream.on("error", (err) => {
      res.status(500).send({ message: err.message });
    });

    blobStream.on("finish", async (data) => {
      const publicUrl = format(
        `https://storage.googleapis.com/${bucket.name}/${blob.name}`
      );

      try {
        await bucket.file(req.file.originalname).makePublic();
      } catch {
        return res.status(500).send({
          message: `Uploaded the file successfully: ${req.file.originalname}, but public access is denied!`,
          url: publicUrl,
        });
      }

      res.status(200).send({
        message: "Uploaded the file successfully: " + req.file.originalname,
        url: publicUrl,
      });
    });

    blobStream.end(req.file.buffer);
  } catch (err) {
    console.log(err);

    if (err.code == "LIMIT_FILE_SIZE") {
      return res.status(500).send({
        message: "File size cannot be larger than 2MB!",
      });
    }

    res.status(500).send({
      message: `Could not upload the file: ${req.file.originalname}. ${err}`,
    });
  }
};

module.exports = {
  upload,
  uploadOnCloud,
  getListFiles,
  download,
};

// let config = {
//   method: "POST",
//   path: "/api/upload/",
//   host: "localhost",
//   port: 3201,
//   headers: {
//     ...data.getHeaders(),
//   },
// };

// const send = (id) =>
//   new Promise((resolve, reject) => {
//     const req = http.request(config, (res) => {
//       console.log(id + " " + res.statusCode);
//       resolve();
//     });
//     req.on("data", () => {
//       publicUrl = `http://localhost:3201/file/${folder}/${filename}`;
//       data.pipe(req);
//       resolve();
//       console.log("*************");
//       return publicUrl;
//     });

//     req.on("error", (error) => {
//       console.warn(error);
//       reject();
//     });

//     req.end();
//   });

// await send(1);
// await send(2);

// var config = {
//   method: "POST",
//   url: localUrl,
//   headers: {
//     ...data.getHeaders(),
//   },
//   data: data,
// };

// const response = await axios.post(localUrl, data, {
//   headers: {
//     ...data.getHeaders(),
//   },
// });
// console.log(response.status);

// (
//   config
// )
// .then((resp) => {
//   publicUrl = `http://178.238.238.209:3201/file/${folder}/${filename}`;
//   console.log("url", publicUrl);
//   logger.info("Uploaded the file successfully");
//   return publicUrl;
// })
// .catch((err) => {
//   throw new Error(
//     "Error occured while uploading the file" + err.message
//   );
// });

// if (response) {
//   publicUrl = `http://178.238.238.209:3201/file/${folder}/${filename}`;
//   console.log("url", publicUrl);
//   logger.info("Uploaded the file successfully");
//   return publicUrl;
// } else {
//   throw new Error(
//     "Error occured while uploading the file" + response.status
//   );
// }
// return publicUrl;
