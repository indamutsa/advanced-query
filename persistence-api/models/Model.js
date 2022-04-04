const mongoose = require("mongoose");
const Joi = require("joi");

// Create a schema
const modelSchema = new mongoose.Schema(
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
    metamodel: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "Metamodel",
    },
    project: [
      {
        type: mongoose.Schema.Types.ObjectId,
        ref: "Project",
      },
    ],
    ext: {
      type: String,
      enum: ["XMI", "XML", "MODEL", "UML"],
    },
    license: {
      type: String,
      default: "MIT License",
    },
    type: {
      type: String,
      default: "MODEL",
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
    // artifactId: {
    //   type: mongoose.Schema.Types.ObjectId,
    //   ref: "METAMODEL" || "MODEL" || "DSL",
    // },
    content: {
      type: String,
      unique: true,
    },
  },
  { timestamps: true }
);

// Create the model
const Model = mongoose.model("Model", modelSchema);

// Export the model
exports.Model = Model;
