import { request, gql } from "graphql-request";

const graphQLAPI = process.env.NEXT_PUBLIC_SERVER_ENDPOINT;

export const getData = async (microsyntax) => {
  const query = gql`
    query GeneralDataQuery($microsyntax: String) {
      query(microsyntax: $microsyntax) {
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

  const result = await request(graphQLAPI, query, { microsyntax });

  return result;
};
