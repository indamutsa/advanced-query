const mongoose = require("mongoose");
const Joi = require("joi");

// Creating the schema
const projectSchema = new mongoose.Schema(
  {
    name: {
      type: String,
      required: true,
      index: true,
      unique: true,
      minlength: 5,
      maxlength: 50,
    },

    description: {
      type: String,
    },
    user: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "User",
    },
    workspace: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "Project",
    },

    sharedUser: [
      {
        type: mongoose.Schema.Types.ObjectId,
        ref: "User",
      },
    ],
    comments: [
      {
        type: mongoose.Schema.Types.ObjectId,
        ref: "Comment",
      },
    ],
  },
  { timestamps: true }
);

// Function to validate
function validateProject(project) {
  let schema = {
    name: Joi.string().min(5).max(50).required(),
    description: Joi.string(),
  };
  return Joi.validate(project, schema);
}

// The model
const Project = mongoose.model("Project", projectSchema);

exports.Project = Project;
exports.validateProject = validateProject;
