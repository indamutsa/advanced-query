sh.addShard("mongors1/mongors1n1:27017,mongors1n2:27017,mongors1n3:27017");
sh.addShard("mongors2/mongors2n1:27017,mongors2n2:27017,mongors2n3:27017");
sh.enableSharding("testDb");
db.createCollection("kittens");
db.kittens.createIndex({ name: "hashed" });
sh.shardCollection("testDb.kittens", { name: "hashed" });
