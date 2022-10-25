const mongoose = require("mongoose");
const Joi = require("joi");

// Creating the schema
const workspaceSchema = new mongoose.Schema(
  {
    name: {
      type: String,
      required: true,
      unique: true,
      index: true,
      minlength: 2,
      maxlength: 50,
    },
    owner: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "User",
      required: true,
    },
    projects: [
      {
        type: mongoose.Schema.Types.ObjectId,
        ref: "Project",
      },
    ],
    description: {
      type: String,
    },
  },

  { timestamps: true }
);

// Function to validate
function validateWorkspace(workspace) {
  let schema = {
    name: Joi.string().min(5).max(50).required(),
    description: Joi.string(),
  };

  return Joi.validate(workspace, schema);
}

// The model
const Workspace = mongoose.model("Workspace", workspaceSchema);

exports.Workspace = Workspace;
exports.validateWorkspace = validateWorkspace;
