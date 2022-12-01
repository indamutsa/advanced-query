import { request, gql } from "graphql-request";

const graphQLAPI = process.env.NEXT_PUBLIC_SERVER_ENDPOINT;

export const getData = async (microsyntax, from, limit, total) => {
  // console.log(microsyntax, from, limit);
  // if ((from * 10) >= total) {
  //   from = 0;
  //   limit = 10
  // }

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
