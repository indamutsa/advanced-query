const express = require("express");
const router = express.Router();
const Joi = require("joi");
const config = require("config");
const { User, validate } = require("../../models/User");
const authorize = require("../../middleware/authorize");
const logger = require("../../middleware/logger");

/**
 * @swagger
 * components:
 *  schemas:
 *      User:
 *          type: object
 *          required:
 *              - username
 *              - email
 *          properties:
 *              _id:
 *                  type: string
 *                  description: id of the workspace
 *              username:
 *                  type: string
 *                  description: The username of the user
 *              email:
 *                  type: string
 *                  description: The email of the user
 *              createdAt:
 *                  type: string
 *                  description: Creation date of the workspace
 *              updatedAt:
 *                  type: string
 *                  description: Updated date of the workspace
 *          example:
 *              username: "arsene"
 *              email: "arsene@indamutsa.com"
 *  parameters:
 *      idParam:
 *          in: path
 *          name: id
 *          schema:
 *              type: string
 *          required: true
 *          description: The user id
 *
 *
 */

/**
 * @swagger
 * tags:
 *  name: User
 *  description: The user API, this api under the hood communicates with the user management service to validate the user credentials
 *
 */

// Post the user
/**
 * @swagger
 * /store/user:
 *  post:
 *      summary: Create a new new user
 *      tags: [User]
 *      requestBody:
 *          required: true
 *          content:
 *              application/json:
 *                  schema:
 *                      $ref: '#/components/schemas/User'
 *      responses:
 *          200:
 *              description: The user was successfully created
 *              content:
 *                  application/json:
 *                      schema:
 *                          example:
 *                              message: User was created successfully!
 *                              savedUser:
 *                                  _id: 61bb78d91c2c3a05c5771918
 *                                  username: arsene
 *                                  email: arsene@indamutsa.com
 *                                  createdAt: '2021-12-16T17:35:21.871Z'
 *                                  updatedAt: '2021-12-16T17:35:21.871Z'
 *                                  __v: 0
 *          404:
 *               description: The user was not found
 *          500:
 *              description: An error occurred on the server, check the logs!
 */
router.post("/", async (req, res) => {
  const user = await User.findOne({ username: req.body.username });

  if (!user) {
    const newUser = await User(req.body);

    try {
      const savedUser = await newUser.save();
      logger.info("User was created successfully!");
      res
        .status(200)
        .json({ message: "User was created successfully!", savedUser });
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err.toString());
    }
  } else {
    logger.warn("The user already exists!");
    res.status(404).json("The user already exists!");
  }
});

/**
 * @swagger
 * /store/user:
 *  get:
 *      summary: Returns the user
 *      tags: [User]
 *      parameters:
 *          - in: query
 *            name: username
 *            schema:
 *              type: string
 *            required: true
 *            description: The username of the user
 *      responses:
 *          200:
 *              description: The user was retrieved successfully!
 *              content:
 *                  application/json:
 *                      schema:
 *                          type: object
 *                          items:
 *                              $ref: '#/components/schemas/User'
 *                          example:
 *                              message: User retrieved successfully!
 *                              savedUser:
 *                                  _id: 61bb78d91c2c3a05c5771918
 *                                  username: arsene
 *                                  email: arsene@indamutsa.com
 *                                  createdAt: '2021-12-16T17:35:21.871Z'
 *                                  updatedAt: '2021-12-16T17:35:21.871Z'
 *                                  __v: 0
 *          404:
 *               description: The user was not found
 */

// Getting the current user
router.get("/", async (req, res) => {
  try {
    const user = await User.findOne({ username: req.query.username });
    if (!user) return res.status(404).json({ message: "User not found!" });
    logger.info("User retrieved successfully!");
    res.status(200).json({ message: "User retrieved successfully!", user });
  } catch (err) {
    logger.error(err.toString());
    res.status(500).json(err.toString());
  }
});

// Update the user
/**
 * @swagger
 * /store/user/{id}:
 *  put:
 *      summary: Update a user by id
 *      tags: [User]
 *      parameters:
 *          - in: path
 *            name: id
 *            schema:
 *              type: string
 *            required: true
 *            description: The user id
 *      requestBody:
 *          required: true
 *          content:
 *              application/json:
 *                  schema:
 *                      $ref: '#/components/schemas/User'
 *
 *      responses:
 *          200:
 *              description: The user was successfully updated!
 *              content:
 *                  application/json:
 *                      schema:
 *                          $ref: '#/components/schemas/User'
 *                          example:
 *                              message: User updated successfully!
 *                              updatedUser:
 *                                  _id: 61bb78d91c2c3a05c5771918
 *                                  username: arsene
 *                                  email: arsene@indamutsa.com
 *                                  createdAt: '2021-12-16T17:35:21.871Z'
 *                                  updatedAt: '2021-12-16T17:35:21.871Z'
 *                                  __v: 0
 *          404:
 *              description: The user was not found
 *          500:
 *              description: An error occurred on the server, check the logs
 *
 */
router.put("/:id", async (req, res) => {
  const user = await User.findById(req.params.id);

  if (user) {
    try {
      const updatedUser = await User.findByIdAndUpdate(
        req.params.id,
        {
          $set: req.body,
        },
        { new: true }
      );
      logger.info("User updated successfully!");
      res
        .status(200)
        .json({ message: "User updated successfully!", updatedUser });
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err.toString());
    }
  } else {
    logger.warn("The user specified does not exist!");
    res.status(404).json("The user specified does not exist!");
  }
});

// Delete the user
/**
 * @swagger
 * /store/user/{id}:
 *  delete:
 *      summary: Delete a user by id
 *      tags: [User]
 *      parameters:
 *          - $ref: "#/components/parameters/idParam"
 *      responses:
 *          200:
 *              description: The user was successfully deleted
 *          404:
 *              description: The user was not found!
 */
router.delete("/:id", async (req, res) => {
  const user = await User.findById(req.params.id);
  if (user) {
    try {
      await user.delete();
      logger.info("User deleted successfully!");
      res.status(200).json("User deleted successfully!");
    } catch (err) {
      logger.error(err.toString());
      res.status(500).json(err.toString());
    }
  } else {
    logger.warn("The user specified does not exist!");
    res.status(404).json("The user specified does not exist!");
  }
});

module.exports = router;
