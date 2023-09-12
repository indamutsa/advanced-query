## Cluster installation using docker-compose

_N.B: The project will take around 15 minutes to setup depending on the connection and the host machine speed_

This might be the easier and faster way to run the system.

Run the following command to start the system:

```bash
docker-compose up
```

You can also run the system in detached mode by adding the `-d` flag:

```bash
docker-compose up -d
```

If you want to make sure changes to the docker-compose.yml file are applied, you can run the following command:

```bash
docker-compose up -d --build --force-recreate
```

This command will restart the Monstache container, which will trigger the synchronization process. 5. The frontend is accessible on port 3500. You can access it by navigating to `http://localhost:3500` in your browser. You can also access the Kibana dashboard on port 5601 to monitor the progress of the synchronization inside the dev tools section.

Now You can go ahead and import data into the MongoDB cluster. Click [here](3.data-ingestion.md) to see how to import data, well it is the next step anyways!.

#### Clean up

You can stop the system by running the following command:
Be careful, the commands below will stop all the containers, images and volumes and remove them.

```bash
docker-compose down -v --rmi all --remove-orphans && docker system prune -a --volumes
docker system prune -a # remove all dangling images

echo '####################################################'
echo 'Removing data...'
echo '####################################################'

# remove all images
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
echo '####################################################'
echo 'Removing images ...'
echo '####################################################'
docker rmi $(docker images -q)

# remove all stray volumes if any
echo '####################################################'
echo 'Revoming docker container volumes (if any)'
echo '####################################################'
docker volume rm $(docker volume ls -q)

# CAREFUL | Remove all images and volumes
docker rmi -f $(docker images -q) &&  docker system prune -a --volumes
```
