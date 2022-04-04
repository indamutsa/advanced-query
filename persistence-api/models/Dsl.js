const mongoose = require("mongoose");
const Joi = require("joi");

// Create a schema
const dslSchema = new mongoose.Schema(
  {
    name: {
      type: String,
      required: true,
      // minlength: 2,
      // maxlength: 50,
    },
    unique_name: {
      type: String,
      require: true,
      unique: true,
    },
    project: [
      {
        type: mongoose.Schema.Types.ObjectId,
        ref: "Project",
      },
    ],
    ext: {
      type: String,
      enum: ["ETL", "EOL", "EML", "ECL", "EVL", "ATL"],
    },
    type: {
      type: String,
      default: "DSL",
    },
    license: {
      type: String,
      default: "MIT License",
    },
    // artifact: {
    //   type: mongoose.Schema.Types.ObjectId,
    //   ref: "Artifact",
    // },
    involvedOperations: [
      {
        type: String,
        ref: "Transformation",
      },
    ],
    storageUrl: {
      type: String,
      required: true,
      // minlength: 5,
      // maxlength: 200,
    },
    size: {
      type: Number,
      required: true,
    },
    description: {
      type: String,
    },
    accessControl: {
      type: String,
      enum: ["PRIVATE", "PUBLIC"],
      default: "PUBLIC",
    },
    comment: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "COMMENT",
    },
    content: {
      type: String,
      unique: true,
    },
  },
  { timestamps: true }
);

// Create the model
const Dsl = mongoose.model("Dsl", dslSchema);
// Export the model
exports.Dsl = Dsl;
