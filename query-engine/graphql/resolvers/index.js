const { Query } = require("./queries");

const resolvers = {
      Query,
      // mutations,
      RetObj: {
            __resolveType(obj) {
                  if (obj.username) return "User";
                  if (obj.owner) return "Workspace";
                  if (obj.workspace) return "Project";
                  if (obj.models) return "Metamodel";
                  if (obj.metamodel) return "Model";
                  if (obj.type === "DSL") return "Dsl";
                  if (obj.type === "MODEL") return "Model";
                  if (obj.type === "METAMODEL") return "Metamodel";
                  return "Data";
            },
      },
};

module.exports = { resolvers };
