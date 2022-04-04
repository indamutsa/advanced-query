const { gql } = require("apollo-server-express");
const typeDefs = gql`
  # schema.gql
  scalar GraphQLDateTime
  """
  Queries are defined here, they need to have the same name in resolvers
  """
  type Query {
    users: Data!
    workspaces: Data!
    projects: Data!
    metamodels: Data!
    models: Data!
    dsls: Data!
    user(username: String, userId: String): collData!
    # ===================================
    workspacesBy(username: String, userId: String): Data!
    workspace(workspaceId: String): collData!
    project(projectId: String): collData!
    projectsBy(workspaceId: String, username: String, userId: String): Data!
    # ===================================
    modelById(modelId: String): collData!
    metamodelById(metamodelId: String): collData!
    dslById(dslId: String): collData!
    # ===================================
    metamodelByValue(field: String, value: String, size: Int = 5): Data!
  }

  """
  The type of the user
  """
  type User {
    id: ID!
    "Hello world"
    username: String
    email: String
    createdAt: GraphQLDateTime
    updatedAt: GraphQLDateTime
  }
  """
  The type of the workspace
  """
  type Workspace {
    id: ID!
    name: String
    owner: String
    description: String
    projects: [String]
    createdAt: GraphQLDateTime
    updatedAt: GraphQLDateTime
  }

  """
  The type of the project
  """
  type Project {
    id: ID!
    name: String
    workspace: String
    user: String
    description: String
    sharedUser: [String]
    comments: [String]
    createdAt: GraphQLDateTime
    updatedAt: GraphQLDateTime
  }

  """
  The type of the model
  """
  type Model {
    id: ID!
    accessControl: String
    description: String
    ext: String
    involvedOperations: [String]
    name: String
    metamodel: String
    project: String
    storageUrl: String
    type: String
    size: Int
    unique_name: String
    createdAt: GraphQLDateTime
    updatedAt: GraphQLDateTime
  }

  """
  The type of the dsl
  """
  type Dsl {
    id: ID!
    accessControl: String
    description: String
    ext: String
    involvedOperations: [String]
    name: String
    project: String
    storageUrl: String
    type: String
    size: Int
    unique_name: String
    createdAt: GraphQLDateTime
    updatedAt: GraphQLDateTime
  }

  """
  The type of the metamodel
  """
  type Metamodel {
    id: ID!
    accessControl: String
    ePackage: ePackage
    description: String
    ext: String
    involvedOperations: [String]
    models: [String]
    name: String
    project: [String]
    storageUrl: String
    type: String
    size: Int
    unique_name: String
    createdAt: GraphQLDateTime
    updatedAt: GraphQLDateTime
  }

  """
  The type of the sub-type used in epackage type
  """
  type eSubpackage {
    name: String
    nsPrefix: String
    nsURI: String
    eClassifiers: [String]
  }

  """
  The type of the sub-type used in metamodel type
  """
  type ePackage {
    name: String
    nsPrefix: String
    nsURI: String
    eSubpackages: [eSubpackage]
  }

  type Message {
    message: String
  }

  """
  The returned data when it is an array of collections
  """
  type Data {
    status_code: Int
    message: String
    success: Boolean
    total_hits: Int
    data: [RetObj]
  }

  """
  The returned data when it is an object of a collection
  """
  type collData {
    status_code: Int
    message: String
    success: Boolean
    data: RetObj
  }

  union RetObj = User | Workspace | Project | Metamodel | Model | Dsl
`;

module.exports = { typeDefs };
