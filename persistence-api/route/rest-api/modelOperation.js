const express = require("express");
const router = express.Router();
const Joi = require("joi");
const config = require("config");
const multer = require("multer");

// const { User } = require("../../models/User");
// const { Workspace } = require("../../models/Workspace");
// const { Project } = require("../../models/Project");
const { User, Workspace, Project, Transformation } = require("../../models");
// const { Transformation } = require("../../models/Transformation");
const authorize = require("../../middleware/authorize");
const logger = require("../../middleware/logger");
const { operationFactory } = require("../../models/Transformation");
const {
  uploadMetamodel,
  uploadModel,
  uploadScript,
} = require("../rest-api/artifact");

// const { uploadModel } = require("../rest-api/artifact");
const { uploadFile } = require("../utilities");
// ------------------------------------

const upload = (dest) => {
  const storage = uploadFile(dest);
  return multer({ storage: storage });
};

/**
 * @swagger
 * components:
 *  schemas:
 *      Transformation:
 *          type: object
 *          required:
 *              - sourceModel
 *              - sourceMetamodel
 *              - targetMetamodel
 *              - script
 *          properties:
 *              _id:
 *                  type: string
 *                  description: id of the operation
 *              name:
 *                  type: string
 *                  description: The name of the operation
 *              sourceModel:
 *                  type: string
 *                  description: The id of the metamodel
 *              sourceMetamodel:
 *                  type: string
 *                  description: The id of the source metamodel
 *              targetMetamodel:
 *                  type: string
 *                  description: The id of the target metamodel
 *              script:
 *                  type: string
 *                  description: The id of the dsl
 *              createdAt:
 *                  type: string
 *                  description: time of the operation
 *              updatedAt:
 *                  type: string
 *                  description: Time the operation was updated
 *          example:
 *              _id: "tranfsformation_timestamp"
 *              sourceModel: "sd1s2d54sd12s1d54dskjdisokds25"
 *              sourceMetamodel: "sd1s2d54sd12s1d54dskjdisokds25"
 *              targetMetamodel: "sd1s2d54sd12s1d54dskjdsdsds"
 *              script: "sd1s2d54sd12s1d54dskjdisokds25"
 *
 *
 *  parameters:
 *      idParam:
 *          in: path
 *          name: name
 *          schema:
 *              type: string
 *          required: true
 *          description: The operation id
 *
 *
 */

/**
 * @swagger
 * tags:
 *  name: Transformation
 *  description: The model operations API. This type of api is responsible of persisting model operations
 *
 */

// Persist the transformation
/**
 * @swagger
 * /store/operation:
 *  post:
 *      summary: Persist a model operation
 *      tags: [Transformation]
 *      requestBody:
 *          required: true
 *          content:
 *              application/json:
 *                  schema:
 *                      example:
 *                          sourceModel: sourceModel-name
 *                          sourceMetamodel: sourceMetamodel-name
 *                          targetMetamodel: targetMetamodel-name
 *                          script: script-name
 *      responses:
 *          200:
 *              description: The operation was successfully persisted
 *              content:
 *                  application/json:
 *                      schema:
 *                          example:
 *                              "_id": "tranfsformation_timestamp"
 *                              "sourceModel": "sd1s2d54sd12s1d54dskjdisokds25"
 *                              "sourceMetamodel": "sd1s2d54sd12s1d54dskjdisokds25"
 *                              "targetMetamodel": "sd1s2d54sd12s1d54dskjdsdsds"
 *                              "script": "sd1s2d54sd12s1d54dskjdisokds25"
 *          404:
 *               description: The tranformation was not found
 *          500:
 *              description: An error occurred on the server, check the logs!
 */
router.post("/", upload("operation").array("file", 4), async (req, res) => {
  let folder = req.originalUrl.split("/").pop();
  req.folder = "operations";

  const ModelOperation = operationFactory(req.body.type);
  let transformationName = "transformation" + "-" + Date.now();

  try {
    const user = await User.findOne({ username: "arsene" });
    const workspace = await Workspace.findOne({ owner: user._id });
    const project = await Project.findOne({ workspace: workspace._id });
    req.data = {
      description: "",
    };

    req.data.description = "Uploaded as part of the transformation operation";
    req.data.project = project._id;
    req.data.transformationName = transformationName;

    // Uploading source metamodel
    let mmReq = request(req, "sourceMM");
    let data = await uploadMetamodel(mmReq);

    // Uploading target metamodel
    let tmReq = request(req, "targetMM");
    const tmData = await uploadMetamodel(tmReq);

    // Uploading the dsl
    let sReq = request(req, "script");
    const sData = await uploadScript(sReq);

    // Uploading the model
    let mReq = request(req, "model");
    mReq.data.metamodel = data.metamodelData._id;
    const mData = await uploadModel(mReq);

    // res.send("worked!");
    const transformationData = {
      name: transformationName,
      sourceModel: mData.modelData.name,
      sourceMetamodel: data.metamodelData.name,
      targetMetamodel: tmData.metamodelData.name,
      script: sData.dslData.name,
    };

    const operation = await ModelOperation(transformationData);
    const persistedOperation = await operation.save();
    logger.info("The operation was successful logged!");
    res.status(200).json({
      message: "The operation was successful logged!",
      persistedOperation,
    });
  } catch (err) {
    logger.error(err.toString());
    res.status(500).json(err.toString());
  }
});

const request = (req, type) => {
  switch (type) {
    case "model":
      req.file = req.files[0];
      break;
    case "sourceMM":
      req.file = req.files[1];
      break;
    case "targetMM":
      req.file = req.files[2];
      break;
    case "script":
      req.file = req.files[3];
      break;

    default:
      break;
  }
  return req;
};

/**
 * @swagger
 * /store/operation/{id}:
 *  get:
 *      summary: Returns
 *      tags: [Transformation]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The name of the operation
 *      responses:
 *          200:
 *              description: The operation was retrieved successfully!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/Transformation'
 *                          example:
 *                              message: 'The operation was successful logged!'
 *                              persistedOperation:
 *                                  _id: 61e6bf1dfce88f9058654579
 *                                  sourceModel: sourceModel-name
 *                                  sourceMetamodel: sourceMetamodel-name
 *                                  targetMetamodel: targetMetamodel-name
 *                                  dsl: script-name
 *                                  name: transfromation-1642512157543
 *                                  __v: 0
 *
 *          404:
 *               description: The operation was not found
 */

// Getting the operation
router.get("/:id", async (req, res) => {
  const ModelOperation = operationFactory(req.body.type);

  try {
    const operationData = await ModelOperation.findById(req.params.id);

    if (!operationData)
      return res.status(404).json({ message: "Operation data not found!" });

    logger.info("Operation was retrieved successfully!");
    res.status(200).json({
      message: "Operation was retrieved successfully!",
      operationData,
    });
  } catch (err) {
    logger.error(err.toString());
    res.status(500).json(err.toString());
  }
});

// Update the transformation
/**
 * @swagger
 * /store/operation/{id}:
 *  put:
 *      summary: Update a transformation by id
 *      tags: [Transformation]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The transformation id
 *      requestBody:
 *          required: true
 *          content:
 *              application/json:
 *                  schema:
 *                      $ref: '#/components/schemas/Transformation'
 *
 *      responses:
 *          200:
 *              description: The transformation was successfully updated!
 *              content:
 *                  application/json:
 *                      schema:
 *                          $ref: '#/components/schemas/Transformation'
 *          404:
 *              description: The transformation was not found
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.put("/:id", async (req, res) => {
  const ModelOperation = operationFactory(req.body.type);
  const operationData = await ModelOperation.findById(req.params.id);

  if (operationData) {
    try {
      const updatedUser = await ModelOperation.findByIdAndUpdate(
        req.params.id,
        {
          $set: req.body,
        },
        { new: true }
      );
      logger.info("Transformation updated successfully!");
      res
        .status(200)
        .json({ message: "Transformation updated successfully!", updatedUser });
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err.toString());
    }
  } else {
    logger.warn("The transformation specified does not exist!");
    res.status(404).json("The transformation specified does not exist!");
  }
});

// Delete the transformation
/**
 * @swagger
 * /store/operation/{id}:
 *  delete:
 *      summary: Delete an operation data by id
 *      tags: [Transformation]
 *      parameters:
 *          - $ref: "#/components/parameters/idParam"
 *      responses:
 *          200:
 *              description: The operation data were successfully deleted
 *          404:
 *              description: The operation was not found!
 */
router.delete("/:id", async (req, res) => {
  const ModelOperation = operationFactory(req.body.type);

  const operation = await ModelOperation.findById(req.params.id);
  if (operation) {
    try {
      await operation.delete();
      logger.info("Operation data deleted successfully!");
      res.status(200).json("Operation data  deleted successfully!");
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err.toString());
    }
  } else {
    logger.warn("The operation data  specified does not exist!");
    res.status(404).json("The operation data  specified does not exist!");
  }
});

module.exports = router;
