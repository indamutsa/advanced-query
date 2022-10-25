sh.addShard("mongors1/mongors1n1:27017,mongors1n2:27017,mongors1n3:27017");
sh.addShard("mongors2/mongors2n1:27017,mongors2n2:27017,mongors2n3:27017");
// For testing the sharding
sh.enableSharding("testDb");
db.createCollection("kittens");
db.kittens.createIndex({ name: "hashed" });
sh.shardCollection("testDb.kittens", { name: "hashed" });

// MDEForge
sh.enableSharding("mdeforge");
db.createCollection("artifacts");
db.mdeforge.createIndex({ storageUrl: "hashed" });
sh.shardCollection("mdeforge.artifacts", { storageUrl: "hashed" });
