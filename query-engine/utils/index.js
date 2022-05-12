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
  function bulkRegex(str, callback) {
    if (callback && typeof callback === "function") {
      return callback(str);
    } else if (callback && Array.isArray(callback)) {
      for (let i = 0; i < callback.length; i++) {
        if (callback[i] && typeof callback[i] === "function") {
          str = callback[i](str);
        } else {
          break;
        }
      }
      return str;
    }
    return str;
  }
  if (json && json !== "") {
    if (typeof json !== "string") {
      try {
        json = JSON.stringify(json);
      } catch (e) {
        return false;
      }
    }
    if (typeof json === "string") {
      json = bulkRegex(json, false, [
        (str) => str.replace(/[\n\t]/gm, ""),
        (str) => str.replace(/,\}/gm, "}"),
        (str) => str.replace(/,\]/gm, "]"),
        (str) => {
          str = str.split(/(?=[,\}\]])/g);
          str = str.map((s) => {
            if (s.includes(":") && s) {
              let strP = s.split(/:(.+)/, 2);
              strP[0] = strP[0].trim();
              if (strP[0]) {
                let firstP = strP[0].split(/([,\{\[])/g);
                firstP[firstP.length - 1] = bulkRegex(
                  firstP[firstP.length - 1],
                  false,
                  (p) => p.replace(/[^A-Za-z0-9\-_]/, "")
                );
                strP[0] = firstP.join("");
              }
              let part = strP[1].trim();
              if (
                (part.startsWith('"') && part.endsWith('"')) ||
                (part.startsWith("'") && part.endsWith("'")) ||
                (part.startsWith("`") && part.endsWith("`"))
              ) {
                part = part.substr(1, part.length - 2);
              }
              part = bulkRegex(part, false, [
                (p) => p.replace(/(["])/gm, "\\$1"),
                (p) => p.replace(/\\'/gm, "'"),
                (p) => p.replace(/\\`/gm, "`"),
              ]);
              strP[1] = ('"' + part + '"').trim();
              s = strP.join(":");
            }
            return s;
          });
          return str.join("");
        },
        (str) => str.replace(/(['"])?([a-zA-Z0-9\-_]+)(['"])?:/g, '"$2":'),
        (str) => {
          str = str.split(/(?=[,\}\]])/g);
          str = str.map((s) => {
            if (s.includes(":") && s) {
              let strP = s.split(/:(.+)/, 2);
              strP[0] = strP[0].trim();
              if (strP[1].includes('"') && strP[1].includes(":")) {
                let part = strP[1].trim();
                if (part.startsWith('"') && part.endsWith('"')) {
                  part = part.substr(1, part.length - 2);
                  part = bulkRegex(part, false, (p) =>
                    p.replace(/(?<!\\)"/gm, "")
                  );
                }
                strP[1] = ('"' + part + '"').trim();
              }
              s = strP.join(":");
            }
            return s;
          });
          return str.join("");
        },
      ]);
      try {
        json = JSON.parse(json);
      } catch (e) {
        return false;
      }
    }
    return json;
  }
  return false;
}

module.exports = { generateDroidQueryDsl };
