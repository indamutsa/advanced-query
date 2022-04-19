var unirest = require("unirest");
const download = require("download");
var FormData = require("form-data");
var fs = require("fs");
const { Metamodel } = require("../models/Metamodel");
const { deleteFile } = require("../route/utilities");

const runMetricsInInterval = async () => {
  // Get all metamodels from the cloud cluster
  //      From each metamodel, get the storageUrl and download the artifact
  //      append the name to folder
  //      Calculate the metrics
  //      append the metrics to the metamodel
  //      Delete the downloaded artifact
  const filePath = `/home/arsene/Project/school-projects/mdeforge/advanced-query-mechanisms/persistence-api/localStorage/files`;

  const metamodels = await Metamodel.find();

  metamodels.forEach(async (metamodel) => {
    const url = metamodel.storageUrl;
    const completed = await download(url, filePath);

    console.log("Download Completed");

    var response = await unirest("POST", "http://localhost:8186/mms/metrics/")
      .attach(
        "ecoreMetamodel",
        `/home/arsene/Project/school-projects/mdeforge/advanced-query-mechanisms/persistence-api/localStorage/files/${metamodel.unique_name}`
      )
      .end(function (res) {
        if (res.error) console.log(res);
        console.log(res.raw_body);
      });

    let metrics = response.data;
    console.log(metrics);

    // metrics.forEach(async (metric) => {
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

    // deleteFile(`${filePath}/${metamodel.unique_name}`);
  });
};

module.exports = { runMetricsInInterval };
