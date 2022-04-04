const processFile = require("../middleware/upload");
const { format } = require("util");
const { Storage } = require("@google-cloud/storage");

const storage = new Storage({ keyFilename: "lowcomote-storage.json" });
const bucket = storage.bucket("model-artifacts-storage");

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

const uploadOnCloud = async (folder, req) => {
  const filename = req.file.filename;
  const filepath = req.file.path;

  const path = `${folder}/${filename}`;
  const publicUrl = `http://${req.get("host")}/files/${path}`;

  // var options = {
  //   destination: path,
  //   gzip: true,
  //   resumable: true,
  // };

  // await bucket.upload("./" + filepath, options);

  // // `mediaLink` is the URL for the raw contents of the file.
  // // const url = res[0].metadata.mediaLink;

  // // Need to make the file public before you can access it.
  // await bucket.file(folder + "/" + filename).makePublic();

  // const publicUrl = format(
  //   `https://storage.googleapis.com/${bucket.name}/${path}`
  // );

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

module.exports = {
  upload,
  uploadOnCloud,
  getListFiles,
  download,
};
