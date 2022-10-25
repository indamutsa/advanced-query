const mongoose = require("mongoose");
module.exports = function (req, res, next) {
  // To check if the Id is valid
  if (!mongoose.Types.ObjectId.isValid(req.params.id))
    return res.status(404).send("Invalid ID.");

  next();
};
