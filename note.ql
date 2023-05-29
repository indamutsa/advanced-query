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

{
  workspace(workspaceId:"6474fc744d2e0c001329252b"){
    success
    message
    data{
    	...on Workspace{
        id
      }
    }
  }
}

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
