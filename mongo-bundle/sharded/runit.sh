echo '####################################################'
echo 'Removing data...'
echo '####################################################'
#  Remove data
sudo rm -rf mongo_cluster/data1/*
sudo rm -rf mongo_cluster/data2/*
sudo rm -rf mongo_cluster/data3/*
sudo rm -rf mongo_cluster/data4/*
sudo rm -rf mongo_cluster/data5/*
sudo rm -rf mongo_cluster/data6/*
sudo rm -rf mongo_cluster/config1/*
sudo rm -rf mongo_cluster/config2/*
sudo rm -rf mongo_cluster/config3/*

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


docker-compose down -v --remove-orphans
docker-compose up --build --force-recreate
# sleep 45 | echo sleeping --- Connecting the shards to the mongos router ---------
# docker exec -it mongos1 bash -c "cat /home/app/addShards.js  | mongo "
