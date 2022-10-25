const mongoose = require("mongoose");
const Joi = require("joi");

// Create a schema
const TransformationSchema = new mongoose.Schema({
  name: {
    type: String,
    minlength: 2,
    maxlength: 50,
    unique: true,
  },
  sourceModel: {
    type: String,
  },
  sourceMetamodel: {
    type: String,
  },

  targetMetamodel: {
    type: String,
  },

  script: {
    type: String,
  },
});

// Create the model
const Transformation = mongoose.model("Transformation", TransformationSchema);

const operationSchema = null;

const operationFactory = (type = "transformation") => {
  switch (type) {
    case "transformation":
      return Transformation;
  }

  return operationSchema;
};

exports.operationFactory = operationFactory;
