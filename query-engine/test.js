// matches a number, some characters and another number
// const reg = /\d.*\d/;
// const str = "Java3foobar4Script";
// const newStr = str.replace(reg, "-");
// console.log(newStr);
// "Java-Script"

/**
 *
 * The first case:
 *  keyword1 keyword2 keyword3 keyword4
 *
 * The second case:
 *  keyword1 AND keyword2 OR keyword3 NOT keyword4
 *
 * The third case:
 *  (keyword1 AND keyword2) NOT keyword3 AND keyword4
 *
 * The fourth case:
 *  keyword1 keyword2 keyword3 keyword4 AND CMC == 4
 *
 * The fifth case:
 *  keyword1 keyword2 keyword3 keyword4 AND CMC >= 5 AND CMC <=6
 *
 * The sixth case:
 *  keyword1 keyword2 keyword3 keyword4 AND CMC =< 7 AND size < 8000
 *
 * The seventh:
 *  keyword1 keyword2 keyword3 keyword4 name="name" hasAttribute="name" hasClassName="" isTransformable="metamodel_id" conformsTo="metamodel_id"
 *
 * The fourth case:
 *  keyword1 keyword2 keyword3 keyword4 AND CMC (>= 4, <=5)
 *
 *
 */

const newSentence =
  "name : 'SimpleOOP.ecore' modelMetric.metrics.CMC.value: >5";
const str = "name = ['SimpleOOP.ecore'] modelMetric.metrics.CMC.value: >5";
const makeTag = /=\s*\[["|']/;
let tag = /s*["|']s*\]s*/;

let newStr = str.replace(makeTag, ": '");
let now = newStr.replace(tag, "'");

console.log(now);

// const transformArrayToObj = (data) => {
//   const metrics = [
//     {
//       _id: "62702d266320d300138da652",
//       code: "MC",
//       name: "Number of MetaClass",
//       value: 13,
//     },
//     {
//       _id: "62702d266320d300138da654",
//       code: "AMC",
//       name: "Number of abstract MetaClass",
//       value: 3,
//     },
//     {
//       _id: "62702d266320d300138da656",
//       code: "CMC",
//       name: "Number of concrete MetaClass",
//       value: 10,
//     },
//     {
//       _id: "62702d266320d300138da658",
//       code: "CCFMC",
//       name: "Number of concrete Completely Featureless MetaClass",
//       value: -1,
//     },
//     {
//       _id: "62702d266320d300138da65a",
//       code: "IFLMC",
//       name: "Number of immediate Featureless MetaClass",
//       value: -1,
//     },
//     {
//       _id: "62702d266320d300138da65c",
//       code: "AIFLMC",
//       name: "Number of abstract immediate Featureless MetaClass",
//       value: -1,
//     },
//     {
//       _id: "62702d266320d300138da65e",
//       code: "CIFLMC",
//       name: "Number of concrete immediate Featureless MetaClass",
//       value: -1,
//     },
//     {
//       _id: "62702d266320d300138da662",
//       code: "SFH",
//       name: "Number of Total structural feature with inherited",
//       value: 37,
//     },
//     {
//       _id: "62702d266320d300138da664",
//       code: "CFLMC",
//       name: "Number of Completely Featureless MetaClass",
//       value: -1,
//     },
//     {
//       _id: "62702d266320d300138da666",
//       code: "ACFMC",
//       name: "Number of abstract Completely Featureless MetaClass",
//       value: -1,
//     },
//     {
//       _id: "62702d266320d300138da668",
//       code: "REF",
//       name: "Number of TotalReference",
//       value: 17,
//     },
//     {
//       _id: "62702d266320d300138da66e",
//       code: "ATTR",
//       name: "Number of Total Attribute",
//       value: 12,
//     },
//     {
//       _id: "62702d266320d300138da66a",
//       code: "REFEOP",
//       name: "Number of Opposite Reference ",
//       value: 17,
//     },
//     {
//       _id: "62702d266320d300138da66c",
//       code: "REC_CONT",
//       name: "Number of TotalReference containment",
//       value: 9,
//     },
//     {
//       _id: "62702d266320d300138da670",
//       code: "ATTRH",
//       name: "Number of Total Attribute with inherited",
//       value: 20,
//     },
//     {
//       _id: "62702d266320d300138da674",
//       code: "REFCC",
//       name: "Max chain of containment",
//       value: 50,
//     },
//     {
//       _id: "62702d266320d300138da672",
//       code: "MAXHL",
//       name: "Max generalizzation hierarchical level",
//       value: 1,
//     },
//     {
//       _id: "62702d266320d300138da676",
//       code: "AVGREF",
//       name: "Average Reference in a (class (avg fan out)",
//       value: 1.3076923076923077,
//     },
//     {
//       _id: "62702d266320d300138da660",
//       code: "SF",
//       name: "Number of Total eStructuralFeature",
//       value: 29,
//     },
//     {
//       _id: "62702d266320d300138da67a",
//       code: "MCWSP",
//       name: "Number of class with a super type",
//       value: 7,
//     },
//     {
//       _id: "62702d266320d300138da67c",
//       code: "MAXHS",
//       name: "Max Hierarchy Sibiling",
//       value: 5,
//     },
//     {
//       _id: "62702d266320d300138da678",
//       code: "AVGATTR",
//       name: "Average Attribute in a class",
//       value: 0.9230769230769231,
//     },
//     {
//       _id: "62702d266320d300138da680",
//       name: "maintainability",
//       value: 9.6,
//     },
//     {
//       _id: "62702d266320d300138da67e",
//       code: "LMC",
//       name: "Number of lonely classes",
//       value: 3,
//     },
//   ];

//   let obj = "";
//   metrics.forEach((metric, i) => {
//     let mapper = `
//         "${
//           metric.name === "maintainability" ? "maintainability" : metric.code
//         }": {
//             "name": "${metric.name}",
//             "code": "${
//               metric.name === "maintainability"
//                 ? "maintainability"
//                 : metric.code
//             }",
//             "value": ${metric.value}
//         },`;

//     if (i === 0) {
//       obj = `{
//                 "metrics": {
//                     ${mapper}
//         `;
//     }

//     if (i > 0) obj += mapper;
//     i++;
//   });

//   obj = obj.slice(0, -1) + "}}";
//   obj = JSON.parse(obj);

//   return obj;

//   //   let obj = "";
//   //   metrics.forEach((metric, i) => {
//   //     let mapper = `"${metric.code}":
//   //               {
//   //                   "name": "${metric.name}",
//   //                   "code": "${metric.code}",
//   //                   "value": ${metric.value}
//   //               },`;

//   //     if (i === 0) {
//   //       obj = `
//   //             {
//   //               "metrics": {
//   //                   ${mapper}
//   //          `;
//   //     }

//   //     obj += mapper;
//   //   });
//   //   obj = obj.slice(0, -1) + "}}";
//   //   return JSON.parse(obj);
// };

// const obj = transformArrayToObj();
// console.log(obj);
