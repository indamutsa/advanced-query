console.log("Oh Yeah!");
const express = require("express");
const database = require("./database");
const app = express();

console.log("Cluster initializing...");
database.initializeMongo();

app.get("/", function (req, res) {
  res.send("Hello,\nCluster initialized!");
});

app.listen(3000, function () {
  console.log("App listening on port 3200");
});

// A route to return all saved kittens
app.get("/testFind", function (req, res) {
  database.Kitten.find(function (err, kittens) {
    if (err) return res.error(err);
    console.log(kittens);
    res.json(kittens);
  });
});
