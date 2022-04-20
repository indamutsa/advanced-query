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
  const filePath = `/home/arsene/Project/school-projects/mdeforge/advanced-query-mechanisms/persistence-api/localStorage/files/`;
  const metamodel = await Metamodel.findById(id);

  var data = new FormData();

  const url = metamodel.storageUrl;
  const completed = await download(url, filePath);

  data.append(
    "metamodel",
    fs.createReadStream(`${filePath}${metamodel.unique_name}`)
  );

  var config = {
    method: "post",
    url: `${process.env.BASE_URL}:8186/mms/metrics/qualities_and_metrics`,
    headers: {
      ...data.getHeaders(),
    },
    data: data,
  };

  axios(config)
    .then(async function (response) {
      let metrics = response.data.metrics;
      let maintainability = {
        name: response.data.qualityAttributes[0].name,
        value: response.data.qualityAttributes[0].value,
      };

      await metrics.push(maintainability);

      metamodel.metrics = [];

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

      deleteFile(`${filePath}${metamodel.unique_name}`);
    })
    .catch(function (error) {
      console.log(error.message);
    });
};

module.exports = { computeMetrics };
