const { Query } = require("./queries");

const resolvers = {
  Query,
  // mutations,
  RetObj: {
    __resolveType(obj) {
      // console.log(obj);
      if (obj.username) return "User";
      if (obj.owner) return "Workspace";
      if (obj.workspace) return "Project";
      if (obj.models) return "Metamodel";
      if (obj.metamodel) return "Model";
      if (obj.type === "DSL") return "Dsl";
      return null;
    },
  },
};

module.exports = { resolvers };
