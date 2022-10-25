const express = require("express");
const Joi = require("joi");
const router = express.Router();
const { Workspace, validateWorkspace } = require("../../models/Workspace");
const { User, validate } = require("../../models/User");
const logger = require("../../middleware/logger");

/**
 * @swagger
 * components:
 *  schemas:
 *      Workspace:
 *          type: object
 *          required:
 *              - owner
 *              - name
 *          properties:
 *              _id:
 *                  type: string
 *                  description: id of the workspace
 *              projects:
 *                  type: array
 *                  description: List of projects pertained to a workspace
 *              name:
 *                  type: string
 *                  description: The name of the workspace
 *              owner:
 *                  type: string
 *                  description: The id of the workspace
 *              description:
 *                  type: string
 *                  description: The description of the workspace
 *              createdAt:
 *                  type: string
 *                  description: Creation date of the workspace
 *              updatedAt:
 *                  type: string
 *                  description: Updated date of the workspace
 *          example:
 *              name: "Workspace Arsene"
 *              owner: "61692b3b85301f4031966b42"
 *              description: "This is my workspace - 1 - description"
 *  parameters:
 *      idParam:
 *          in: path
 *          name: id
 *          schema:
 *              type: string
 *          required: true
 *          description: The workspace id
 *
 *
 */

/**
 * @swagger
 * tags:
 *  name: Workspace
 *  description: The workspace managing API
 *
 */

// CRUD OPERATIONS

// 1. Create a workspace
/**
 * @swagger
 * /store/workspace:
 *  post:
 *      summary: Create a new new workspace
 *      tags: [Workspace]
 *      requestBody:
 *          required: true
 *          content:
 *              application/json:
 *                  schema:
 *                      $ref: '#/components/schemas/Workspace'
 *      responses:
 *          200:
 *              description: The workspace was successfully created!
 *              content:
 *                  application/json:
 *                      schema:
 *                          example:
 *                              message: Workspace was created successfully!
 *                              savedWorkspace:
 *                                  projects: []
 *                                  _id: 61bb7c580cd7100d22b52510
 *                                  name: Workspace Arsene
 *                                  owner: 61bb7c480cd7100d22b5250d
 *                                  description: This is my workspace - 1 - description
 *                                  createdAt: '2021-12-16T17:50:16.104Z'
 *                                  updatedAt: '2021-12-16T17:50:16.104Z'
 *                                  __v: 0
 *          500:
 *              description: An error occurred on the server, check the logs!
 */
router.post("/", async (req, res) => {
  const user = await User.findOne({ _id: req.body.owner });

  if (user) {
    try {
      const newWorkspace = new Workspace(req.body);
      const savedWorkspace = await newWorkspace.save();

      logger.info("Workspace was created successfully!");
      res.status(200).json({
        message: "Workspace was created successfully!",
        savedWorkspace,
      });
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err.toString());
    }
  } else {
    logger.warn("The workspace or the user do not exists!");
    res.status(404).json("The workspace or the user do not exist!");
  }
});

// 2. Get workspace by id
/**
 * @swagger
 * /store/workspace/{id}:
 *  get:
 *      summary: Returns the workspace
 *      tags: [Workspace]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The id of the workspace
 *      responses:
 *          200:
 *              description: The workspace was retrieved successfully!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/Workspace'
 *                          example:
 *                              message: "Workspaces retrieved successfully!"
 *                              workspace:
 *                                  projects: ["6172ab789ece0da287693c17"]
 *                                  "_id": "6172a7f8c2ff9c9cc97c2610"
 *                                  "name": "Workspace Arsene Updated"
 *                                  "description": "This is my workspace - 1 - description Updated"
 *                                  "createdAt": "2021-10-22T12:00:56.079Z"
 *                                  "updatedAt": "2021-10-22T12:15:52.247Z"
 *          404:
 *               description: The workspace was not found
 *          500:
 *              description: An error occurred on the server, check the logs
 */
router.get("/:id", async (req, res) => {
  try {
    const workspace = await Workspace.findOne({ _id: req.params.id });
    if (!workspace)
      return res.status(404).json({ message: "No workspace found" });

    logger.info("Workspace retrieved successfully!");
    res
      .status(200)
      .json({ message: "Workspace retrieved successfully!", workspace });
  } catch (err) {
    logger.error(err.toString());
    res.status(500).json(err);
  }
});

// 3. Get all workspaces by the user
/**
 * @swagger
 * /store/workspace:
 *  get:
 *      summary: Returns the list of all the workspace by the user
 *      tags: [Workspace]
 *      parameters:
 *          - in: query
 *            name: username
 *            schema:
 *              type: string
 *            required: true
 *            description: The username of the owner
 *      responses:
 *          200:
 *              description: The list of workspaces retrieved successfully!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/Workspace'
 *                          example:
 *                              "message": "Workspaces retrieved successfully!"
 *                              "workspace":
 *                                  - "projects":
 *                                      - "6172ab789ece0da287693c17"
 *                                      - "618bcd292ea94f5bef71d6d3"
 *                                    "_id": "6172a7f8c2ff9c9cc97c2610"
 *                                    "name": "Workspace Arsene Updated"
 *                                    "owner": "61692b2a85301f4031966b3f"
 *                                    "description": "This is my workspace - 1 - description Updated"
 *                                    "createdAt": "2021-10-22T12:00:56.079Z"
 *                                    "updatedAt": "2021-11-10T13:46:17.719Z"
 *          404:
 *               description: The workspace or user was not found
 *          500:
 *              description: An error occurred on the server, check the logs
 */
router.get("/", async (req, res) => {
  const user = await User.findOne({ username: req.query.username });
  if (user) {
    try {
      const workspaces = await Workspace.find({ owner: user._id });

      logger.info("Workspaces retrieved successfully!");
      res
        .status(200)
        .json({ message: "Workspaces retrieved successfully!", workspaces });
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err);
    }
  } else {
    logger.warn("The user specified not found!");
    res.status(404).json("The user specified not found!");
  }
});

// 4. Update workspace
/**
 * @swagger
 * /store/workspace/{id}:
 *  put:
 *      summary: Update a workspace by id
 *      tags: [Workspace]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The workspace id
 *      requestBody:
 *          required: true
 *          content:
 *              application/json:
 *                  schema:
 *                      type: object
 *                      $ref: '#/components/schemas/Workspace'
 *                      example:
 *                          name: "Workspace Arsene"
 *                          owner: "61692b3b85301f4031966b42"
 *                          description: "This is my workspace - 1 - description"
 *
 *      responses:
 *          200:
 *              description: The workspace was successfully updated!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/Workspace'
 *                          example:
 *                              message: "Workspace updated successfully!"
 *                              workspace:
 *                                  projects: ["6172ab789ece0da287693c17"]
 *                                  "_id": "6172a7f8c2ff9c9cc97c2610"
 *                                  "name": "Workspace Arsene Updated"
 *                                  "description": "This is my workspace - 1 - description Updated"
 *                                  "createdAt": "2021-10-22T12:00:56.079Z"
 *                                  "updatedAt": "2021-10-22T12:15:52.247Z"
 *          404:
 *              description: The workspace was not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.put("/:id", async (req, res) => {
  const workspace = await Workspace.findById(req.params.id);

  if (workspace) {
    try {
      const updatedWorkspace = await Workspace.findByIdAndUpdate(
        req.params.id,
        {
          $set: req.body,
        },
        { new: true }
      );
      logger.info("Workspace updated successfully!");
      res
        .status(200)
        .json({ message: "Workspace updated successfully!", updatedWorkspace });
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err.toString());
    }
  } else {
    logger.warn("The workspace specified does not exist!");
    res.status(404).json("The workspace specified does not exist!");
  }
});

// 5. Delete workspace
/**
 * @swagger
 * /store/workspace/{id}:
 *  delete:
 *      summary: Delete a workspace by id
 *      tags: [Workspace]
 *      parameters:
 *          - $ref: "#/components/parameters/idParam"
 *      responses:
 *          200:
 *              description: The workspace was successfully deleted!
 *          404:
 *              description: The workspace was not found!
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.delete("/:id", async (req, res) => {
  const workspace = await Workspace.findById(req.params.id);
  if (workspace) {
    try {
      await workspace.delete();
      logger.info("Workspace deleted successfully!");
      res.status(200).json("Workspace deleted successfully!");
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err.toString());
    }
  } else {
    logger.warn("The workspace specified does not exist!");
    res.status(404).json("The workspace specified does not exist!");
  }
});

module.exports = router;
