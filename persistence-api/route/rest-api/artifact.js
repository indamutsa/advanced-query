const express = require("express");
const Joi = require("joi");
const router = express.Router();
const { Artifact } = require("../../models/Artifact");
const multer = require("multer");
const { uploadOnCloud } = require("../../services/file.controller");
const { Model } = require("../../models/Model");
const { Metamodel } = require("../../models/Metamodel");
const { Dsl } = require("../../models/Dsl");
const { Project } = require("../../models/Project");
const logger = require("../../middleware/logger");
const { deleteFile, uploadFile, readFile } = require("../utilities");
const processFile = require("../../middleware/upload");
// var fs = require("fs");

router.get("/test", async (req, res) => {
  // let data = await readFile("metamodel");
  res.status(200).json({ message: "Hello world " });
});

const upload = (dest) => {
  const storage = uploadFile(dest);
  return multer({ storage: storage });
};

// CRUD OPERATIONS

/**
 *  ------------------------- NETAMODEL ---------------------------
 */

// 1. Save metamodel
/**
 * @swagger
 * components:
 *  schemas:
 *      Metamodel:
 *          type: object
 *          required:
 *              - file
 *              - project
 *          properties:
 *              file:
 *                  type: string
 *                  format: binary
 *              description:
 *                  type: string
 *                  description: "File upload of metamodel"
 *              project:
 *                  type: string
 *                  description: "The id of the project"
 *      Model:
 *          type: object
 *          required:
 *              - file
 *              - project
 *              - metamodel
 *          properties:
 *              file:
 *                  type: string
 *                  format: binary
 *              metamodel:
 *                  type: string
 *                  description: The id of the metamodel
 *              project:
 *                  type: string
 *                  description: The id of the project
 *              description:
 *                  type: string
 *                  description: "File upload of model"
 *      Dsl:
 *          type: object
 *          required:
 *              - file
 *              - project
 *          properties:
 *              file:
 *                  type: string
 *                  format: binary
 *              project:
 *                  type: string
 *                  description: "The id of the project"
 *              description:
 *                  type: string
 *                  description: "File upload of Dsl"
 *  parameters:
 *      idParam:
 *          in: path
 *          name: id
 *          schema:
 *              type: string
 *          required: true
 *          description: The model file id
 */

/**
 * @swagger
 * tags:
 *  - name: Metamodel
 *    description: The metamodel managing API
 *  - name: Model
 *    description: The model managing API
 *  - name: Dsl
 *    description: The dsl managing API
 */

/**
 * @swagger
 * /store/artifact/metamodel:
 *  post:
 *      summary: Save a metamodel
 *      tags: [Metamodel]
 *      requestBody:
 *          content:
 *              multipart/form-data:
 *                  schema:
 *                      $ref: '#/components/schemas/Metamodel'
 *      responses:
 *          200:
 *              description: The metamodel was successfully created
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          example:
 *                              "message": "File uploaded successfully!"
 *                              "metamodelData":
 *                                  "models": []
 *                                  "_id": "618cc6e0a0fb8184fa45967f"
 *                                  "name": "DB-1636615904675.ecore"
 *                                  "project": "6172ab789ece0da287693c17"
 *                                  "type": "ECORE"
 *                                  "artifact":
 *                                      "accessControl": "PUBLIC"
 *                                      "_id": "618cc6e0a0fb8184fa45967e"
 *                                      "type": "METAMODEL"
 *                                      "storageUrl": "http://base_url/files/metamodel/DB-1636615904675.ecore"
 *                                      "size": 2241
 *                                      "description": "We are trying to save the metamodel"
 *                                      "createdAt": "2021-11-11T07:31:44.693Z"
 *                                      "updatedAt": "2021-11-11T07:31:44.693Z"
 *          404:
 *               description: File extension not supported or file not found!
 *          500:
 *              description: An error occurred on the server, check the logs!
 */
router.post(
  "/metamodel",
  upload("metamodels").single("file"),
  async (req, res) => {
    let folder = req.originalUrl.split("/").pop();
    req.folder = folder;

    try {
      const p_id = req.data ? req.data.project : req.body.project;

      if (!p_id) {
        logger.error("Missing project id");
        await deleteFile(
          `./localStorage/artifacts/${req.folder}/` + req.file.filename
        );
        return {
          code: 500,
          message: "Missing project id, please include it and try again!",
        };
      }

      const data = await uploadMetamodel(req);

      return res
        .status(data.code)
        .json({ message: data.message, data: data.metamodelData });
    } catch (err) {
      logger.error(err.message);
      await deleteFile(
        `./localStorage/artifacts/${req.folder}/` + req.file.filename
      );
      return { code: 500, message: err.message };
    }
  }
);

const uploadMetamodel = async (req) => {
  // extF = req.file.filename.match(/(.*)\.(.*)/)[2];

  extF = req.file.originalname.match(/(.*)\.(.*)/)[2];

  let fileExt = extF.toUpperCase();

  try {
    const modelExts = ["ECORE", "MPS"];
    const valid = modelExts.includes(fileExt);
    const project = await Project.findById(
      req.data ? req.data.project : req.body.project
    );

    if (valid && project) {
      let data = await readFile("metamodel", req.file.path);
      let metamodelData = null;

      metamodelData = await Metamodel.findOne({ content: data.content });

      if (metamodelData) {
        if (
          !metamodelData.project.includes(
            req.data ? req.data.project : req.body.project
          )
        ) {
          metamodelData = await Metamodel.findByIdAndUpdate(
            metamodelData._id,
            {
              $push: {
                project: req.data ? req.data.project : req.body.project,
              },
            },
            {
              new: true, //To return the updated value
            }
          );
        }

        await deleteFile(
          `./localStorage/artifacts/${req.folder}/` + req.file.filename
        );

        return {
          code: 409,
          message: "Metamodel already exists!",
          metamodelData,
        };
      }

      const url = await uploadOnCloud(
        "metamodels",
        req
        // req.file.path,
        // req.file.filename
      );
      req.publicUrl = url;

      // Save metamodel
      const metamodel = {
        name: req.file.originalname,
        unique_name: req.file.filename,
        // project: req.data ? req.data.project : req.body.project,
        ext: fileExt,
        // type: "METAMODEL",
        storageUrl: req.publicUrl,
        size: req.file.size,
        description: req.data ? req.data.description : req.body.description,
        accessControl: req.body?.accessControl,
        comment: req.body?.comment,
        content: data?.content,
        ePackage: {
          name: data?.ePackage?.name,
          nsURI: data?.ePackage?.nsURI,
          nsPrefix: data?.ePackage?.nsPrefix,
          eSubpackages: data?.ePackage?.eSubpackages,
        },
      };
      const newMetamodel = await Metamodel(metamodel);
      const savedMetaModel = await newMetamodel.save();

      //   if (!metamodelData.workspace.includes(project.workspace))
      //     await Metamodel.findByIdAndUpdate(
      //       savedMetaModel._id,
      //       {
      //         $push: {
      //           workspace: project.workspace,
      //         },
      //       },
      //       {
      //         new: true, //To return the updated value
      //       }
      //     );

      // I need to iteratively update the workspace, and the user if the user is different

      await Metamodel.findByIdAndUpdate(
        savedMetaModel._id,
        {
          $push: {
            project: req.data ? req.data.project : req.body.project,
          },
        },
        {
          new: true, //To return the updated value
        }
      );

      if (req.data) {
        await Metamodel.findByIdAndUpdate(
          savedMetaModel._id,
          {
            $push: {
              involvedOperations: req.data.transformationName,
            },
          },
          {
            new: true, //To return the updated value
          }
        );
      }
      metamodelData = await Metamodel.findOne({
        _id: savedMetaModel._id,
      });
      // .populate("artifact");

      // We are deleting data because after processing it
      // we dont persist it locally, we save it on the cloud! -- UNCOMMENT THIS IF YOU WANT TO PERSIST THE DATA ON THE cloud
      // await deleteFile(
      //   `./localStorage/artifacts/${req.folder}/` + req.file.filename
      // );

      logger.info("Metamodel uploaded successfully!");

      return {
        code: 200,
        message: "Metamodel uploaded successfully!",
        metamodelData,
      };
    } else {
      logger.warn("Metamodel extension not supported or no project found!");
      await deleteFile(
        `./localStorage/artifacts/${req.folder}/` + req.file.filename
      );
      return {
        code: 404,
        message: "Metamodel extension not supported or no project found!",
      };
    }
  } catch (err) {
    logger.error(err.toString());
    await deleteFile(
      `./localStorage/artifacts/${req.folder}/` + req.file.filename
    );
    return { code: 500, message: err.message };
  }
};

// 2. Get all metamodel by the project
/**
 * @swagger
 * /store/artifact/project:
 *  get:
 *      summary: Returns the list of metamodels owned by the project
 *      tags: [Metamodel]
 *      parameters:
 *          - in: query
 *            name: projectId
 *            schema:
 *              type: string
 *            required: true
 *            description: The project id
 *      responses:
 *          200:
 *              description: The user was retrieved successfully!
 *              content:
 *                  application/json:
 *                      schema:
 *                          example:
 *                              "message": "Metamodels retrieved successfully!"
 *                              "metamodels":
 *                                  - "models": ["6172c6bba05a9fc3a043715f"]
 *                                    "_id": "6172c6ada05a9fc3a043715b"
 *                                    "name": "DB-1634911917344.ecore"
 *                                    "project": "6172ab789ece0da287693c17"
 *                                    "type": "ECORE"
 *                                    "artifact": "6172c6ada05a9fc3a043715a"
 *
 *                                  - "models": []
 *                                    "_id": "6172c6ada05a9fc3a043715b"
 *                                    "name": "DB-1634911917344.ecore"
 *                                    "project": "6172ab789ece0da287693c17"
 *                                    "type": "ECORE"
 *                                    "artifact": "6172c6ada05a9fc3a043715a"
 *          404:
 *               description: The project specified is not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 */
router.get("/project", async (req, res) => {
  const project = await Project.findById(req.query.projectId);

  if (project) {
    try {
      const metamodels = await Metamodel.find({ project: project._id });

      logger.info("Metamodels retrieved successfully!");
      res
        .status(200)
        .json({ message: "Metamodels retrieved successfully!", metamodels });
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err);
    }
  } else {
    logger.warn("The project specified is not found!");
    res.status(404).json("The project specified is not found!");
  }
});

// 3. Get metamodel by id
/**
 * @swagger
 * /store/artifact/metamodel/{id}:
 *  get:
 *      summary: Returns the metamodel by id
 *      tags: [Metamodel]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The metamodel id
 *      responses:
 *          200:
 *              description: The metamodel was retrieved successfully!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/Metamodel'
 *                          example:
 *                              "message": "Metamodels retrieved successfully!"
 *                              "metamodels":
 *                                  "models": ["6172c6bba05a9fc3a043715f"]
 *                                  "_id": "6172c6ada05a9fc3a043715b"
 *                                  "name": "DB-1634911917344.ecore"
 *                                  "project": "6172ab789ece0da287693c17"
 *                                  "type": "ECORE"
 *                                  "artifact": "6172c6ada05a9fc3a043715a"
 *          404:
 *               description: The metamodel was not found
 *          500:
 *              description: An error occurred on the server, check the logs
 */
router.get("/metamodel/:id", async (req, res) => {
  try {
    const metamodels = await Metamodel.findById(req.params.id);
    logger.info("Metamodel retrieved successfully!");
    res
      .status(200)
      .json({ message: "Metamodel retrieved successfully!", metamodels });
  } catch (err) {
    logger.error(err.toString());
    res.status(500).json(err);
  }
});

// 4. Update metamodel
/**
 * @swagger
 * /store/artifact/metamodel/{id}:
 *  put:
 *      summary: Update a metamodel by id
 *      tags: [Metamodel]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The metamodel id
 *      requestBody:
 *          content:
 *              multipart/form-data:
 *                  schema:
 *                      $ref: '#/components/schemas/Metamodel'
 *      responses:
 *          200:
 *              description: The metamodel was successfully updated!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/Metamodel'
 *                          example:
 *                              "message": "File updated successfully!"
 *                              "metamodelData":
 *                                  "models": ["6172c6bba05a9fc3a043715f"]
 *                                  "_id": "6172a7f8c2ff9c9cc97c2610"
 *                                  "name": "Project 1"
 *                                  "workspace": "6172a7f8c2ff9c9cc97c2610"
 *                                  "description": "Project Updated"
 *                                  "createdAt": "2021-10-22T12:00:56.079Z"
 *                                  "updatedAt": "2021-10-22T12:15:52.247Z"
 *                                  "artifact":
 *                                      "accessControl": "PUBLIC"
 *                                      "_id": "618ce5eef407bd284d39acf3"
 *                                      "type": "METAMODEL"
 *                                      "size": 2241
 *                                      "storageUrl": "http://base_url/files/metamodel/DB-1636623854264.ecore"
 *                                      "description": "We are updating the metamodel ..."
 *                                      "createdAt": "2021-11-11T09:44:14.289Z"
 *                                      "updatedAt": "2021-11-11T09:44:14.289Z"
 *          404:
 *              description: The metamodel was not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.put("/metamodel/:id", async (req, res) => {
  let metamodel = await Metamodel.findById(req.params.id);
  upload = uploadFile("metamodel");

  if (metamodel) {
    upload(req, res, async (err) => {
      if (err) {
        return res.status(500).json("Error uploading file.");
      } else {
        let filename = req.file?.filename;
        let description = req.body?.description;
        let project = await Project.findById(req.body?.project);
        let artifactFile = await Artifact.findById(metamodel.artifact);

        let data = {};
        let fileExt = "";

        if (filename) {
          data.filename = filename;
          fileExt = filename.split(".")[1].toUpperCase();
        }

        if (description) {
          data.description = description;
        }

        if (project) {
          data.project = project._id.toString();
        }

        try {
          let modelExts = ["ECORE", "MPS"];
          let valid = modelExts.includes(fileExt);
          if (filename) {
            if (valid) {
              let artifact = {
                project: req.body.project,
                type: "METAMODEL",
                size: req.file.size,
                storageUrl:
                  `http://${req.headers.host}/` +
                  "files/metamodel/" +
                  req.file.filename,
                description: req.data
                  ? req.data.description
                  : req.body.description,
                accessControl: req.body?.accessControl,
                comment: req.body?.comment,
              };

              await deleteFile(
                "." +
                  artifactFile.storageUrl.split(`http://${req.headers.host}`)[1]
              ).then(async () => {
                await artifactFile.delete();
              });

              //   let file = await Artifact.findById(metamodel.artifact);

              // Save the artifact
              const newArtifact = await Artifact(artifact);
              const savedArtifact = await newArtifact.save();

              data.artifact = savedArtifact._id.toString();
              data.storageUrl = `http://${req.headers.host}/` + req.file.path;
              data.name = req.file.filename;
            } else {
              logger.warn("Metamodel extension not supported!");
              return res.status(404).json("Metamodel extension not supported!");
            }
          }

          metamodel = await Metamodel.findById(req.params.id);
          await Artifact.findByIdAndUpdate(
            artifactFile._id,
            {
              $set: data,
            },
            { new: true }
          );

          const updatedMetamodel = await Metamodel.findByIdAndUpdate(
            req.params.id,
            {
              $set: data,
            },
            { new: true }
          );

          const metamodelData = await Metamodel.findOne({
            _id: updatedMetamodel._id,
          }).populate("artifact");

          logger.info("File updated successfully!");

          return res
            .status(200)
            .json({ message: "File updated successfully!", metamodelData });
        } catch (err) {
          logger.error(err.toString());
          return res.status(500).json(err.toString());
        }
      }
    });
  } else {
    logger.info("File with ID specified does not exist!");
    return res.status(404).json("File with ID specified does not exist!");
  }
});

// 5. Delete metamodel
/**
 * @swagger
 * /store/artifact/metamodel/{id}:
 *  delete:
 *      summary: Delete a metamodel by id
 *      tags: [Metamodel]
 *      parameters:
 *          - $ref: "#/components/parameters/idParam"
 *      responses:
 *          200:
 *              description: The metamodel was successfully deleted!
 *          404:
 *              description: The metamodel was not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.delete("/metamodel/:id", async (req, res) => {
  const metamodel = await Metamodel.findById(req.params.id);

  if (metamodel) {
    const artifact = await Artifact.findById(metamodel.artifact);

    try {
      await deleteFile(
        "." + artifact.storageUrl.split(`http://${req.headers.host}`)[1]
      );
      await artifact.delete();
      await metamodel.delete();

      logger.info("The metamodel was deleted successfully!");
      return res.status(200).json("File deleted successfully!");
    } catch (err) {
      logger.error(err.toString());
      return res.status(500).json(err.toString());
    }
  } else {
    logger.info("The metamodel with ID specified does not exist!");
    return res
      .status(404)
      .json("The metamodel with ID specified does not exist!");
  }
});

/**
 *  ------------------------- MODEL ---------------------------
 */

// 1.1 Save model
/**
 * @swagger
 * /store/artifact/model:
 *  post:
 *      summary: Save a model
 *      tags: [Model]
 *      requestBody:
 *          content:
 *              multipart/form-data:
 *                  schema:
 *                      $ref: '#/components/schemas/Model'
 *      responses:
 *          200:
 *              description: The model was successfully created
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          example:
 *                              "message": "Model uploaded successfully!"
 *                              "metamodelData":
 *                                  "_id": "618cc6e0a0fb8184fa45967f"
 *                                  "name": "DB-1636615904675.ecore"
 *                                  "metamodel": "6172c6ada05a9fc3a043715b"
 *                                  "project": "6172ab789ece0da287693c17"
 *                                  "type": "XMI"
 *                                  "artifact":
 *                                      "accessControl": "PUBLIC"
 *                                      "_id": "618cc6e0a0fb8184fa45967e"
 *                                      "type": "MODEL"
 *                                      "storageUrl": "http://base_url/files/model/model-1636630514575.xmi"
 *                                      "size": 2241
 *                                      "description": "WE ARE SAVING THE MODEL"
 *                                      "createdAt": "2021-11-11T07:31:44.693Z"
 *                                      "updatedAt": "2021-11-11T07:31:44.693Z"
 *          404:
 *               description: File extension not supported or file not found!
 *          500:
 *              description: An error occurred on the server, check the logs!
 */
router.post("/model", upload("models").single("file"), async (req, res) => {
  let folder = req.originalUrl.split("/").pop();
  req.folder = folder;

  try {
    const p_id = req.body.project;

    if (!p_id) {
      logger.error("Project metamodel id");

      await deleteFile(
        `./localStorage/artifacts/${req.folder}/` + req.file.filename
      );
      return { code: 500, message: "Missing metamodel id" };
    }

    const data = await uploadModel(req);

    return res
      .status(data.code)
      .json({ message: data.message, data: data.dataModel });
  } catch (err) {
    logger.error(err.message);
    await deleteFile(
      `./localStorage/artifacts/${req.folder}/` + req.file.filename
    );
    return { code: 500, message: err.message };
  }
});

const uploadModel = async (req, res) => {
  let fileExt = req.file.filename.split(".")[1].toUpperCase();

  try {
    let modelExts = ["XMI", "XML", "MODEL", "UML"];
    let valid = modelExts.includes(fileExt);
    let metamodel_id = null;
    if (req.data) metamodel_id = req.data?.metamodel;
    else metamodel_id = req.body?.metamodel;

    if (valid && req.body.project) {
      let metamodel = await Metamodel.findById(metamodel_id);
      let data = await readFile("model", req.file.path);

      let modelData = await Model.findOne({ content: data.content });

      if (modelData) {
        if (
          !modelData.project.includes(
            req.data ? req.data.project : req.body.project
          )
        ) {
          modelData = await Model.findByIdAndUpdate(
            modelData._id,
            {
              $push: {
                project: req.data ? req.data.project : req.body.project,
              },
            },
            {
              new: true, //To return the updated value
            }
          );
        }

        await deleteFile(
          `./localStorage/artifacts/${req.folder}/` + req.file.filename
        );

        return {
          code: 409,
          message: "Metamodel already exists!",
          modelData,
        };
      }

      // let artifact = {
      //   type: "MODEL",
      //   storageUrl: req.publicUrl,
      //   // `http://${req.headers.host}/` + "files/model/" + req.file.filename,
      //   size: req.file.size,
      //   description: req.data ? req.data.description : req.body.description,
      //   accessControl: req.body?.accessControl,
      //   comment: req.body?.comment,
      //   content: data.content,
      // };

      // // Save the artifact
      // const newArtifact = await Artifact(artifact);
      // const savedArtifact = await newArtifact.save();

      const url = await uploadOnCloud(
        "models",
        req
        // req.file.path,
        // req.file.filename
      );
      req.publicUrl = url;

      // Save the model
      const model = {
        name: req.file.originalname,
        unique_name: req.file.filename,
        metamodel: metamodel ? metamodel?._id : "orphan",
        project: req.body.project,
        ext: fileExt,
        // artifact: savedArtifact._id,
        // type: "MODEL",
        storageUrl: req.publicUrl,
        // `http://${req.headers.host}/` + "files/model/" + req.file.filename,
        size: req.file.size,
        description: req.data ? req.data.description : req.body.description,
        accessControl: req.body?.accessControl,
        comment: req.body?.comment,
        content: data.content,
      };

      const newModel = await Model(model);
      const savedModel = await newModel.save();

      // if (!savedModel) {
      //   await savedArtifact.delete();
      //   return;
      // }

      // We also update the metamodel the model conforms to
      if (metamodel)
        await Metamodel.findByIdAndUpdate(
          metamodel._id,
          {
            $push: {
              models: savedModel._id,
            },
          },
          {
            new: true, //To return the updated value
          }
        );

      if (req.data)
        await Model.findByIdAndUpdate(
          savedModel._id,
          {
            $push: {
              involvedOperations: req.data.transformationName,
            },
          },
          {
            new: true, //To return the updated value
          }
        );

      const dataModel = await Model.findOne({
        _id: savedModel._id,
      });
      //.populate("artifact");

      // We are deleting data because after processing it
      // we dont persist it locally, we save it on the cloud!
      // await deleteFile(
      //   `./localStorage/artifacts/${req.folder}/` + req.file.filename
      // );

      logger.info("Model uploaded successfully!");

      await deleteFile(
        `./localStorage/artifacts/${req.folder}/` + req.file.filename
      );

      return {
        code: 200,
        message: "Model uploaded successfully!",
        dataModel,
      };
      // return res
      //   .status(200)
      //   .json({ message: "Model uploaded successfully!", modelData });
    } else {
      logger.warn("Model extension not supported or metamodel not found!");

      await deleteFile(
        `./localStorage/artifacts/${req.folder}/` + req.file.filename
      );

      return {
        code: 404,
        message: "Model extension not supported or metamodel not found!",
      };
      // return res
      //   .status(404)
      //   .json("Model extension not supported!  or metamodel not found");
    }
  } catch (err) {
    logger.error(err.toString());

    await deleteFile(
      `./localStorage/artifacts/${req.folder}/` + req.file.filename
    );

    return { code: 500, message: err.message };
    // return res.status(500).json(err.toString());
  }
};

// 2. Get all model by the project
/**
 * @swagger
 * /store/artifact/model:
 *  get:
 *      summary: Returns the list of models owned by the project
 *      tags: [Model]
 *      parameters:
 *          - in: query
 *            name: projectId
 *            schema:
 *              type: string
 *            required: true
 *            description: The model id
 *      responses:
 *          200:
 *              description: The model was retrieved successfully!
 *              content:
 *                  application/json:
 *                      schema:
 *                          example:
 *                              "message": "Models retrieved successfully!"
 *                              "Models":
 *                                  - "_id": "618cfff2b97ecd55ec8a4895"
 *                                    "name": "model-1636630514575.xmi"
 *                                    "metamodel": "6172c6ada05a9fc3a043715b"
 *                                    "project": "6172ab789ece0da287693c17"
 *                                    "type": "ECORE"
 *                                    "artifact": "6172c6ada05a9fc3a043715a"
 *          404:
 *               description: The project specified is not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 */
router.get("/model", async (req, res) => {
  const project = await Project.findById(req.query.projectId);

  if (project) {
    try {
      const models = await Model.find({ project: project._id });
      logger.info("Models retrieved successfully!");
      res
        .status(200)
        .json({ message: "Models retrieved successfully!", models });
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err);
    }
  } else {
    logger.warn("The project specified is not found!");
    res.status(404).json("The project specified is not found!");
  }
});

// 3. Get model by id
/**
 * @swagger
 * /store/artifact/model/{id}:
 *  get:
 *      summary: Returns the metamodel by id
 *      tags: [Model]
 *      parameters:
 *          - $ref: "#/components/parameters/idParam"
 *      responses:
 *          200:
 *              description: The metamodel was retrieved successfully!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/Model'
 *                          example:
 *                              "message": "Models retrieved successfully!"
 *                              "models":
 *                                  "models": ["6172c6bba05a9fc3a043715f"]
 *                                  "_id": "6172c6ada05a9fc3a043715b"
 *                                  "name": "DB-1634911917344.ecore"
 *                                  "project": "6172ab789ece0da287693c17"
 *                                  "type": "ECORE"
 *                                  "artifact": "6172c6ada05a9fc3a043715a"
 *          404:
 *               description: The workspace was not found
 *          500:
 *              description: An error occurred on the server, check the logs
 */
router.get("/model/:id", async (req, res) => {
  try {
    const models = await Model.findById(req.params.id);
    logger.info("Model retrieved successfully!");
    res.status(200).json({ message: "Model retrieved successfully!", models });
  } catch (err) {
    logger.error(err.toString());
    res.status(500).json(err);
  }
});

// 4. Update model
/**
 * @swagger
 * /store/artifact/model/{id}:
 *  put:
 *      summary: Update a model by id
 *      tags: [Model]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The model id
 *      requestBody:
 *          content:
 *              multipart/form-data:
 *                  schema:
 *                      $ref: '#/components/schemas/Model'
 *      responses:
 *          200:
 *              description: The model was successfully updated!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/Model'
 *                          example:
 *                              "message": "Model updated successfully!"
 *                              "modelData":
 *                                  "_id": "6172a7f8c2ff9c9cc97c2610"
 *                                  "name": "hello-1636635909628.xmi"
 *                                  "metamodel": "6172c6ada05a9fc3a043715b"
 *                                  "project": "6172ab789ece0da287693c17"
 *                                  "type": "XMI"
 *                                  "artifact":
 *                                      "accessControl": "PUBLIC"
 *                                      "_id": "618ce5eef407bd284d39acf3"
 *                                      "type": "MODEL"
 *                                      "size": 0
 *                                      "storageUrl": "http://base_url/files/model/hello-1636635909628.xmi"
 *                                      "description": "We are updating the model ..."
 *                                      "createdAt": "2021-11-11T09:44:14.289Z"
 *                                      "updatedAt": "2021-11-11T09:44:14.289Z"
 *          404:
 *              description: The metamodel was not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.put("/model/:id", async (req, res) => {
  let model = await Model.findById(req.params.id);

  upload = uploadFile("model");

  if (model) {
    upload(req, res, async (err) => {
      let metamodo = await Metamodel.findById(req.body.metamodel);
      if (err) {
        return res.status(500).json("Error uploading file.");
      } else if (metamodo) {
        let filename = req.file?.filename;
        let description = req.body?.description;
        let project = await Project.findById(req.body?.project);
        let artifactFile = await Artifact.findById(model.artifact);

        let data = {};
        let fileExt = "";

        if (filename) {
          data.filename = filename;
          fileExt = filename.split(".")[1].toUpperCase();
        }

        if (description) {
          data.description = description;
        }

        if (project) {
          data.project = project._id.toString();
        }

        try {
          let modelExts = ["XMI", "XML"];
          let valid = modelExts.includes(fileExt);

          if (filename) {
            if (valid) {
              let artifact = {
                project: req.body.project,
                type: "MODEL",
                size: req.file.size,
                storageUrl:
                  `http://${req.headers.host}/` +
                  "files/model/" +
                  req.file.filename,
                description: req.data
                  ? req.data.description
                  : req.body.description,
                accessControl: req.body?.accessControl,
                comment: req.body?.comment,
              };

              await deleteFile(
                "." +
                  artifactFile.storageUrl.split(`http://${req.headers.host}`)[1]
              ).then(async () => {
                await artifactFile.delete();
              });

              // Save the artifact
              const newArtifact = await Artifact(artifact);
              const savedArtifact = await newArtifact.save();

              data.artifact = savedArtifact._id.toString();
              data.storageUrl = `http://${req.headers.host}/` + req.file.path;
              data.name = req.file.filename;
              data.metamodel = req.body.metamodel;
            } else {
              logger.warn("Model extension not supported!");
              return res.status(404).json("Model extension not supported!");
            }
          }

          model = await Model.findById(req.params.id);
          await Artifact.findByIdAndUpdate(
            artifactFile._id,
            {
              $set: data,
            },
            { new: true }
          );

          await Metamodel.findByIdAndUpdate(
            model.metamodel,
            {
              $pull: {
                models: model._id,
              },
            },
            {
              new: true, //To return the updated value
            }
          );

          const updatedModel = await Model.findByIdAndUpdate(
            req.params.id,
            {
              $set: data,
            },
            { new: true }
          );

          await Metamodel.findByIdAndUpdate(
            updatedModel.metamodel,
            {
              $set: {
                models: updatedModel._id,
              },
            },
            {
              new: true, //To return the updated value
            }
          );

          const modelData = await Model.findOne({
            _id: updatedModel._id,
          }).populate("artifact");

          logger.info("Model updated successfully!");

          return res
            .status(200)
            .json({ message: "Model updated successfully!", modelData });
        } catch (err) {
          logger.error(err.toString());
          return res.status(500).json(err.toString());
        }
      } else {
        await deleteFile("./" + req.file.path);
        logger.info("Model with Metamodel specified does not exist!");
        return res
          .status(404)
          .json("Model with Metamodel specified does not exist!");
      }
    });
  } else {
    logger.info("Model with ID specified does not exist!");
    return res.status(404).json("Model with ID specified does not exist!");
  }
});

// 5. Delete model
/**
 * @swagger
 * /store/artifact/model/{id}:
 *  delete:
 *      summary: Delete a model by id
 *      tags: [Model]
 *      parameters:
 *          - $ref: "#/components/parameters/idParam"
 *      responses:
 *          200:
 *              description: The model was successfully deleted!
 *          404:
 *              description: The model was not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.delete("/model/:id", async (req, res) => {
  const model = await Model.findById(req.params.id);

  if (model) {
    const artifact = await Artifact.findById(model.artifact);

    try {
      await deleteFile(
        "." + artifact.storageUrl.split(`http://${req.headers.host}`)[1]
      );

      await Metamodel.updateOne(
        { _id: model.metamodel },

        {
          $pull: {
            models: model._id,
          },
        },
        {
          new: true, //To return the updated value
        }
      );

      await artifact.delete();
      await model.delete();

      logger.info("Model was deleted successfully!");
      return res.status(200).json("Model was deleted successfully!");
    } catch (err) {
      logger.error(err.toString());
      return res.status(500).json(err.toString());
    }
  } else {
    logger.info("Model with ID specified does not exist!");
    return res.status(404).json("Model with ID specified does not exist!");
  }
});

/**
 *  ------------------------- DOMAIN SPECIFIC LANGUAGES ---------------------------
 */

// 1.1 Save dsl
/**
 * @swagger
 * /store/artifact/script:
 *  post:
 *      summary: Save a dsl
 *      tags: [Dsl]
 *      requestBody:
 *          content:
 *              multipart/form-data:
 *                  schema:
 *                      $ref: '#/components/schemas/Dsl'
 *      responses:
 *          200:
 *              description: The dsl was successfully created
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          example:
 *                              "message": "Dsl was uploaded successfully!"
 *                              "dslData":
 *                                  "_id": "618cc6e0a0fb8184fa45967f"
 *                                  "name": "Demo-1636636781627.eol"
 *                                  "project": "6172ab789ece0da287693c17"
 *                                  "type": "EOL"
 *                                  "artifact":
 *                                      "accessControl": "PUBLIC"
 *                                      "_id": "618d186db3254e64247b44a9"
 *                                      "type": "DSL"
 *                                      "storageUrl":  "http://${req.headers.host}/localStorage/artifacts/script/Demo-1636636781627.eol"
 *                                      "size": 249
 *                                      "description": "WE ARE SAVING THE DSL"
 *                                      "createdAt": "2021-11-11T07:31:44.693Z"
 *                                      "updatedAt": "2021-11-11T07:31:44.693Z"
 *          404:
 *               description: File extension not supported or file not found!
 *          500:
 *              description: An error occurred on the server, check the logs!
 */
router.post("/script", upload("scripts").single("file"), async (req, res) => {
  // const p_id = req.data ? req.data.project : req.body.project;
  // if (p_id) {
  //   const data = await uploadScript(req);

  //   return res
  //     .status(data.code)
  //     .json({ message: data.message, data: data.dslData });
  // } else {
  //   logger.error("Missing project id");
  //   return { code: 500, message: "Missing project id" };
  // }
  let folder = req.originalUrl.split("/").pop();
  req.folder = folder;

  try {
    const p_id = req.data ? req.data.project : req.body.project;

    if (!p_id) {
      logger.error("Missing project id");
      await deleteFile(
        `./localStorage/artifacts/${req.folder}/` + req.file.filename
      );

      return { code: 500, message: "Missing project id" };
    }

    const data = await uploadScript(req);

    return res
      .status(data.code)
      .json({ message: data.message, data: data.dataDsl });
  } catch (err) {
    logger.error(err.message);
    await deleteFile(
      `./localStorage/artifacts/${req.folder}/` + req.file.filename
    );
    return { code: 500, message: err.message };
  }
});

const uploadScript = async (req, res) => {
  let fileExt = req.file.filename.split(".")[1].toUpperCase();

  const url = await uploadOnCloud(
    "dsls",
    req
    // req.file.path,
    // req.file.filename
  );

  req.publicUrl = url;

  try {
    const dslExts = ["ETL", "EOL", "EML", "ECL", "EVL", "ATL"];
    const valid = dslExts.includes(fileExt);

    if (valid) {
      let data = await readFile("dsl", req.file.path);

      let dslData = await Dsl.findOne({ content: data.content });

      if (dslData) {
        if (
          !dslData.project.includes(
            req.data ? req.data.project : req.body.project
          )
        ) {
          dslData = await Dsl.findByIdAndUpdate(
            dslData._id,
            {
              $push: {
                project: req.data ? req.data.project : req.body.project,
              },
            },
            {
              new: true, //To return the updated value
            }
          );
        }

        await deleteFile(
          `./localStorage/artifacts/${req.folder}/` + req.file.filename
        );

        return {
          code: 409,
          message: "Dsl already exists!",
          dslData,
        };
      }

      // let artifact = {
      //   type: "DSL",
      //   storageUrl: req.publicUrl,
      //   // `http://${req.headers.host}/` + "files/script/" + req.file.filename,
      //   size: req.file.size,
      //   description: req.data ? req.data.description : req.body.description,
      //   accessControl: req.body?.accessControl,
      //   comment: req.body?.comment,
      //   content: data.content,
      // };

      // Save the artifact
      // const newArtifact = await Artifact(artifact);
      // const savedArtifact = await newArtifact.save();

      // Save dsl
      const dsl = {
        name: req.file.originalname,
        unique_name: req.file.filename,
        project: req.data ? req.data.project : req.body.project,
        ext: fileExt,
        // artifact: savedArtifact._id,
        // type: "DSL",
        storageUrl: req.publicUrl,
        // `http://${req.headers.host}/` + "files/script/" + req.file.filename,
        size: req.file.size,
        description: req.data ? req.data.description : req.body.description,
        accessControl: req.body?.accessControl,
        comment: req.body?.comment,
        content: data.content,
      };

      const newDsl = await Dsl(dsl);
      const savedDsl = await newDsl.save();

      // if (!savedDsl) {
      //   await savedArtifact.delete();
      //   return;
      // }

      if (req.data)
        await Dsl.findByIdAndUpdate(
          savedDsl._id,
          {
            $push: {
              involvedOperations: req.data.transformationName,
            },
          },
          {
            new: true, //To return the updated value
          }
        );

      const dataDsl = await Dsl.findOne({
        _id: savedDsl._id,
      });
      // .populate("artifact");

      // await deleteFile(
      //   `./localStorage/artifacts/${req.folder}/` + req.file.filename
      // );

      logger.info("Dsl was uploaded successfully!");

      return {
        code: 200,
        message: "Dsl was uploaded successfully!",
        dataDsl,
      };

      // return res
      //   .status(200)
      //   .json({ message: "Dsl was uploaded successfully!", dslData });
    } else {
      logger.warn("Dsl extension not supported!");
      // return res.status(404).json("Dsl extension not supported!");
      await deleteFile(
        `./localStorage/artifacts/${req.folder}/` + req.file.filename
      );

      return {
        code: 404,
        message: "Dsl extension not supported!",
      };
    }
  } catch (err) {
    logger.error(err.toString());
    // return res.status(500).json(err.toString());
    await deleteFile(
      `./localStorage/artifacts/${req.folder}/` + req.file.filename
    );

    return { code: 500, message: err.message };
  }
};

// 2. Get all dsls by the project
/**
 * @swagger
 * /store/artifact/script:
 *  get:
 *      summary: Returns the list of dsl owned by the project
 *      tags: [Dsl]
 *      parameters:
 *          - in: query
 *            name: projectId
 *            schema:
 *              type: string
 *            required: true
 *            description: The project id
 *      responses:
 *          200:
 *              description: The dsl was retrieved successfully!
 *              content:
 *                  application/json:
 *                      schema:
 *                          example:
 *                              "message": "Dsls retrieved successfully!"
 *                              "dsls":
 *                                  - "_id": "6172cd250f5535cf271f1a8c"
 *                                    "name": "hello-1634913608568.eol"
 *                                    "project": "6172ab789ece0da287693c17"
 *                                    "type": "EOL"
 *                                    "artifact": "6172cd480f5535cf271f1a91"
 *          404:
 *               description: The project specified is not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 */
router.get("/script", async (req, res) => {
  const project = await Project.findById(req.query.projectId);

  if (project) {
    try {
      const dsls = await Dsl.find({ project: project._id });
      logger.info("Dsls retrieved successfully!");
      res.status(200).json({ message: "Dsls retrieved successfully!", dsls });
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err);
    }
  } else {
    logger.warn("The project specified is not found!");
    res.status(404).json("The project specified is not found!");
  }
});

// 3. Get dsl by id
/**
 * @swagger
 * /store/artifact/script/{id}:
 *  get:
 *      summary: Returns the dsl by id
 *      tags: [Dsl]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The dsl id
 *      responses:
 *          200:
 *              description: The dsl was retrieved successfully!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/Dsl'
 *                          example:
 *                              "message": "Dsl retrieved successfully!"
 *                              "dslData":
 *                                  "_id": "6172cd250f5535cf271f1a8c"
 *                                  "name": "hello-1634913608568.eol"
 *                                  "project": "6172ab789ece0da287693c17"
 *                                  "type": "EOL"
 *                                  "artifact": "6172cd480f5535cf271f1a91"
 *          404:
 *               description: The workspace was not found
 *          500:
 *              description: An error occurred on the server, check the logs
 */
router.get("/script/:id", async (req, res) => {
  try {
    const dsls = await Dsl.findById(req.params.id);
    if (dsls) {
      logger.info("Dsl retrieved successfully!");
      res.status(200).json({ message: "Dsl retrieved successfully!", dsls });
    } else {
      logger.info("Dsl specified not found!");
      res.status(200).json({ message: "Dsl specified not found!", dsls });
    }
  } catch (err) {
    logger.error(err.toString());
    res.status(500).json(err);
  }
});

// 4. Update dsl
/**
 * @swagger
 * /store/artifact/script/{id}:
 *  put:
 *      summary: Update a dsl by id
 *      tags: [Dsl]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The dsl id
 *      requestBody:
 *          content:
 *              multipart/form-data:
 *                  schema:
 *                      $ref: '#/components/schemas/Dsl'
 *      responses:
 *          200:
 *              description: The dsl was successfully updated!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/Dsl'
 *                          example:
 *                              "message": "Dsl was updated successfully!"
 *                              "dslData":
 *                                  "_id": "6172cd250f5535cf271f1a8c"
 *                                  "name": "hello-1636638635205.eol"
 *                                  "project": "6172ab789ece0da287693c17"
 *                                  "type": "EOL"
 *                                  "artifact":
 *                                      "accessControl": "PUBLIC"
 *                                      "_id": "618ce5eef407bd284d39acf3"
 *                                      "type": "DSL"
 *                                      "size": 249
 *                                      "storageUrl": "http://base_url/files/metamodel/DB-1636623854264.ecore"
 *                                      "description": "We are updating the dsl ..."
 *                                      "createdAt": "2021-11-11T09:44:14.289Z"
 *                                      "updatedAt": "2021-11-11T09:44:14.289Z"
 *          404:
 *              description: The dsl was not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.put("/script/:id", async (req, res) => {
  let dsl = await Dsl.findById(req.params.id);
  upload = uploadFile("script");

  if (dsl) {
    upload(req, res, async (err) => {
      projectData = await Project.findById(req.body.project);
      if (err) {
        return res.status(500).json("Error uploading file.");
      } else if (projectData) {
        let filename = req.file?.filename;
        let description = req.body?.description;
        let project = await Project.findById(req.body?.project);
        let artifactFile = await Artifact.findById(dsl.artifact);

        let data = {};
        let fileExt = "";

        if (filename) {
          data.filename = filename;
          fileExt = filename.split(".")[1].toUpperCase();
        }

        if (description) {
          data.description = description;
        }

        if (project) {
          data.project = project._id.toString();
        }

        try {
          let dslExts = ["ETL", "EOL", "EML", "ECL", "EVL", "ATL"];
          let valid = dslExts.includes(fileExt);
          if (filename) {
            if (valid) {
              let artifact = {
                project: req.body.project,
                type: "DSL",
                size: req.file.size,
                storageUrl:
                  `http://${req.headers.host}/` +
                  "files/script/" +
                  req.file.filename,
                description: req.data
                  ? req.data.description
                  : req.body.description,
                accessControl: req.body?.accessControl,
                comment: req.body?.comment,
              };

              await deleteFile(
                "." +
                  artifactFile.storageUrl.split(`http://${req.headers.host}`)[1]
              ).then(async () => {
                await artifactFile.delete();
              });

              //   let file = await Artifact.findById(dsl.artifact);

              // Save the artifact
              const newArtifact = await Artifact(artifact);
              const savedArtifact = await newArtifact.save();

              data.artifact = savedArtifact._id.toString();
              data.storageUrl =
                `http://${req.headers.host}/` +
                "files/script/" +
                req.file.filename;
              data.name = req.file.filename;
            } else {
              logger.warn("File extension not supported!");
              return res.status(404).json("File extension not supported!");
            }
          }

          dsl = await Dsl.findById(req.params.id);
          await Artifact.findByIdAndUpdate(
            artifactFile._id,
            {
              $set: data,
            },
            { new: true }
          );

          const updatedDsl = await Dsl.findByIdAndUpdate(
            req.params.id,
            {
              $set: data,
            },
            { new: true }
          );

          const dslData = await Dsl.findOne({
            _id: updatedDsl._id,
          }).populate("artifact");

          logger.info("File updated successfully!");

          return res
            .status(200)
            .json({ message: "File updated successfully!", dslData });
        } catch (err) {
          logger.error(err.toString());
          return res.status(500).json(err.toString());
        }
      } else {
        await deleteFile("./" + req.file.path);
        logger.warn("Project specified does not exist");
        return res.status(404).json("Project specified does not exist");
      }
    });
  } else {
    logger.info("File with ID specified does not exist!");
    return res.status(404).json("File with ID specified does not exist!");
  }
});

// 5. Delete dsl
/**
 * @swagger
 * /store/artifact/script/{id}:
 *  delete:
 *      summary: Delete a dsl by id
 *      tags: [Dsl]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The dsl id
 *      responses:
 *          200:
 *              description: The dsl was successfully deleted!
 *          404:
 *              description: The dsl was not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.delete("/script/:id", async (req, res) => {
  const dsl = await Dsl.findById(req.params.id);

  if (dsl) {
    const artifact = await Artifact.findById(dsl.artifact);

    try {
      await deleteFile(
        "." + artifact.storageUrl.split(`http://${req.headers.host}`)[1]
      );
      await artifact.delete();
      await dsl.delete();

      logger.info("Dsl was deleted successfully!");
      return res.status(200).json("Dsl was deleted successfully!");
    } catch (err) {
      logger.error(err.toString());
      return res.status(500).json(err.toString());
    }
  } else {
    logger.info("Dsl with ID specified does not exist!");
    return res.status(404).json("Dsl with ID specified does not exist!");
  }
});

const artifactRouter = router;
module.exports = { artifactRouter, uploadMetamodel, uploadModel, uploadScript };

// let metaMMa = await Metamodel.find({
//   project: { $in: [req.data ? req.data.project : req.body.project] },
// });

//   if (!metamodelData.workspace.includes(project.workspace))
//     await Metamodel.findByIdAndUpdate(
//       savedMetaModel._id,
//       {
//         $push: {
//           workspace: project.workspace,
//         },
//       },
//       {
//         new: true, //To return the updated value
//       }
//     );
