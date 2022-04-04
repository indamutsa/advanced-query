const {
  GraphQLObjectType,
  GraphQLID,
  GraphQLString,
  GraphQLList,
} = require("graphql");
const { GraphQLDateTime } = require("graphql-iso-date");

const WorkspaceType = new GraphQLObjectType({
  name: "Workspace",
  description: "This schema represents a workspace",
  fields: () => ({
    id: {
      type: GraphQLID,
      description: "The id of the user is generated in MongoDb",
    },
    name: {
      type: GraphQLString,
      description: "The username of the user",
    },
    owner: {
      type: GraphQLID,
      description: "The id of the owner",
    },
    //   projects: {
    //     type: new GraphQLList(ProjectType)
    // },
    description: {
      type: GraphQLString,
      description: "The username of the user",
    },
    createdAt: {
      type: GraphQLDateTime,
      description: "The email of the user",
    },
    updatedAt: {
      type: GraphQLDateTime,
      description: "The email of the user",
    },
  }),
});

module.exports = { WorkspaceType };
