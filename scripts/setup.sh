#!/bin/bash
echo ******************************************
echo 'Initiating the config server replicaset'
echo ******************************************

# Wait 10 second and then sleep
sleep 120 | echo 'Sleeping ... for 40 seconds'

# Run the the replicaset
mongo mongodb://mongocfg1 < initConfig.js

# Wait 5 second and then execute the command
sleep 5 | echo 'Sleeping ...'

# Initiating the first shard
mongo mongodb://mongors1n1 < initShard1.js

# Wait 5 second and then sleep
sleep 5 | echo 'Sleeping ...'

# Initiating the first shard
mongo mongodb://mongors2n1 < initShard2.js

# Wait 30 second and then sleep
sleep 30 | echo 'Add shards ...'

# Initiating the first shard
mongo mongodb://mongos1:27017 < addShards.js

# Populate some data
sleep 10 | echo 'Waiting to populate data in the db' 
for i in {1..50}; do echo -e "use testDb \n db.kittens.insertOne({\"name\": \"SpiderMan $i\", \"language\": \"English\"})" | mongo mongodb://mongos1:27017; done
