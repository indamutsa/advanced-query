const Services = require("../service");

module.exports = {
  async test(req, res) {
    // console.log(req.body);
    res.json({ hello: "Hello, world! " });
  },

  // Here we need to return this data:
  /**
   * ext
   * last
   * from
   * to
   * quality metrics
   *    Key: AIC
   *    operator: gte
   *    value
   * microsyntax
   * size
   */
  async getArtifactsDroid(req, res) {
    try {
      let result = await Services.getDroidData(req.body);

      const data = result.hits.hits.map((response) => {
        let dataRes = JSON.parse(JSON.stringify(response._source));
        let { content, ...censoredData } = dataRes;
        // console.log(censoredData);
        return {
          id: response._id,
          data: censoredData,
        };
      });

      res.json({
        status_code: 200,
        success: true,
        data: data,
        total_hits: result.hits.total.value,
        message: "Data successfully fetched!",
      });
    } catch (err) {
      // console.log(err);
      res.json({ status_code: 500, success: false, data: [], message: err });
    }
  },

  async getAllData(req, res) {
    try {
      let params = req.body
      console.log(params);

      let result = await Services.searchAll(params);


      const data = result.hits.hits.map((response) => {
        let dataRes = JSON.parse(JSON.stringify(response._source));
        let { content, ...censoredData } = dataRes;
        // console.log(censoredData);
        return {
          id: response._id,
          data: censoredData,
        };
      });

      res.json({
        status_code: 200,
        success: true,
        data: data,
        total_hits: result.hits.total.value,
        message: "Data successfully fetched!",
      });
    } catch (err) {
      // console.log(err);
      res.json({ status_code: 500, success: false, data: [], message: err });
    }
  },

  // Examples can be run here because you can export them from here
};

// Examples:
// async search(req, res) {
//   try {
//     const result = await Services.search();
//     const data = result.hits.hits.map((car) => {
//       return {
//         id: car._id,
//         data: car._source,
//       };
//     });
//     res.json({
//       status_code: 200,
//       success: true,
//       data: data,
//       message: "Cars data successfully fetched!",
//     });
//   } catch (err) {
//     res.json({ status_code: 500, success: false, data: [], message: err });
//   }
// },
// async filterCarsByYearMade(req, res) {
//   let { year1, year2 } = req.query;

//   try {
//     const result = await Services.filterCarsByYearMade(year1, year2);
//     const data = result.hits.hits.map((car) => {
//       return {
//         id: car._id,
//         data: car._source,
//       };
//     });
//     res.json({
//       status_code: 200,
//       success: true,
//       data: data,
//       message: "Filter Cars by year made data fetched successfully",
//     });
//   } catch (err) {
//     res.json({ status_code: 500, success: false, data: [], message: err });
//   }
// },

// async filterCarsByName(req, res) {
//   let param = req.query.Name;
//   try {
//     const result = await Services.filterCarsByName(param);
//     const data = result.hits.hits.map((car) => {
//       return {
//         id: car._id,
//         data: car._source,
//       };
//     });
//     res.json({
//       status_code: 200,
//       success: true,
//       data: data,
//       message: "Filter cars by name data fetched successfully!",
//     });
//   } catch (err) {
//     res.json({ status_code: 500, success: false, data: [], message: err });
//   }
// },

// async filterCarByName(req, res) {
//   const param = req.query.Name;
//   try {
//     const result = await Services.fetchCarByName(param);
//     const data = result.hits.hits.map((car) => {
//       return {
//         id: car._id,
//         data: car._source,
//       };
//     });
//     res.json({
//       status_code: 200,
//       success: true,
//       data: data,
//       message: "Filter a car by name query data fetched successfully!",
//     });
//   } catch (err) {
//     res.json({ status_code: 500, success: false, data: [], message: err });
//   }
// },

// async fetchMatchMultipleQuery(req, res) {
//   const param2 = req.query.Origin;
//   const param1 = req.query.Name;
//   const param3 = req.query.Weight_in_lbs;
//   try {
//     const result = await Services.fetchMatchMultipleQuery(
//       param2,
//       param1,
//       param3
//     );
//     const data = result.hits.hits.map((car) => {
//       return {
//         id: car._id,
//         data: car._source,
//       };
//     });
//     res.json({
//       status_code: 200,
//       success: true,
//       data: data,
//       messsage: "fetch match query for multiple requests successful!",
//     });
//   } catch (err) {
//     res.json({ status_code: 500, success: false, data: [], message: err });
//   }
// },

// async aggregateQuery(req, res) {
//   const param1 = req.query.Origin;
//   const param2 = req.query.Cylinder;
//   const param3 = req.query.Name;
//   const param4 = req.query.Horsepower;
//   try {
//     const result = await Services.aggregateQuery(
//       param1,
//       param2,
//       param3,
//       param4
//     );
//     const data = result.hits.hits.map((car) => {
//       return {
//         id: car._id,
//         data: car._source,
//       };
//     });
//     res.json({
//       status_code: 200,
//       success: true,
//       data: data,
//       message: "Data successfully fetched!",
//     });
//   } catch (err) {
//     res.json({ status_code: 500, success: false, data: [], message: err });
//   }
// },
