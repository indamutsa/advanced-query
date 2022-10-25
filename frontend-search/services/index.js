<<<<<<< HEAD
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
          }

          ... on Dsl {
            id
            name
            storageUrl
            size
            createdAt
            description
          }

          ... on Metamodel {
            id
            name
            storageUrl
            size
            createdAt
            description
          }
        }
      }
    }
  `;

  const result = await request(graphQLAPI, query, { microsyntax });

  return result;
};
=======
import { request, gpl } from "graphql-request";
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
