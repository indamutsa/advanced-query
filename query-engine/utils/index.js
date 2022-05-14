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

const queryType = (operator) => {
  let op = "";
  switch (operator) {
    case "gt":
      op = "<";
      break;
    case "gte":
      op = "<=";
      break;
    case "lt":
      op = ">";
      break;
    case "lte":
      op = "=>";
      break;
    case "range":
      op = "range";
      break;
    default:
      op = "";
  }
  return op;
};

function fixJSON(json) {
  const newJson = json.replace(/\}\s*,\s*\]/, "}]");
  return newJson;
}

module.exports = { generateDroidQueryDsl };
