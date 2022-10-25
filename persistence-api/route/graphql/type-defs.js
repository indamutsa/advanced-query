const { gql } = require("apollo-server-express");
const typeDefs = gql`
  # schema.gql
  scalar GraphQLDateTime

  "The schema of the user"
  type User {
    id: ID!
    username: String!
    email: String!
    createdAt: GraphQLDateTime
    updatedAt: GraphQLDateTime
    workspaces: [Workspace]
  }

  type Query {
    user(username: String!): MessageType!
    workspace(id: String, userId: String): MessageType!
    project(id: String!): MessageType!
    metamodel(id: String!): MessageType!
    model(id: String!): MessageType!
    dsl(id: String!): MessageType!
  }

  type Workspace {
    id: ID!
    name: String!
    "The id of the owner"
    owner: String!
    projects: [Project]
    description: String
    createdAt: GraphQLDateTime
    updatedAt: GraphQLDateTime
  }

  "This schema represents a workspace"
  type Project {
    "The id of the user is generated in MongoDb"
    id: ID!
    "The username of the user"
    name: String!
    "The username of the user"
    description: String
    "The id of the workspace"
    workspace: String
    sharedUser: [User]
    createdAt: GraphQLDateTime
    updatedAt: GraphQLDateTime
  }

  type Metamodel {
    id: ID
    name: String!
    project: String!
    type: String
    models: [ID]
    artifact: ID
    content: String
    ePackage: Package
    eClass: [String]
  }

  type Package {
    name: String
    nsURI: String
    nsPrefix: String
  }

  type Model {
    id: ID
    name: String!
    metamodel: String!
    project: ID
    type: String
    artifact: ID
    content: String
  }

  type Dsl {
    id: ID
    name: String!
    project: ID
    type: String
    artifact: ID
    content: String
  }

  type MessageType {
    success: Boolean
    message: String
    data: ReturnedData
  }

  union ReturnedData = User | Workspace | Project | Metamodel | Model | Dsl
`;

module.exports = { typeDefs };
