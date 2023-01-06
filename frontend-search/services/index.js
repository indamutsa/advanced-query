import { request, gql } from "graphql-request";

const graphQLAPI = process.env.NEXT_PUBLIC_SERVER_ENDPOINT;

// Microsyntax oriented search
export const getData = async (microsyntax, from, limit, total) => {
  const query = gql`
    query GeneralDataQuery($microsyntax: String, $from: Int=0, $limit: Int=10) {
      query(microsyntax: $microsyntax, from: $from, limit: $limit) {
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
          }

          ... on Dsl {
            id
            name
            storageUrl
            size
            createdAt
            description
            type
          }

          ... on Metamodel {
            id
            name
            storageUrl
            size
            createdAt
            description
            type
          }
        }
      }
    }
  `;

  const result = await request(graphQLAPI, query, { microsyntax, from, limit });

  return result;
};


// Advanced search
export const getAdvancedSearchData = async (object, from, limit, total) => {
  // let object = JSON.stringify(obj);
  // console.log(object)

  const query = gql`
    query advancedSearchQuery($object: GraphQLJSON, $from: Int=0, $limit: Int=10) {
      advancedQuery(object: $object, from: $from, limit: $limit) {
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
          }

          ... on Dsl {
            id
            name
            storageUrl
            size
            createdAt
            description
            type
          }

          ... on Metamodel {
            id
            name
            storageUrl
            size
            createdAt
            description
            type
          }
        }
      }
    }
  `;

  const result = await request(graphQLAPI, query, { object, from, limit });

  return result;
};
