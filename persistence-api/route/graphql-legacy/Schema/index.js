const { GraphQLObjectType, GraphQLSchema } = require("graphql");
const { CREATE_USER, DELETE_USER, UPDATE_USER } = require("./Mutations/user");
const { CREATE_WORKSPACE } = require("./Mutations/workspace");
const {
  GET_USER,
  GET_WORKSPACE_BY_ID,
  GET_PROJECT_BY_ID,
} = require("./Queries");

const RootQuery = new GraphQLObjectType({
  name: "RootQuery",
  fields: {
    getUser: GET_USER,
    getWorkspace: GET_WORKSPACE_BY_ID,
    getProject: GET_PROJECT_BY_ID,
  },
});

const MutationQuery = new GraphQLObjectType({
  name: "Mutation",
  fields: {
    // ------------ User -----------------
    createUser: CREATE_USER,
    deleteUser: DELETE_USER,
    updateUser: UPDATE_USER,
    // ---------Workspace--------------------
    createWorkspace: CREATE_WORKSPACE,
  },
});

const schema = new GraphQLSchema({
  query: RootQuery,
  mutation: MutationQuery,
});

module.exports = {
  schema,
};
