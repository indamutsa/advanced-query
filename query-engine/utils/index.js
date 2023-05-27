const { runMicroSyntax } = require("../microsyntax/main");

const generateDroidQueryDsl = (body) => {
  let { ext, last, from, to, microsyntax, size } = body;
  if (!size) size = -1;
  let { key, operator, value1, value2 } = body.quality ? body.quality : "";

  operator = queryType(operator);

  let quality = "";
  if (key && operator && value1)
    quality = `"modelMetric.metrics.${key}.value: (${
      operator === "range"
        ? ">=" + value1 + " AND <=" + value2
        : operator + value1
    })"`;

  let requestObject = `
    {
      "size": ${size},
      ${
        last
          ? `"sort":{
        "createdAt":"desc"
     },`
          : ""
      }
      "query":{
         "bool":{
            "must":[
               ${
                 ext
                   ? `{
                  "match_phrase":{
                     "ext":"${ext}"
                  }
               },`
                   : ""
               }
               
               ${
                 microsyntax
                   ? `
               {
                  "query_string":{
                     "query":"${microsyntax}"
                  }
               },`
                   : ""
               }
               
               ${
                 quality
                   ? `
               {
                  "query_string":{
                    "fields": ["modelMetric.metrics.*"], 
                     "query":${quality}
                  }
               }`
                   : ""
               }
            ]${
              from && to
                ? `,"filter":[
               {
                  "range":{
                     "createdAt":{
                        "gte":"${from}",
                        "lte":"${to}",
                        "format":"dd-MM-yyyy"
                     }
                  }
               }
            ]`
                : ""
            }
         }
      }
    }  
    `;

  requestObject = fixJSON(requestObject);
  return requestObject;
};

const mainQueryGenerator = (args) => {
  const { microsyntax, from, limit } = args;
  // console.log(args);
  let queryStr = microsyntax ? microsyntax : "";
  let { res, err } = runMicroSyntax(queryStr);

  console.log(res, err);

  let requestObject = `
  {
    "_source": [
      "id",
      "name",
      "storageUrl",
      "size",
      "createdAt",
      "updatedAt",
      "description",
      "type",
      "accessControl",
      "unique_name",
      "ext",
      "project"
    ],
    "from": ${from},
    "size": ${limit},
    "query": {
      "query_string": {
        "query": "${
          res
            ? res
            : ")) -- we making sure that the query crashes if the microsyntax is not valid"
        }",
      }
    }
  }  
  `;

  requestObject = fixJSON(requestObject);
  return requestObject;
};

const queryType = (operator) => {
  let op = "";
  switch (operator) {
    case "gt":
    case "greater than":
      op = "<";
      break;
    case "gte":
    case "greater than or equal":
      op = "<=";
      break;
    case "lt":
    case "less than":
      op = ">";
      break;
    case "lte":
    case "less than or equal":
      op = ">=";
      break;
    case "range":
      op = "range";
      break;
    case "equal":
      op = "";
      break;
    case "AND":
      op = "+";
      break;
    case "OR":
      op = "|";
      break;
    case "NOT":
      op = "-";
      break;

    default:
      op = "";
  }
  return op;
};

// Advanced Query Generator
const advancedQueryGenerator = (args) => {
  // For now optimal transformation is not used
  let requestObject = jsonBuilder(args);
  requestObject = fixJSON(requestObject);

  // console.log("Request Object: ", requestObject);
  return requestObject;
};

function jsonBuilder(args) {
  let jsonSearchContext = "";
  let jsonQualityAssessment = "";
  let jsonPublication = "";
  let contextualSearch = "";
  let flip = false;

  let { searchContext, publication, qualityAssessment } = args.object;
  let { from, limit } = args;
  // console.log("Object: ", args);

  if (searchContext) {
    // console.log("Search Context: ", searchContext);
    for (let i = 0; i < searchContext?.length; i++) {
      let fieldCtxt = searchContext[i].field.toLowerCase();
      let operatorCtxt = queryType(searchContext[i].operator.toUpperCase());
      let valueCtxt = searchContext[i].value.toLowerCase();

      jsonSearchContext += `${operatorCtxt}(${fieldCtxt}:(*${valueCtxt}*)) ${
        i !== searchContext.length - 1 ? "AND" : ""
      } `;
    }
    jsonSearchContext = `(${jsonSearchContext})`;
  }

  if (qualityAssessment) {
    for (let i = 0; i < qualityAssessment?.length; i++) {
      let operator = queryType(qualityAssessment[i].operator);
      let value = qualityAssessment[i].value;
      let field = qualityAssessment[i].field;

      jsonQualityAssessment += `+(+(modelMetric.metrics.${field}.value:${operator}${value}) +(ext:ecore)) ${
        i !== qualityAssessment.length - 1 ? "AND" : ""
      } `;
    }
  }

  if (publication) {
    jsonPublication = getPublicationDate(publication);
  }

  if (searchContext?.length !== 0 || qualityAssessment?.length !== 0)
    contextualSearch = `
    {
      "query_string": {
        "query": "${jsonSearchContext} ${jsonQualityAssessment} "
      }
    }`;

  if (jsonPublication !== "" && contextualSearch !== "") flip = true;

  let requestObject = ` 
  {
    "_source": [
      "id",
      "name",
      "storageUrl",
      "size",
      "createdAt",
      "updatedAt",
      "description",
      "type",
      "accessControl",
      "unique_name",
      "ext",
      "project"
      ],
    "from": ${from},
    "size": ${limit},
    "query": {
      "bool": {
        "must": [
          ${jsonPublication}${flip ? "," : ""}
          ${contextualSearch}
        ]
      }
    }
  }
  `;

  return requestObject;
}

function getPublicationDate(publication) {
  switch (publication.key) {
    case "all_date":
      return "";
    case "specific_date":
      return `        
        {
          "match": {
            "createdAt": ${publication.value}
          }
        }`;

    case "timeframe":
      if (publication.value === "all_date") return "";

      if (publication.value === "7 days")
        return `
          {
            "range": {
              "createdAt":{
                "gte": "now-7d",
                "lt": "now"
              }
            }
          }
        `;

      if (publication.value === "Month")
        return `
          {
            "range": {
              "createdAt":{
                "gte": "now-1M",
                "lt": "now"
              }
            }
         }
        `;

      if (publication.value === "1 Year")
        return `
          {
            "range": {
              "createdAt":{
                "gte": "now-1y",
                "lt": "now"
              }
            }
          }
        `;
      if (publication.value === "Select timeframe") return "";

    case "custom_timeframe":
      return `
        {
          "range": {
            "createdAt":{
              "gte": ${publication.value.startDate},
              "lt": ${publication.value.endDate}"
            }
          }
        }
        `;
  }
}

function fixJSON(json) {
  let newJson = json.replace(/\}\s*,\s*\]/, "}]");
  newJson = newJson.replace(/\"\s*,\s*\}/, '"}');
  return newJson;
}

module.exports = {
  generateDroidQueryDsl,
  mainQueryGenerator,
  advancedQueryGenerator,
};

// let requestObject = `
// {
//   "_source": [
//     "id",
//     "name",
//     "storageUrl",
//     "size",
//     "createdAt",
//     "updatedAt",
//     "description",
//     "type",
//     "accessControl",
//     "unique_name",
//     "ext",
//     "project"
//     ],
//   "query": {
//     "bool": {
//       "must": [
//         {
//           "range": {
//             "@timestamp": {
//               "lte": "2017-08-04"
//             }
//           }
//         },
//         {
//           "query_string": {
//             "query": "(${jsonSearchContext}) AND (${jsonQualityAssessment}) "
//           }
//         }
//       ]
//     }
//   }
// }
// `;
