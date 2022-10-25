const { Dsl } = require("../../../models/Dsl");
const { Metamodel } = require("../../../models/Metamodel");
const { Model } = require("../../../models/Model");
const { Project } = require("../../../models/Project");
const { User } = require("../../../models/User");
const { Workspace } = require("../../../models/Workspace");

const { Query } = require("./queries");
// const { Mutation } = require("./mutations");

const resolvers = {
  Query,
  //   mutations,
  ReturnedData: {
    __resolveType(obj) {
      if (obj instanceof User) return "User";
      if (obj instanceof Workspace) return "Workspace";
      if (obj instanceof Project) return "Project";
      if (obj instanceof Metamodel) return "Metamodel";
      if (obj instanceof Model) return "Model";
      if (obj instanceof Dsl) return "Dsl";

      return null;
    },
  },
};

module.exports = { resolvers };
