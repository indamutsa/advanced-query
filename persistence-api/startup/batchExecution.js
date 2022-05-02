const unirest = require("unirest");
const download = require("download");
const { Metamodel } = require("../models/Metamodel");
const { deleteFile } = require("../route/utilities");
var axios = require("axios");
var FormData = require("form-data");
var fs = require("fs");

const computeMetrics = async (id) => {
  // Get all metamodels from the cloud cluster
  //      From each metamodel, get the storageUrl and download the artifact
  //      append the name to folder
  //      Calculate the metrics
  //      append the metrics to the metamodel
  //      Delete the downloaded artifact
  const filePath = __dirname + "/../localStorage/files/";
  const metamodel = await Metamodel.findById(id);

  var data = new FormData();
  const path = await createFile(
    filePath + metamodel.unique_name,
    metamodel.content
  );

  data.append("metamodel", fs.createReadStream(`${path}`));

  var config = {
    method: "post",
    url: `${process.env.BASE_URL}:8186/mms/metrics/qualities_and_metrics`,
    enctype: "multipart/form-data",
    processData: false,
    contentType: false,
    mimeType: "multipart/form-data",
    headers: {
      ...data.getHeaders(),
    },
    data: data,
  };

  axios(config)
    .then(async function (response) {
      let metrics = response.data?.metrics;
      metrics.forEach((metric) => {
        metric.value = parseFloat(metric.value);
      });

      let maintainability = {
        name: response?.data?.qualityAttributes[0]?.name,
        value: parseFloat(response?.data?.qualityAttributes[0]?.value),
      };
      metamodel.metrics = [];

      await metrics.push(maintainability);

      metrics.forEach(async (metric) => {
        await Metamodel.findByIdAndUpdate(
          metamodel._id,
          {
            $push: {
              metrics: metric,
            },
          },
          {
            new: true, //To return the updated value
          }
        );
      });

      deleteFile(`${path}`);
    })
    .catch(function (error) {
      console.log(error.message);
    });
};

const updateMany = async () => {
  const metamodels = await Metamodel.find();

  metamodels.forEach(async (metamodel) => {
    let metrics = [];
    await Metamodel.updateOne(
      { _id: metamodel._id },
      { description: "Hello world" }
    );
  });

  return metamodels.length;
};

const createFile = async (filename, content) => {
  await fs.writeFile(filename, content, (err) => {
    if (err) throw err;

    console.log("File created successfully!");
  });
  await sleep(1000);
  return filename;
};

const sleep = async (milliseconds) => {
  await new Promise((resolve) => setTimeout(resolve, milliseconds));
};

module.exports = { computeMetrics, updateMany };
