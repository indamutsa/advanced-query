const {
  GraphQLString,
  GraphQLBoolean,
  GraphQLObjectType,
  GraphQLUnionType,
} = require("graphql");
const { User } = require("../../../../models/User");
const { ProjectType } = require("./Project");
const { UserType } = require("./User");
const { WorkspaceType } = require("./Workspace");

const MessageType = new GraphQLObjectType({
  name: "Message",
  fields: () => ({
    success: { type: GraphQLBoolean },
    message: { type: GraphQLString },
    userData: { type: UserType },
    workspaceData: { type: WorkspaceType },
    projectData: { type: ProjectType },
  }),
});

module.exports = { UserType, MessageType };
