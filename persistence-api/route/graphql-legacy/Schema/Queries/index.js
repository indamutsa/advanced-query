const { UserType } = require("../TypeDefs/User");
const { GraphQLList, GraphQLString, GraphQLObjectType } = require("graphql");
const { User } = require("../../../../models/User");
const { WorkspaceType } = require("../TypeDefs/Workspace");
const { Workspace } = require("../../../../models/Workspace");
const { MessageType } = require("../TypeDefs");
const logger = require("../../../../middleware/logger");
const { Project } = require("../../../../models/Project");

exports.GET_USER = {
  type: MessageType,
  description: "This endpoint returns the user and her workspaces",
  args: {
    username: {
      type: GraphQLString,
    },
  },
  resolve: async (parent, args) => {
    try {
      const user = await User.findOne({ username: args.username });
      if (user) {
        const workspaces = await Workspace.find({ owner: user._id });
        if (workspaces) user.workspaces = workspaces;
        logger.info("User retrieved successfully!");
        return {
          success: true,
          message: "User retrieved successfully!",
          userData: user,
        };
      } else {
        return { message: "No user found", data: null };
      }
    } catch (err) {
      return { message: err.message, data: null };
    }
  },
};

exports.GET_WORKSPACE_BY_ID = {
  type: MessageType,
  description: "This endpoint returns user workspace and her projects",
  args: {
    id: {
      type: GraphQLString,
    },
  },
  resolve: async (parent, args) => {
    try {
      const workspace = await Workspace.findOne({ _id: args.id });
      if (workspace) {
        logger.info("Workspace retrieved successfully!");
        return {
          success: true,
          message: "Workspace retrieved successfully!",
          workspaceData: workspace,
        };
      } else {
        return { message: "No workspace found", workspaceData: null };
      }
    } catch (err) {
      return { message: err.message, workspaceData: null };
    }
  },
};

exports.GET_PROJECT_BY_ID = {
  type: MessageType,
  description: "This endpoint returns project by id",
  args: {
    id: {
      type: GraphQLString,
    },
  },
  resolve: async (parent, args) => {
    try {
      const project = await Project.findOne({ _id: args.id });
      if (project) {
        logger.info("Project retrieved successfully!");
        return {
          success: true,
          message: "Project retrieved successfully!",
          projectData: project,
        };
      } else {
        return {
          success: false,
          message: "Project by the id specified does not exist!",
          projectData: null,
        };
      }
    } catch (err) {
      return { success: false, message: err.message, projectData: null };
    }
  },
};
