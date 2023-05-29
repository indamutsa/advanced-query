// Creating enums for artifact types (model, metamodel and dsl types)

const META_TYPE = {
  ECORE: "ECORE",
  MPS: "MPS",
  EMFATIC: "EMFATIC",
};

const MODEL_TYPE = {
  XMI: "XMI",
  XML: "XML",
};

const DSL_TYPE = {
  ETL: "ETL",
  EOL: "EOL",
  EML: "EML",
  ECL: "ECL",
  EVL: "EVL",
  ATL: "ATL",
};

const ARTIFACT_TYPE = {
  MODEL: "MODEL",
  META: "METAMODEL",
  DSL: "DSL",
};

// We freeze them to  render them unmodifiable
Object.freeze(DSL_TYPE);
Object.freeze(MODEL_TYPE);
Object.freeze(META_TYPE);
Object.freeze(ARTIFACT_TYPE);
