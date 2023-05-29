const mongoose = require("mongoose");
const Joi = require("joi");

// Create a schema
const artifactSchema = new mongoose.Schema(
  {
    type: {
      type: String,
      enum: ["MODEL", "METAMODEL", "DSL"],
    },

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
    license: {
      type: String,
      default: "MIT License",
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
    artifactId: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "METAMODEL" || "MODEL" || "DSL",
    },
    content: {
      type: String,
    },
  },
  { timestamps: true }
);

// VALIDATION
function validateArtifact(artifact) {
  let schema = {
    name: Joi.string().min(5).max(50).required(),
    type: Joi.string().required(),
    storageUrl: Joi.string().required(),
    description: Joi.string().required(),
    artifactFile: Joi.object.required(),
  };

  return Joi.validate(artifact, schema);
}

const Artifact = mongoose.model("Artifact", artifactSchema);

exports.Artifact = Artifact;
exports.validate = validateArtifact;
