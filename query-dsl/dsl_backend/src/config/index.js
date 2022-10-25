// FILE: <project>/backend/src/config/index.js
"use-strict";

module.exports = {
  dslFileExt: "wl", // This should be, the extension of your language
  paths: {
    dslCompiler: "./compiler/compiler.jar", // Add this
    languageServer: "./language_server/language_server.jar",
  },
};
