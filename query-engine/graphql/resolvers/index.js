const { Query } = require("./queries");

const resolvers = {
  Query,
  // mutations,
  RetObj: {
    __resolveType(obj) {
<<<<<<< HEAD
=======
      // console.log(obj);
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
      if (obj.username) return "User";
      if (obj.owner) return "Workspace";
      if (obj.workspace) return "Project";
      if (obj.models) return "Metamodel";
      if (obj.metamodel) return "Model";
      if (obj.type === "DSL") return "Dsl";
<<<<<<< HEAD
      if (obj.type === "MODEL") return "Model";
      if (obj.type === "METAMODEL") return "Metamodel";
      return "Data";
=======
      if (obj.ext === "UML") return "Dsl";
      return null;
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
    },
  },
};

module.exports = { resolvers };
