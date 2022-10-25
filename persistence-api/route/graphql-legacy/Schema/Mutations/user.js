const { GraphQLString } = require("graphql");
const { MessageType, UserType } = require("../TypeDefs");
const { User } = require("../../../../models/User");
const logger = require("../../../../middleware/logger");

const CREATE_USER = {
  type: MessageType,
  args: {
    username: { type: GraphQLString },
    email: { type: GraphQLString },
  },
  resolve: async (parent, args, context, info) => {
    const { username, email } = args;
    const user = await User.findOne({ username });
    if (!user) {
      try {
        const newUser = await User({ username, email });
        const savedUser = await newUser.save();

        console.log(newUser);
        logger.info("User was created successfully!");
        return {
          message: "User was created successfully!",
          userData: savedUser,
        };
      } catch (err) {
        return { message: err.message, userData: null };
      }
    } else {
      logger.warn("The user already exists!");
      return { message: "User already exists!", userData: null };
    }
  },
};

const DELETE_USER = {
  type: MessageType,
  args: {
    id: { type: GraphQLString },
  },
  resolve: async (parent, args) => {
    const user = await User.findById(args.id);
    if (user) {
      try {
        await user.delete();
        logger.info("User deleted successfully!");
        return { success: true, message: "User deleted successfully!" };
      } catch (err) {
        logger.error(err.toString());
        return { success: false, message: err.message };
      }
    } else {
      logger.warn("The user specified does not exist!");
      return { success: false, message: "The user specified does not exist!" };
    }
  },
};

const UPDATE_USER = {
  type: MessageType,
  args: {
    id: { type: GraphQLString },
    username: { type: GraphQLString },
    email: { type: GraphQLString },
  },
  resolve: async (parent, args) => {
    const { id } = args;
    const user = await User.findById(args.id);
    if (user) {
      try {
        const updatedUser = await User.findByIdAndUpdate(
          id,
          {
            $set: args,
          },
          { new: true }
        );
        logger.info("User updated successfully!");
        return {
          success: true,
          message: "User updated successfully!",
          userData: updatedUser,
        };
      } catch (err) {
        logger.error(err.toString());
        return { success: false, message: err.message };
      }
    } else {
      logger.warn("The user specified does not exist!");
      return { success: false, message: "The user specified does not exist!" };
    }
  },
};

module.exports = { CREATE_USER, UPDATE_USER, DELETE_USER };
