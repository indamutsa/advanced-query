const express = require("express");
const Joi = require("joi");
const router = express.Router();
const { Project, validateProject } = require("../../models/Project");
const { Workspace, validateWorkspace } = require("../../models/Workspace");
const { User, validateUser } = require("../../models/User");
const logger = require("../../middleware/logger");

/**
 * @swagger
 * components:
 *  schemas:
 *      Project:
 *          type: object
 *          required:
 *              - username
 *              - email
 *          properties:
 *              _id:
 *                  type: string
 *                  description: id of the project
 *              name:
 *                  type: string
 *                  description: The name of the project
 *              workspace:
 *                  type: string
 *                  description: The id of the workspace
 *              description:
 *                  type: string
 *                  description: The description of the project
 *              sharedUser:
 *                  type: array
 *                  description: User shared by the project
 *              comment:
 *                  type: array
 *                  description: comments on the project
 *              createdAt:
 *                  type: string
 *                  description: Creation date of the project
 *              updatedAt:
 *                  type: string
 *                  description: Updated date of the project
 *          example:
 *              name: "Project 1"
 *              workspace: "6172a7f8c2ff9c9cc97c2610"
 *              description: "This is my first project"
 *  parameters:
 *      idParam:
 *          in: path
 *          name: id
 *          schema:
 *              type: string
 *          required: true
 *          description: The project id
 */

/**
 * @swagger
 * tags:
 *  name: Project
 *  description: The project managing API
 *
 */

// Post the project
/**
 * @swagger
 * /store/project:
 *  post:
 *      summary: Create a new new project
 *      tags: [Project]
 *      requestBody:
 *          required: true
 *          content:
 *              application/json:
 *                  schema:
 *                      $ref: '#/components/schemas/Project'
 *      responses:
 *          200:
 *              description: The project was successfully created
 *              content:
 *                  application/json:
 *                      schema:
 *                          example:
 *                              "message": "Project was created successfully!"
 *                              "newProject":
 *                                  "sharedUser": []
 *                                  "comment": []
 *                                  "_id": "61bb7ed288fa0711c6904db9"
 *                                  "name": "Project 1"
 *                                  "workspace": "61bb7c580cd7100d22b52510"
 *                                  "description": "This is my first project"
 *                                  "createdAt": "2021-12-16T18:00:50.373Z"
 *                                  "updatedAt": "2021-12-16T18:00:50.373Z"
 *                                  "__v": 0
 *          404:
 *               description: The project was not found
 *          500:
 *              description: An error occurred on the server, check the logs!
 */

// 1. Create a Project
router.post("/", async (req, res) => {
  const workspace = await Workspace.findOne({ _id: req.body.workspace });
  if (workspace) {
    try {
      const project = new Project(req.body);
      project.user = workspace.owner;

      const newProject = await project.save();

      // We also update the workspace projects
      await Workspace.findByIdAndUpdate(
        workspace._id,
        {
          $push: {
            projects: newProject._id,
          },
        },
        {
          new: true, //To return the updated value
        }
      );

      logger.info("Project was created successfully!");
      res
        .status(200)
        .json({ message: "Project was created successfully!", newProject });
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err.toString());
    }
  } else {
    logger.warn("The workspace does not exist!");
    res.status(404).json("The workspace does not exist!");
  }
});

// 2. Get a Project by id
/**
 * @swagger
 * /store/project/{id}:
 *  get:
 *      summary: Get a project by id
 *      tags: [Project]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The project id
 *
 *      responses:
 *          200:
 *              description: The project was retrieved successfully!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/Project'
 *                          example:
 *                              "_id": "6172ab789ece0da287693c17"
 *                              "name": "Project 1"
 *                              "workspace": "6172a7f8c2ff9c9cc97c2610"
 *                              "description": "This is my first project"
 *                              "createdAt": "2021-10-22T12:15:52.236Z"
 *                              "updatedAt": "2021-10-22T12:15:52.236Z"
 *          404:
 *              description: The user was not found
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.get("/:id", async (req, res) => {
  try {
    const project = await Project.findOne({ _id: req.params.id });

    if (project) {
      logger.info("Project retrieved successfully!");
      res
        .status(200)
        .json({ message: "Project retrieved successfully!", project });
    } else {
      logger.info("Project by the id specified does not exist!");
      res.status(404).json({
        message: "Project by the id specified does not exist!",
      });
    }
  } catch (err) {
    logger.error(err.toString());
    res.status(500).json(err);
  }
});

// 3. Get Projects by Workspace
/**
 * @swagger
 * /store/project:
 *  get:
 *      summary: Returns the list of projects owned by the workspace
 *      tags: [Project]
 *      parameters:
 *          - in: query
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The id of the workspace
 *      responses:
 *          200:
 *              description: The user was retrieved successfully!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: array
 *                          items:
 *                              $ref: '#/components/schemas/Project'
 *                          example:
 *                              "message": "Projects retrieved successfully!"
 *                              "projects":
 *                                  - "sharedUser": []
 *                                    "comment": []
 *                                    "_id": "6172ab789ece0da287693c17"
 *                                    "name": "Project 1"
 *                                    "workspace": "6172a7f8c2ff9c9cc97c2610"
 *                                    "description": "This is my first project"
 *                                    "createdAt": "2021-10-22T12:15:52.236Z"
 *                                    "updatedAt": "2021-10-22T12:15:52.236Z"
 *          404:
 *               description: The user was not found
 *          500:
 *              description: An error occurred on the server, check the logs
 */
router.get("/", async (req, res) => {
  const workspace = await Workspace.findOne({
    workspace: req.query.workspace,
  });

  if (workspace) {
    try {
      const projects = await Project.find({ workspace: workspace._id });

      logger.info("Projects retrieved successfully!");
      res
        .status(200)
        .json({ message: "Projects retrieved successfully!", projects });
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err);
    }
  } else {
    logger.warn("The workspace specified not found!");
    res.status(404).json("The workspace specified not found!");
  }
});

// 4. Update project by id
/**
 * @swagger
 * /store/project/{id}:
 *  put:
 *      summary: Update a project by id
 *      tags: [Project]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The project id
 *      requestBody:
 *          required: true
 *          content:
 *              application/json:
 *                  schema:
 *                      type: object
 *                      $ref: '#/components/schemas/Project'
 *                      example:
 *                          name: "Project updated"
 *                          description: "You can update all fields as in the schema"
 *      responses:
 *          200:
 *              description: The project was successfully updated!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/Project'
 *                          example:
 *                              "_id": "6172a7f8c2ff9c9cc97c2610"
 *                              "name": "Project 1"
 *                              "workspace": "6172a7f8c2ff9c9cc97c2610"
 *                              "description": "Project Updated"
 *                              "createdAt": "2021-10-22T12:00:56.079Z"
 *                              "updatedAt": "2021-10-22T12:15:52.247Z"
 *          404:
 *              description: The workspace was not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.put("/:id", async (req, res) => {
  const project = await Project.findById(req.params.id);

  if (project) {
    try {
      const updatedProject = await Project.findByIdAndUpdate(
        req.params.id,
        {
          $set: req.body,
        },
        { new: true }
      );
      logger.info("Project updated successfully!");
      res
        .status(200)
        .json({ message: "Project updated successfully!", updatedProject });
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err.toString());
    }
  } else {
    logger.warn("The project specified does not exist!");
    res.status(404).json("The project specified does not exist!");
  }
});

// 5. Delete a Project
/**
 * @swagger
 * /store/project/{id}:
 *  delete:
 *      summary: Delete a workspace by id
 *      tags: [Project]
 *      parameters:
 *          - $ref: "#/components/parameters/idParam"
 *      responses:
 *          200:
 *              description: The workspace was successfully deleted!
 *          404:
 *              description: The project was not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.delete("/:id", async (req, res) => {
  const project = await Project.findById(req.params.id);

  if (project) {
    try {
      await project.delete();
      await Workspace.updateOne(
        { _id: project.workspace },

        {
          $pull: {
            projects: project._id,
          },
        },
        {
          new: true, //To return the updated value
        }
      );
      logger.info("Project deleted successfully!");
      res.status(200).json("Project deleted successfully!");
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err.toString());
    }
  } else {
    logger.warn("The project specified does not exist!");
    res.status(404).json("The project specified does not exist!");
  }
});

module.exports = router;
