const mongoose = require("mongoose");

// Create Rose schema object
const roseSchema = new mongoose.Schema(
  {
    id: {
      type: String,
      required: true,
    },
    instance_args: {},
    instance_dependency: [{}],
    instance_type: {
      type: String,
      required: true,
    },
    meta_instance: {
      alta_dt: {
        type: String,
      },
      alta_usr: {
        type: String,
      },
      description: {
        type: String,
      },
      estado_cd: {
        type: String,
      },
      estado_dt: {
        type: String,
      },
      label: {
        type: String,
      },
      mod_dt: {
        type: String,
      },
      mod_usr: {
        type: String,
      },
    },
    metadata_load: {
      creation_dt: {
        type: String,
      },
      exec_sequence_cd: {
        type: String,
      },
      initial_proy_id: {
        type: String,
      },
      name_execution: {
        type: String,
      },
      stateexecution_cd: {
        type: String,
      },
      usr_cd: {
        type: String,
      },
    },
  },
  { timestamps: true }
);

// Create the model
const Rose = mongoose.model("Rose", roseSchema);

// Export the models
exports.Rose = Rose;

// {
//     "id": "string",
//     "instance_args":{},
//     "instance_dependency": [{}],
//     "instance_type": "string",
//     "meta_instance": {
//       "alta_dt": "string",
//       "alta_usr": "string",
//       "description": "string",
//       "estado_cd": "string",
//       "estado_dt": "string",
//       "label": "string",
//       "mod_dt": "string",
//    "mod_usr": "string"
//     },
//     "metadata_load": {
//       "creation_dt": "string",
//       "exec_sequence_cd": "string",
//       "initial_proy_id": "string",
//       "name_execution": "string",
//       "stateexecution_cd": "string",
//       "usr_cd": "string"
//     }
// }
