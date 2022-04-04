#!/bin/bash
###########################################
#
# Simple Shell script to clean/remove all container/images
#
# The script will 
#  - first stop all running containers (if any),
#  - remove containers
#  - remove images
#  - remove volumes

echo '####################################################'
echo 'Removing data...'
echo '####################################################'
#  Remove data
sudo rm -rf mongo-bundle/sharded/mongo_cluster/data1/*
sudo rm -rf mongo-bundle/sharded/mongo_cluster/data2/*
sudo rm -rf mongo-bundle/sharded/mongo_cluster/data3/*
sudo rm -rf mongo-bundle/sharded/mongo_cluster/data4/*
sudo rm -rf mongo-bundle/sharded/mongo_cluster/data5/*
sudo rm -rf mongo-bundle/sharded/mongo_cluster/data6/*
sudo rm -rf mongo-bundle/sharded/mongo_cluster/config1/*
sudo rm -rf mongo-bundle/sharded/mongo_cluster/config2/*
sudo rm -rf mongo-bundle/sharded/mongo_cluster/config3/*

# stop all running containers
echo '####################################################'
echo 'Stopping running containers (if available)...'
echo '####################################################'
docker stop $(docker ps -aq)

# remove all stopped containers
echo '####################################################'
echo 'Removing containers ..'
echo '####################################################'
docker rm $(docker ps -aq)


# remove all images
# echo '####################################################'
# echo 'Removing images ...'
# echo '####################################################'
# # docker rmi $(docker images -q)

# remove all stray volumes if any
echo '####################################################'
echo 'Revoming docker container volumes (if any)'
echo '####################################################'
docker volume rm $(docker volume ls -q)



# remove all images
# echo '####################################################'
# echo 'Removing persisted mongo replica data ...'
# echo '####################################################'

# sudo rm -rf mongo-rs0-1/data/*
# sudo rm -rf mongo-rs0-2/data/*
# sudo rm -rf mongo-rs0-3/data/*


# remove all images
echo '####################################################'
echo 'Spinning the cluster ...'
echo '####################################################'

docker-compose down -v --remove-orphans
docker-compose up -d --build --force-recreate
# sleep 45 | echo sleeping --- Connecting the shards to the mongos router ---------
# docker exec -it mongos1 bash -c "cat /home/app/addShards.js  | mongo "




