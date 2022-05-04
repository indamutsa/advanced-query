const { Metamodel } = require("../models");

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

const updateMetrics = async () => {
  //   await Metamodel.updateMany({}, { $unset: { metrics: 1 } });

  try {
    const metamodels = await Metamodel.find();
    metamodels.forEach(async (metamodel, i) => {
      let metric = await transformArrayToObj(metamodel.metrics);
      await Metamodel.updateOne(
        { _id: metamodel._id },
        { modelMetric: metric }
      );
    });
  } catch (err) {
    console.log(err);
  }
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

const transformArrayToObj = async (metrics) => {
  let obj = "";
  metrics.forEach((metric, i) => {
    let mapper = `
          "${metric.name === "maintainability" ? "MTNB" : metric.code}": {
              "name": "${metric.name}",
              "code": "${
                metric.name === "maintainability" ? "MTNB" : metric.code
              }",
              "value": ${metric.value}
          },`;

    if (i === 0) {
      obj = `{ 
                  "metrics": {
                      ${mapper}
          `;
    }

    if (i > 0) obj += mapper;
    i++;
  });

  obj = obj.slice(0, -1) + "}}";

  try {
    obj = JSON.parse(obj);
  } catch (err) {
    obj = {};
  }

  return obj;
};

module.exports = {
  createFile,
  updateMany,
  transformArrayToObj,
  sleep,
  updateMetrics,
};
