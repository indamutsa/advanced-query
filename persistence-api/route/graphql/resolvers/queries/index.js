const logger = require("../../../../middleware/logger");
const { Dsl } = require("../../../../models/Dsl");
const { Metamodel } = require("../../../../models/Metamodel");
const { Model } = require("../../../../models/Model");
const { Project } = require("../../../../models/Project");
const { User } = require("../../../../models/User");
const { Workspace } = require("../../../../models/Workspace");
const { UserList } = require("../../../FakeData");

const obj_ = (success, message, data) => {
  return {
    success,
    message,
    data,
  };
};

const Query = {
  user: async (parent, args, context, info) => {
    try {
      const user = await User.findOne({ username: args.username });

      if (user) {
        const workspaces = await Workspace.find({ owner: user._id });
        if (workspaces) user.workspaces = workspaces;

        logger.info("User retrieved successfully!");
        return obj_(true, "User retrieved successfully!", user);
      } else {
        logger.info("No user found!");
        return obj_(true, "No user found", null);
      }
    } catch (err) {
      logger.info("No user found!");
      return obj_(true, err.message, null);
    }
  },

  workspace: async (parent, args, context, info) => {
    try {
      const workspace = await Workspace.findById(args.id);

      if (workspace) {
        const projects = await Project.find({ workspace: workspace._id });
        if (projects) workspace.projects = projects;

        logger.info("Workspace retrieved successfully!");
        return obj_(true, "Workspace retrieved successfully!", workspace);
      } else {
        logger.info("Workspace not found!");
        return obj_(false, "Workspace not found!", null);
      }
    } catch (err) {
      logger.error(err.toString());
      return obj_(false, err.toString(), null);
    }
  },
  project: async (parent, args, context, info) => {
    try {
      const project = await Project.findById(args.id);
      if (project) {
        logger.info("Project retrieved successfully!");
        return obj_(true, "Project retrieved successfully!", project);
      } else {
        logger.info("Project not found!");
        return obj_(false, "Project not found!", null);
      }
    } catch (err) {
      logger.error(err.toString());
      return obj_(false, err.toString(), null);
    }
  },
  metamodel: async (parent, args, context, info) => {
    try {
      const metamodel = await Metamodel.findById(args.id);
      logger.info("Metamodel retrieved successfully!");
      return obj_(true, "Metamodel retrieved successfully!", metamodel);
    } catch (err) {
      logger.error(err.toString());
      return obj_(false, err.toString(), null);
    }
  },
  model: async (parent, args, context, info) => {
    try {
      const model = await Model.findById(args.id);
      console.log(model);
      logger.info("Model retrieved successfully!");
      return obj_(true, "Model retrieved successfully!", model);
    } catch (err) {
      logger.error(err.toString());
      return obj_(false, err.toString(), null);
    }
  },
  dsl: async (parent, args, context, info) => {
    try {
      const dsl = await Dsl.findById(args.id);
      logger.info("Dsl retrieved successfully!");
      return obj_(true, "Dsl retrieved successfully!", dsl);
    } catch (err) {
      logger.error(err.toString());
      return obj_(false, err.toString(), null);
    }
  },
};

module.exports = { Query };
