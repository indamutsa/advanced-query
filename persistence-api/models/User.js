const mongoose = require("mongoose");
const Joi = require("joi");

// Create a schema
const userSchema = new mongoose.Schema(
  {
    username: {
      type: String,
      required: true,
      minlength: 1,
      maxlength: 50,
      unique: true,
    },
    email: {
      type: String,
      required: true,
      minlength: 1,
      maxlength: 50,
    },
  },
  { timestamps: true }
);

// Function to validate
function validateUser(user) {
  let schema = {
    username: Joi.string().min(5).max(50).required(),
    email: Joi.string().min(5).max(50).email().required(),
  };

  return Joi.validate(user, schema);
}

//The model
const User = mongoose.model("User", userSchema);

exports.User = User;
exports.validateUser = validateUser;
