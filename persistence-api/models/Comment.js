const mongoose = require("mongoose");
const Joi = require("joi");

// Creating the schema
const commentSchema = new mongoose.Schema(
  {
    text: {
      type: String,
      required: true,
    },
    star: {
      type: Number,
      enum: [1, 2, 3, 4, 5],
    },
    user: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "User",
    },
  },
  { timestamps: true }
);

// Function to validate
function validateComment(comment) {
  let schema = {
    text: Joi.string().required(),
    star: Joi.number(),
  };

  return Joi.validate(comment, schema);
}

// The model
const Comment = mongoose.model("Comment", commentSchema);

exports.Comment = Comment;
exports.validate = validateComment;
