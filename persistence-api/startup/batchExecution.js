const unirest = require("unirest");
const download = require("download");
const { Metamodel } = require("../models/Metamodel");
const { deleteFile } = require("../route/utilities");
var axios = require("axios");
var FormData = require("form-data");
var fs = require("fs");
const {
  createFile,
  updateMany,
  transformArrayToObj,
  sleep,
} = require("../ad-hoc");

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

  await axios(config)
    .then(async function (response) {
      let metricsData = response.data?.metrics;
      metricsData.forEach((metric) => {
        metric.value = parseFloat(metric.value);
      });

      console.log("Inside the metrics data ---------------------");
      let maintainability = {
        name: response?.data?.qualityAttributes[0]?.name,
        value: parseFloat(response?.data?.qualityAttributes[0]?.value),
      };

      await Metamodel.updateOne({ _id: metamodel._id }, { metric: {} });
      await metricsData.push(maintainability);

      let metric = await transformArrayToObj(metamodel.metrics);
      await Metamodel.updateOne(
        { _id: metamodel._id },
        { modelMetric: metric }
      );

      // metricsData.forEach(async (metric) => {
      //   if (!metric.value) metric.value = -1;
      //   if (!metric.name)
      //     metric.name =
      //       "Metric not retrieved, update the content to trigger compute metrics!";

      //   await Metamodel.findByIdAndUpdate(
      //     metamodel._id,
      //     {
      //       $push: {
      //         metrics: metric,
      //       },
      //     },
      //     {
      //       new: true, //To return the updated value
      //     }
      //   );
      // });

      deleteFile(`${path}`);
    })
    .catch(function (error) {
      console.log(error.message);
    });
};

module.exports = { computeMetrics, updateMany };
