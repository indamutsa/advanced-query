const { WorkspaceType } = require("./Workspace");

const {
  GraphQLObjectType,
  GraphQLID,
  GraphQLString,
  GraphQLBoolean,
  GraphQLList,
} = require("graphql");
const { GraphQLDateTime } = require("graphql-iso-date");

const UserType = new GraphQLObjectType({
  name: "User",
  description: "This schema represents a user",
  fields: () => ({
    id: {
      type: GraphQLID,
      description: "The id of the user is generated in MongoDb",
    },
    username: {
      type: GraphQLString,
      description: "The username of the user",
    },
    email: {
      type: GraphQLString,
      description: "The email of the user",
    },
    createdAt: {
      type: GraphQLDateTime,
      description: "The email of the user",
    },

    updatedAt: {
      type: GraphQLDateTime,
      description: "The email of the user",
    },
    workspaces: {
      type: new GraphQLList(WorkspaceType),
    },
  }),
});

module.exports = { UserType };
