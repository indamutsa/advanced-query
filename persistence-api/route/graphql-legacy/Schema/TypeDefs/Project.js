const { UserType } = require("./User");

const {
  GraphQLObjectType,
  GraphQLID,
  GraphQLString,
  GraphQLList,
} = require("graphql");
const { GraphQLDateTime } = require("graphql-iso-date");

const ProjectType = new GraphQLObjectType({
  name: "Project",
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
    description: {
      type: GraphQLString,
      description: "The username of the user",
    },
    workspace: {
      type: GraphQLID,
      description: "The id of the owner",
    },
    sharedUser: {
      type: new GraphQLList(UserType),
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
module.exports = { ProjectType };
