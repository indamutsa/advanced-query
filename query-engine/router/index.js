const express = require("express");
const controller = require("../controller");
const router = express.Router();

router.route("/search-all").get(controller.search);
router.route("/search-by-year").get(controller.filterCarsByYearMade);
router.route("/search-by-name").get(controller.filterCarsByName);
router.route("/search-by-name-single").get(controller.filterCarByName);
router.route("/search-by-multiple").get(controller.fetchMatchMultipleQuery);
router.route("/seach-avg-query").get(controller.aggregateQuery);
router.route("/droid").post(controller.getArtifactsDroid);
router.route("/test").post(controller.test);

module.exports = router;
