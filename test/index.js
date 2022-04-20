const express = require("express");
const stream = require("stream");
const mongoose = require("mongoose");

const app = express();

const { Schema } = mongoose;
const { computeMetrics } = require("../persistence-api/startup/batchExecution");

const connectDb = async () => {
  // const uri = "mongodb://localhost:27019/sample_airbnb";
  const uri = "mongodb://178.238.238.209:27019/mdeforge";

  try {
    await mongoose
      .connect(uri, {
        useNewUrlParser: true,
        useUnifiedTopology: true,
      })
      .then(async (client) => {
        // const collection = await client.model("Listing");
        // const pipeline = [
        //   {
        //     $match: {
        //       operationType: { $in: ["update"] },
        //       "fullDocument.address.country": "Australia",
        //       "fullDocument.address.market": "Sydney",
        //     },
        //   },
        // ];

        // const changeStream = collection.watch(pipeline);
        // console.log(`Connected to database --> `);

        // changeStream.on("change", (change) => console.log(change));
        console.log("Successfully connected to database");
      })
      .catch((err) => {
        console.log(`Error connecting to the database. \n${err}`);
      });
  } catch (err) {
    console.log(err);
    process.exit(1);
  }
};

// Create a schema
const listingSchema = new mongoose.Schema(
  {
    name: {
      type: String,
    },
    summary: {
      type: String,
    },
    property_type: {
      type: String,
    },
    bedrooms: {
      type: String,
    },
    bathrooms: {
      type: String,
    },
    beds: {
      type: Number,
    },
    address: {
      market: { type: String },
      country: { type: String },
    },
  },
  { timestamps: true }
);

const Listing = mongoose.model("Listing", listingSchema);

const metamodelSchema = new Schema(
  {
    name: {
      type: String,
      required: true,
      // minlength: 2,
      // maxlength: 50,
    },

    unique_name: {
      type: String,
      require: true,
      unique: true,
    },

    type: {
      type: String,
      default: "METAMODEL",
    },

    ext: {
      type: String,
      enum: ["ECORE", "MPS"],
    },

    project: [
      {
        type: Schema.Types.ObjectId,
        ref: "Project",
      },
    ],

    models: [
      {
        type: Schema.Types.ObjectId,
        ref: "Model",
      },
    ],

    involvedOperations: [
      {
        type: String,
        ref: "Transformation",
      },
    ],
    license: {
      type: String,
      default: "MIT License",
      url: {
        type: String,
      },
    },
    storageUrl: {
      type: String,
      required: true,
      // minlength: 5,
      // maxlength: 200,
    },
    size: {
      type: Number,
      required: true,
    },
    description: {
      type: String,
    },
    accessControl: {
      type: String,
      enum: ["PRIVATE", "PUBLIC"],
      default: "PUBLIC",
    },
    comment: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "COMMENT",
    },
    metrics: [
      {
        name: {
          type: String,
        },
        code: {
          type: String,
        },
        value: {
          type: String,
        },
      },
    ],
    content: {
      type: String,
    },

    ePackage: {
      name: {
        type: String,
        default: "default",
      },
      nsURI: {
        type: String,
      },
      nsPrefix: {
        type: String,
      },
      eSubpackages: [
        {
          name: {
            type: String,
          },
          nsURI: {
            type: String,
          },
          nsPrefix: {
            type: String,
          },
          eClassifiers: [],
        },
      ],
    },
  },
  { timestamps: true }
);

// Create the model
const Metamodel = mongoose.model("Metamodel", metamodelSchema);

async function main() {
  try {
    connectDb();
    console.log("Successfully connected to the cluster!");

    app.use(express.json());
    app.use(express.urlencoded({ extended: false }));

    // const pipeline = [
    //   {
    //     $match: {
    //       operationType: "insert",
    //       "fullDocument.address.country": "Australia",
    //       "fullDocument.address.market": "Sydney",
    //     },
    //   },
    // ];

    // const metamodels = await Metamodel.find({ metrics: [] });
    // const metamodels = [1, 1, 1, 1, 1, 1, 1, 1, 11];
    // let i = 0;

    // for (let i = 0; i < metamodels.length; i++) {
    //   setInterval(() => {
    //     i++;
    //     console.log("print: ", i);
    //   }, 5000);
    // }

    const metamodels = await Metamodel.find({ metrics: [] });
    metamodels.forEach(async (metamodel) => {
      const res = await metamodel.updateOne({
        $set: { description: "updated the metrics --- " },
      });
      console.log(res);
    });

    // app.post("/post", async (req, res) => {
    //   try {
    //     // const metamodels = await Metamodel.find({ metrics: [] });
    //     const metamodels = [1, 1, 1, 1, 1, 1, 1, 1, 11];
    //     let i = 0;

    //     for (let i = 0; i < metamodels.length; i++) {
    //       setTimeout(() => {
    //         i++;
    //         console.log(i);
    //       }, 5000);
    //     }

    //     // await metamodels.forEach(async (metamodel) => {
    //     //   // await computeMetrics(metamodel._id);

    //     // });
    //   } catch (e) {
    //     console.log(e);
    //   }

    //   //   console.log(req.body);
    //   // const data = {
    //   //   name: "Opera House Views",
    //   //   summary:
    //   //     "Beautiful apartment with views of the iconic Sydney Opera House",
    //   //   property_type: "Apartment",
    //   //   bedrooms: 1,
    //   //   bathrooms: 1,
    //   //   beds: 1,
    //   //   address: {
    //   //     market: "Sydney",
    //   //     country: "Australia",
    //   //   },
    //   // };
    //   // const listing = await Listing(req.body);
    //   // const res_data = await listing.save();
    //   // console.log(res_data);
    //   res.status(200).json({ success: "true" });
    // });

    app.listen(6565, () => console.log("Connected to Express server!"));
  } catch (err) {
    // Close the connection to the MongoDB cluster
    // await client.close();
    console.log(err);
  }
}

main().catch(console.error);
