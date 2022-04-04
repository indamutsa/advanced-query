const mongoose = require("mongoose");
const Joi = require("joi");

require("mongoose-double")(mongoose);
const { Schema } = mongoose;

// Create a schema
const metamodelSchema = new Schema(
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

    type: {
      type: String,
      default: "METAMODEL",
    },

    ext: {
      type: String,
      enum: ["ECORE", "MPS"],
    },

    project: [
      {
        type: Schema.Types.ObjectId,
        ref: "Project",
      },
    ],

    models: [
      {
        type: Schema.Types.ObjectId,
        ref: "Model",
      },
    ],

    involvedOperations: [
      {
        type: String,
        ref: "Transformation",
      },
    ],
    license: {
      type: String,
      default: "MIT License",
      url: {
        type: String,
      },
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
    accessControl: {
      type: String,
      enum: ["PRIVATE", "PUBLIC"],
      default: "PUBLIC",
    },
    comment: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "COMMENT",
    },
    metrics: [
      {
        id: {
          type: Number,
        },
        name: {
          type: String,
        },
        value: {
          type: Number,
        },
      },
    ],
    content: {
      type: String,
      unique: true,
    },

    ePackage: {
      name: {
        type: String,
        default: "default",
      },
      nsURI: {
        type: String,
      },
      nsPrefix: {
        type: String,
      },
      eSubpackages: [
        {
          name: {
            type: String,
          },
          nsURI: {
            type: String,
          },
          nsPrefix: {
            type: String,
          },
          eClassifiers: [],
        },
      ],
    },
  },
  { timestamps: true }
);

// Create the model
const Metamodel = mongoose.model("Metamodel", metamodelSchema);

// Export the model
exports.Metamodel = Metamodel;
