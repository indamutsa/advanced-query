const express = require("express");
const stream = require("stream");
const mongoose = require("mongoose");

const app = express();

const connectDb = async () => {
  const uri = "mongodb://localhost:27019/sample_airbnb";

  try {
    await mongoose
      .connect(uri, {
        useNewUrlParser: true,
        useUnifiedTopology: true,
      })
      .then(async (client) => {
        const collection = await client.model("Listing");
        const pipeline = [
          {
            $match: {
              operationType: { $in: ["update"] },
              "fullDocument.address.country": "Australia",
              "fullDocument.address.market": "Sydney",
            },
          },
        ];

        const changeStream = collection.watch(pipeline);
        console.log(`Connected to database --> `);

        changeStream.on("change", (change) => console.log(change));
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

    app.post("/post", async (req, res) => {
      //   console.log(req.body);
      const data = {
        name: "Opera House Views",
        summary:
          "Beautiful apartment with views of the iconic Sydney Opera House",
        property_type: "Apartment",
        bedrooms: 1,
        bathrooms: 1,
        beds: 1,
        address: {
          market: "Sydney",
          country: "Australia",
        },
      };
      const listing = await Listing(req.body);
      const res_data = await listing.save();
      console.log(res_data);
      res.status(200).json(res_data);
    });

    app.listen(6565, () => console.log("Connected to Express server!"));
  } catch (err) {
    // Close the connection to the MongoDB cluster
    // await client.close();
    console.log(err);
  }
}

main().catch(console.error);
