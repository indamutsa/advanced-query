const multer = require("multer");
const fs = require("fs");
const xml2js = require("xml2js");
const jsonQuery = require("json-query");
//---------------------------------------------------------------------------------
/**
 * Models
 *
 * In Ecore, models are made of packages (EPackage), classifiers (EClass, EDataType, EEnum)
 * and structural features (EAttribute, EReference).
 * A package contains the classifiers while these latter are made of strcutural features.
 */

const readFile = async (type, path) => {
  try {
    const data = {
      ePackage: {
        name: "",
        nsURI: "",
        nsPrefix: "",
        eSubpackages: [],
      },
      content: "",
    };
    // /home/arsene/Downloads/modelset/models/repo-genmymodel-uml/data/_1WJvkPsAEeirA44cXlgljA.xmi
    // "localStorage/artifacts/metamodel/DB-1639678468581.ecore",
    // /home/arsene/Downloads/org.eclipse.epsilon-7a3b2a3fff4206c58c94df1597bfc821830e551f/examples/org.eclipse.epsilon.examples.mergeoo/CopyOO.etl
    // "localStorage/artifacts/metamodel/DB-1639678468581.ecore"

    const readData = fs.readFileSync(path, "utf8");

    if (type === "metamodel") {
      let result = await xml2js.parseStringPromise(readData, {
        mergeAttrs: true,
      });

      if (result["xmi:XMI"]) {
        if (Array.isArray(result["xmi:XMI"]["ecore:EPackage"])) {
          if (result["xmi:XMI"]["ecore:EPackage"][0].name === "PrimitiveTypes")
            result = result["xmi:XMI"]["ecore:EPackage"][1];
          else {
            result = result["xmi:XMI"]["ecore:EPackage"][0];
          }
        } else {
          data.content = minify(readData);
          return data;
        }
      } else if (result["ecore:EPackage"]) {
        result = result["ecore:EPackage"];
      } else {
        data.content = minify(readData);

        return data;
      }

      data.ePackage.name = result.name ? result.name[0] : "";
      data.ePackage.nsURI = result.nsURI ? result.nsURI[0] : "";
      data.ePackage.nsPrefix = result.nsPrefix ? result.nsPrefix[0] : "";

      if (result.eSubpackages) {
        result.eSubpackages.forEach((d) => {
          let m = "yes";
          populator(d, data, m);
        });
      } else {
        populator(result, data);
      }
    }

    data.content = minify(readData);

    return data;
  } catch (err) {
    console.log(err);
  }
};

const populator = (d, data, m) => {
  // console.log(d);
  let esub = {
    name: null,
    nsURI: null,
    nsPrefix: null,
    eClassifiers: [],
  };

  if (Array.isArray(d.name)) esub.name = m ? d?.name[0] : "";
  if (Array.isArray(d.nsURI)) esub.nsURI = m ? d?.nsURI[0] : "";
  if (Array.isArray(d.nsPrefix)) esub.nsPrefix = m ? d?.nsPrefix[0] : "";

  if (Array.isArray(d.eClassifiers))
    d.eClassifiers.forEach((eClass) => {
      esub.eClassifiers.push(eClass.name[0]);
    });

  data.ePackage.eSubpackages.push(esub);

  return esub;
};

const minify = (xmlText) => {
  let text = xmlText.split(/\n|\(\r\n\)|\t/);
  let miniText = "";
  text.forEach((chunk) => {
    miniText += chunk.trim() + " ";
    miniText = miniText.replace(/\s\s+/g, " ");
  });

  return miniText;
};

//---------------------------------------------------------------------------------
// Save ARTIFACT
const uploadFile = (destination) => {
  // Uploading files to the disk rather into the database
  const storage = multer.diskStorage({
    destination: function (req, file, cb) {
      cb(null, "./localStorage/artifacts/" + destination);
    },
    filename: (req, file, cb) => {
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
    },
  });

  return storage;
  // var upload = multer({ storage: storage }).single("file");
  // return upload;
};

//---------------------------------------------------------------------------------
// Deleting the file
const deleteFile = async (path) => {
  fs.access(path, fs.F_OK, async (err, ac) => {
    if (err) {
      return "Error occurred";
    } else {
      await fs.unlink(path, (ferr, fc) => {
        if (ferr) {
          return "Error Occurred On File Deletion!";
        } else {
          return "File deleted successfully!";
        }
      });
    }
  });
};

const uploadLicense = (filePath, licenseName) => {
  try {
    const blob = bucket.file(filePath);

    const blobStream = blob.createWriteStream({
      resumable: false,
      gzip: true,
      public: true,
    });

    blobStream.on("error", (err) => {
      return { message: err.message };
    });

    blobStream.on("finish", async (data) => {
      const publicUrl = format(
        `https://storage.googleapis.com/${bucket.name}/${blob.name}`
      );

      try {
        await bucket.file(licenseName).makePublic();
      } catch {
        return {
          message: `Uploaded the file successfully: ${licenseName}, but public access is denied!`,
          url: publicUrl,
        };
      }

      return {
        message: `Uploaded the file successfully: ${licenseName}`,
        url: publicUrl,
      };
    });

    blobStream.end(req.file.buffer);
  } catch (err) {
    console.log(err);

    if (err.code == "LIMIT_FILE_SIZE") {
      return {
        message: "File size cannot be larger than 2MB!",
      };
    }

    return {
      message: `Could not upload the file: ${licenseName}. ${err}`,
    };
  }
};

module.exports = {
  uploadFile,
  deleteFile,
  readFile,
  uploadLicense,
};
