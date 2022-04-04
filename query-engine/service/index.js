const esconfig = require("../config/esConfig");
const client = esconfig.esClient;
const config = require("../config");
const index = config.es_index;
const type = config.es_type;

const esb = require("elastic-builder"); //the builder

module.exports = {
  async search() {
    const requestBody = esb
      .requestBodySearch()
      .query(esb.matchAllQuery())
      .size(5)
      .from(1);

    const data = await client.search({
      index: index,
      body: requestBody.toJSON(),
    });

    return data;
  },

  async getCollections(collection) {
    const requestBody = esb.requestBodySearch().query(esb.matchAllQuery());

    const data = await client.search({
      index: index + collection,
      body: requestBody.toJSON(),
    });

    return data;
  },

  async getUser(username, userId) {
    let requestBody = null;

    if (!username) username = "nothing";
    if (!userId) userId = "nothing";

    requestBody = esb
      .requestBodySearch()
      .query(
        esb
          .boolQuery()
          .should([
            esb.matchPhraseQuery("username", username),
            esb.matchPhraseQuery("_id", userId),
          ])
      );

    const data = await client.search({
      index: index + "users",
      body: requestBody.toJSON(),
    });

    return data;
  },

  async getWorkspace(id) {
    let requestBody = null;

    requestBody = esb
      .requestBodySearch()
      .query(esb.matchPhraseQuery("_id", id));

    const data = await client.search({
      index: index + "workspaces",
      body: requestBody.toJSON(),
    });

    return data;
  },

  async getProject(id) {
    let requestBody = null;

    requestBody = esb
      .requestBodySearch()
      .query(esb.matchPhraseQuery("_id", id));

    const data = await client.search({
      index: index + "projects",
      body: requestBody.toJSON(),
    });

    return data;
  },

  async getWorkspacesBy(owner) {
    let requestBody = null;
    requestBody = esb
      .requestBodySearch()
      .query(esb.boolQuery().must(esb.matchPhraseQuery("owner", owner)));

    const data = await client.search({
      index: index + "workspaces",
      body: requestBody.toJSON(),
    });

    return data;
  },

  async getProjectsBy(workspace, userId) {
    let requestBody = null;
    if (!userId) userId = "nothing";
    if (!workspace) workspace = "nothing";

    requestBody = esb
      .requestBodySearch()
      .query(
        esb
          .boolQuery()
          .should([
            esb.matchPhraseQuery("workspace", workspace),
            esb.matchPhraseQuery("user", userId),
          ])
      );

    const data = await client.search({
      index: index + "projects",
      body: requestBody.toJSON(),
    });

    return data;
  },

  // Get artifacts with the size, the type and the keywords
  async getDroidData(size, ext, keywords) {
    let requestBody = null;
    if (!size) size = -1;

    // requestBody = esb
    //   .requestBodySearch()
    //   .query(
    //     esb
    //       .matchQuery("content": )
    //       // .boolQuery()
    //       // .should([
    //       //   esb.matchPhraseQuery("ext", ext),
    //       //   esb.matchQuery("content", keyword),
    //       // ])
    //   )
    //   .size(size);

    const data = await client.search({
      index: index + "*",
      body: {
        size: size,
        query: {
          bool: {
            must: [
              {
                match_phrase: {
                  ext: ext,
                },
              },
              {
                match: {
                  content: {
                    query: keywords,
                    minimum_should_match: 1,
                  },
                },
              },
            ],
          },
        },
      },
    });

    return data;
  },

  // ================================================================
  // Artifact level queries
  // ================================================================
  // Get artifact by Id
  async getModelById(id) {
    let requestBody = null;

    requestBody = esb
      .requestBodySearch()
      .query(esb.matchPhraseQuery("_id", id));

    const data = await client.search({
      index: index + "models",
      body: requestBody.toJSON(),
    });

    return data;
  },
  async getMetamodelById(id) {
    let requestBody = null;

    requestBody = esb
      .requestBodySearch()
      .query(esb.matchPhraseQuery("_id", id));

    const data = await client.search({
      index: index + "metamodels",
      body: requestBody.toJSON(),
    });

    return data;
  },
  async getDslById(id) {
    let requestBody = null;

    requestBody = esb
      .requestBodySearch()
      .query(esb.matchPhraseQuery("_id", id));

    const data = await client.search({
      index: index + "dsls",
      body: requestBody.toJSON(),
    });
    return data;
  },

  // - Get metamodel from a model
  async getMetamodelByValue(field, value, size) {
    let requestBody = esb
      .requestBodySearch()
      .query(esb.matchPhraseQuery(field, value))
      .size(size);

    const data = await client.search({
      index: index + "metamodels",
      body: requestBody.toJSON(),
    });

    return data;
  },

  // async filterCarsByYearMade(param1, param2) {
  //   // console.log(param1, param2);
  //   const requestBody = esb
  //     .requestBodySearch()
  //     .query(
  //       esb
  //         .boolQuery()
  //         .must(esb.matchAllQuery())
  //         .filter(esb.rangeQuery("Year").gte(param1).lte(param2))
  //     );
  //   return client.search({
  //     index: index,
  //     body: requestBody.toJSON(),
  //   });
  // },

  // async filterCarsByName(param) {
  //   const requestBody = esb
  //     .requestBodySearch()
  //     .query(esb.termQuery("Name", param))
  //     .sort(esb.sort("Year", "asc"))
  //     .from(1)
  //     .size(10);
  //   return client.search({
  //     index: index,
  //     body: requestBody.toJSON(),
  //   });
  // },

  // async fetchCarByName(param) {
  //   const requestBody = esb
  //     .requestBodySearch()
  //     .query(esb.boolQuery().must(esb.matchPhraseQuery("Name", param)));
  //   return client.search({
  //     index: index,
  //     body: requestBody.toJSON(),
  //   });
  // },

  // async fetchMatchMultipleQuery(origin, name, weight) {
  //   const requestBody = esb.requestBodySearch().query(
  //     esb
  //       .boolQuery()
  //       .must([esb.matchQuery("Origin", origin), esb.matchQuery("Name", name)])
  //       .filter(esb.rangeQuery("Weight_in_lbs").gte(weight))
  //   );
  //   return client.search({
  //     index: index,
  //     body: requestBody.toJSON(),
  //   });
  // },

  // async aggregateQuery(origin, cylinder, name, horsePower) {
  //   const requestBody = esb.requestBodySearch().query(
  //     esb
  //       .boolQuery()
  //       .must(esb.matchQuery("Origin", origin))
  //       .filter(esb.rangeQuery("Cylinders").gte(cylinder))
  //       .should(esb.termQuery("Name", name))
  //       .mustNot(esb.rangeQuery("Horsepower").gte(horsePower))
  //     // .agg(esb.avgAggregation('avg_miles', 'Miles_per_Gallon'))
  //   );
  //   return client.search({
  //     index: index,
  //     body: requestBody.toJSON(),
  //   });
  // },
};
