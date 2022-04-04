var axios = require("axios");
const download = require("download");
var FormData = require("form-data");
var fs = require("fs");
const { Metamodel } = require("../models/Metamodel");
const { deleteFile } = require("../route/utilities");
var data = new FormData();

const runMetricsInInterval = async () => {
  // Get all metamodels from the cloud cluster
  //      From each metamodel, get the storageUrl and download the artifact
  //      append the name to folder
  //      Calculate the metrics
  //      append the metrics to the metamodel
  //      Delete the downloaded artifact
  const filePath = `/home/arsene/Project/school-projects/mdeforge/advanced-query-mechanisms/persistence-api/localStorage/files`;

  const metamodel = await Metamodel.findById("62340739a98e0b0014e9d1e8");
  console.log(metamodel);
  // metamodels.forEach(async (metamodel) => {
  // const url = metamodel.storageUrl;
  // const completed = await download(url, filePath);
  // setTimeout(() => {
  //   console.log("Waiting before calculating the metrics");
  // }, 3000);

  // if (completed) {
  console.log("Download Completed");
  data.append(
    "atlScript",
    fs.createReadStream(
      `/home/arsene/Project/school-projects/mdeforge/advanced-query-mechanisms/persistence-api/localStorage/files/345_007_063_PNML_simplified--195555209-1647576888606-30.ecore`
    )
  );

  var config = {
    method: "post",
    url: "http://34.67.33.7:8186/mms/transform/metrics",
    headers: {
      ...data.getHeaders(),
    },
    data: data,
  };

  let metrics = await axios(config);
  metrics = metrics.data;

  let i = 0;
  metrics.forEach((metric) => {
    metric.id = i;
    metric.value = parseInt(metric.value);
    i++;
  });

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

  // deleteFile(`${filePath}/${metamodel.unique_name}`);
  // }
  // });
};

module.exports = { runMetricsInInterval };
