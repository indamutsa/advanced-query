const { GraphQLNonNull, GraphQLString } = require("graphql");
const { MessageType, UserType } = require("../TypeDefs");
const { User } = require("../../../../models/User");
const logger = require("../../../../middleware/logger");
const { Workspace } = require("../../../../models/Workspace");

const CREATE_WORKSPACE = {
  type: MessageType,
  args: {
    name: { type: new GraphQLNonNull(GraphQLString) },
    owner: { type: new GraphQLNonNull(GraphQLString) },
    description: { type: GraphQLString },
  },
  resolve: async (parent, args, context, info) => {
    const { name, owner, description } = args;

    const user = await User.findOne({ owner });
    if (!user) {
      try {
        const newWorkspace = new Workspace({ name, owner, description });
        const savedWorkspace = await newWorkspace.save();

        logger.info("Workspace was created successfully!");

        return {
          message: "Workspace was created successfully!",
          workspaceData: savedWorkspace,
        };
      } catch (err) {
        return { message: err.message, workspaceData: null };
      }
    } else {
      logger.warn("The workspace or the user do not exists!");
      return {
        message: "The workspace or the user do not exists!",
        workspaceData: null,
      };
    }
  },
};

module.exports = { CREATE_WORKSPACE };

// export const DELETE_USER = {
//   type: MessageType,
//   args: {
//     id: { type: GraphQLString },
//   },
//   resolve: async (parent, args) => {
//     const user = await User.findById(args.id);
//     if (user) {
//       try {
//         await user.delete();
//         logger.info("User deleted successfully!");
//         return { success: true, message: "User deleted successfully!" };
//       } catch (err) {
//         logger.error(err.toString());
//         return { success: false, message: err.message };
//       }
//     } else {
//       logger.warn("The user specified does not exist!");
//       return { success: false, message: "The user specified does not exist!" };
//     }
//   },
// };

// export const UPDATE_USER = {
//   type: MessageType,
//   args: {
//     id: { type: GraphQLString },
//     username: { type: GraphQLString },
//     email: { type: GraphQLString },
//   },
//   resolve: async (parent, args) => {
//     const { id } = args;
//     const user = await User.findById(args.id);
//     if (user) {
//       try {
//         const updatedUser = await User.findByIdAndUpdate(
//           id,
//           {
//             $set: args,
//           },
//           { new: true }
//         );
//         logger.info("User updated successfully!");
//         return {
//           success: true,
//           message: "User updated successfully!",
//           userData: updatedUser,
//         };
//       } catch (err) {
//         logger.error(err.toString());
//         return { success: false, message: err.message };
//       }
//     } else {
//       logger.warn("The user specified does not exist!");
//       return { success: false, message: "The user specified does not exist!" };
//     }
//   },
// };
