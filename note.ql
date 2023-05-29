# Write your query or mutation here
# {
#   user(username:"arsene"){
#     success
#     message
#     data{
#       ...on User{
#         id
#       }
#     }

#   }
# }

# {
#   workspace(userId:"6270277a6320d300138ce4cc"){
#     success
#     message
#     data{
#       ...on Workspace{
#         id
#       }
#     }

#   }
# }

# 625d45c03cb5dfff13033971

{
  model(id: "62702ea66320d300138da861") {
    success
    message
    data {
      ... on Model {
        id
        content
      }
    }
  }
}

{
  query(microsyntax: "microsyntax") {
    status_code
    message
    success
    total_hits

    data {
      ... on Model {
        id
        name
        storageUrl
        size
        createdAt
        description
        type
        content
      }

      ... on Dsl {
        id
        name
        storageUrl
        size
        createdAt
        description
        type
        content
      }

      ... on Metamodel {
        id
        name
        storageUrl
        size
        createdAt
        description
        type
        content
      }
    }
  }
}
