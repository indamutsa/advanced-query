const Services = require("../../../service");

const Query = {
  users: async (parent, args, context, info) => {
    try {
      const result = await Services.getCollections("users");
      const _data = result.hits.hits.map((user) => {
        let id = user._id;
        user = user._source;
        user.id = id;
        return user;
      });

      const data = {
        status_code: 200,
        success: true,
        data: _data,
        message: "Users' data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },

  workspaces: async (parent, args, context, info) => {
    try {
      const result = await Services.getCollections("workspaces");
      const _data = result.hits.hits.map((workspace) => {
        let id = workspace._id;
        workspace = workspace._source;
        workspace.id = id;
        return workspace;
      });

      const data = {
        status_code: 200,
        success: true,
        data: _data,
        message: "Workspaces' data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },

  projects: async (parent, args, context, info) => {
    try {
      const result = await Services.getCollections("projects");
      const _data = result.hits.hits.map((project) => {
        let id = project._id;
        project = project._source;
        project.id = id;
        return project;
      });

      const data = {
        status_code: 200,
        success: true,
        data: _data,
        message: "Projects' data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },

  metamodels: async (parent, args, context, info) => {
    try {
      const result = await Services.getCollections("metamodels");
      const _data = result.hits.hits.map((metamodel) => {
        let id = metamodel._id;
        metamodel = metamodel._source;
        metamodel.id = id;
        return metamodel;
      });

      const data = {
        status_code: 200,
        success: true,
        data: _data,
        message: "Metamodels' data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },

  models: async (parent, args, context, info) => {
    try {
      const result = await Services.getCollections("models");
      const _data = result.hits.hits.map((model) => {
        let id = model._id;
        model = model._source;
        model.id = id;
        return model;
      });

      const data = {
        status_code: 200,
        success: true,
        data: _data,
        message: "Models' data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },

  dsls: async (parent, args, context, info) => {
    try {
      const result = await Services.getCollections("dsls");
      const _data = result.hits.hits.map((dsl) => {
        let id = dsl._id;
        dsl = dsl._source;
        dsl.id = id;
        return dsl;
      });

      const data = {
        status_code: 200,
        success: true,
        data: _data,
        message: "Dsls' data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },

  // ================================================================
  // Basic Queries
  // ================================================================
  user: async (parent, args, context, info) => {
    try {
      const { username, userId } = args;
      const result = await Services.getUser(username, userId);

      const _data = result.hits.hits[0];
      let id = _data._id;
      let user = _data._source;
      user.id = id;

      const data = {
        status_code: 200,
        success: true,
        data: user,
        message: "User data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },

  workspace: async (parent, args, context, info) => {
    try {
      const { workspaceId } = args;
      const result = await Services.getWorkspace(workspaceId);

      const _data = result.hits.hits[0];
      let id = _data._id;
      let workspace = _data._source;
      workspace.id = id;

      const data = {
        status_code: 200,
        success: true,
        data: workspace,
        message: "Workspace data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },
  project: async (parent, args, context, info) => {
    try {
      const { projectId } = args;
      const result = await Services.getProject(projectId);

      const _data = result.hits.hits[0];
      let id = _data._id;
      let project = _data._source;
      project.id = id;

      const data = {
        status_code: 200,
        success: true,
        data: project,
        message: "Project data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },

  workspacesBy: async (parent, args, context, info) => {
    try {
      const { username, userId } = args;
      let user = await Services.getUser(username, userId);
      user = user.hits.hits[0];

      const workspaces = await Services.getWorkspacesBy(user._id);

      const _data = workspaces.hits.hits.map((workspace) => {
        let id = workspace._id;
        workspace = workspace._source;
        workspace.id = id;
        return workspace;
      });

      const data = {
        status_code: 200,
        success: true,
        data: _data,
        message: "Workspaces' data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },

  projectsBy: async (parent, args, context, info) => {
    try {
      const { workspaceId, username, userId } = args;

      if (username) {
        let user = await Services.getUser(username, userId);
        user = user.hits.hits[0];
        userId = user._id;
      }

      const projects = await Services.getProjectsBy(workspaceId, userId);

      const _data = projects.hits.hits.map((project) => {
        let id = project._id;
        project = project._source;
        project.id = id;
        return project;
      });

      const data = {
        status_code: 200,
        success: true,
        data: _data,
        message: "Projects' data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },

  // ================================================================
  // Artifact by id
  // ================================================================
  // - Get model by id
  modelById: async (parent, args, context, info) => {
    try {
      const { modelId } = args;
      const result = await Services.getModelById(modelId);

      const _data = result.hits.hits[0];
      let id = _data._id;
      let model = _data._source;
      model.id = id;

      const data = {
        status_code: 200,
        success: true,
        data: model,
        message: "Model data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },
  metamodelById: async (parent, args, context, info) => {
    try {
      const { metamodelId } = args;
      const result = await Services.getMetamodelById(metamodelId);

      const _data = result.hits.hits[0];
      let id = _data._id;
      let model = _data._source;
      model.id = id;

      const data = {
        status_code: 200,
        success: true,
        data: model,
        message: "Model data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },
  dslById: async (parent, args, context, info) => {
    try {
      const { dslId } = args;
      const result = await Services.getDslById(dslId);

      const _data = result.hits.hits[0];
      let id = _data._id;
      let dsl = _data._source;
      dsl.id = id;

      const data = {
        status_code: 200,
        success: true,
        data: dsl,
        message: "Dsl data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },
  // ================================================================
  // Artifact level queries
  // ================================================================
  // - Get metamodel from a model
  metamodelByValue: async (parent, args, context, info) => {
    try {
      const { field, value, size } = args;
      const result = await Services.getMetamodelByValue(field, value, size);

      const _data = result.hits.hits.map((metamodel) => {
        let id = metamodel._id;
        metamodel = metamodel._source;
        metamodel.id = id;
        return metamodel;
      });

      const data = {
        status_code: 200,
        success: true,
        total_hits: result.hits.total.value,
        data: _data,
        message: "Metamodel data successfully fetched!",
      };

      return data;
    } catch (err) {
      console.log(err.message);
    }
  },

  // workspace: async (parent, args, context, info) => {
  //   try {

  //   } catch (err) {

  //   }
  // },

  // project: async (parent, args, context, info) => {
  //   try {

  //   } catch (err) {

  //   }
  // },
  // metamodel: async (parent, args, context, info) => {
  //   try {

  //   } catch (err) {

  //   }
  // },
  // model: async (parent, args, context, info) => {
  //   try {

  //   } catch (err) {

  //   }
  // },
  // dsl: async (parent, args, context, info) => {
  //   try {

  //   } catch (err) {

  //   }
  // },
};

module.exports = { Query };
