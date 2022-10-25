const jwt = require("jsonwebtoken");
const config = require("config");

module.exports = function (req, res, next) {
  // Retrieve the token
  const token = req.header("x-auth-token");

  if (!token) return res.status(401).send("Access denied. No token provided");

  try {
    const decoded = jwt.verify(token, config.get("jwtPrivateKey"));
    req.user = decoded;

    // Calling next to call next middleware
    // If not called, it will hang on
    next();
  } catch (err) {
    res.status(400).json("Invalid token");
  }
};
