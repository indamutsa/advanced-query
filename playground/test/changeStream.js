/**
 * This script can be used to create, update, and delete sample data.
 * This script is especially helpful when testing change streams.
 */
const { MongoClient } = require("mongodb");

async function main() {
  /**
   * Connection URI. Update <username>, <password>, and <your-cluster-url> to reflect your cluster.
   * See https://docs.mongodb.com/drivers/node/ for more details
   */
  const uri =
    "mongodb+srv://arsene:arsene@cluster0.ldswd.mongodb.net/airbnb?retryWrites=true&w=majority";

  /**
   * The Mongo Client you will use to interact with your database
   * See https://mongodb.github.io/node-mongodb-native/3.6/api/MongoClient.html for more details
   * In case: '[MONGODB DRIVER] Warning: Current Server Discovery and Monitoring engine is deprecated...'
   * pass option { useUnifiedTopology: true } to the MongoClient constructor.
   * const client =  new MongoClient(uri, {useUnifiedTopology: true})
   */
  const client = new MongoClient(uri);

  try {
    // Connect to the MongoDB cluster
    await client.connect();
  } finally {
    // Close the connection to the MongoDB cluster
    await client.close();
  }
}

main().catch(console.error);

/**
 * Create a new Airbnb listing
 * @param {MongoClient} client A MongoClient that is connected to a cluster with the sample_airbnb database
 * @param {Object} newListing The new listing to be added
 * @returns {String} The id of the new listing
 */
async function createListing(client, newListing) {
  // See http://bit.ly/Node_InsertOne for the insertOne() docs
  const result = await client
    .db("sample_airbnb")
    .collection("listingsAndReviews")
    .insertOne(newListing);
  console.log(
    `New listing created with the following id: ${result.insertedId}`
  );
  return result.insertedId;
}

/**
 * Update an Airbnb listing
 * @param {MongoClient} client A MongoClient that is connected to a cluster with the sample_airbnb database
 * @param {String} listingId The id of the listing you want to update
 * @param {object} updatedListing An object containing all of the properties to be updated for the given listing
 */
async function updateListing(client, listingId, updatedListing) {
  // See http://bit.ly/Node_updateOne for the updateOne() docs
  const result = await client
    .db("sample_airbnb")
    .collection("listingsAndReviews")
    .updateOne({ _id: listingId }, { $set: updatedListing });

  console.log(`${result.matchedCount} document(s) matched the query criteria.`);
  console.log(`${result.modifiedCount} document(s) was/were updated.`);
}

/**
 * Delete an Airbnb listing
 * @param {MongoClient} client A MongoClient that is connected to a cluster with the sample_airbnb database
 * @param {String} listingId The id of the listing you want to delete
 */
async function deleteListing(client, listingId) {
  // See http://bit.ly/Node_deleteOne for the deleteOne() docs
  const result = await client
    .db("sample_airbnb")
    .collection("listingsAndReviews")
    .deleteOne({ _id: listingId });

  console.log(`${result.deletedCount} document(s) was/were deleted.`);
}
