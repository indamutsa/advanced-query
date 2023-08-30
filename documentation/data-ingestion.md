# Installation of data ingestion tools

To import data, we need to install MongoDB tools in an Alpine Linux container, you can use the official MongoDB packages. Here are the steps:

1. Start by adding the official MongoDB repository to your `/etc/apk/repositories` file in the container:

```bash
# Add the official MongoDB repository
echo "http://dl-cdn.alpinelinux.org/alpine/v3.14/community" >> /etc/apk/repositories
```

2. Update your package lists:

```bash
# Update your package lists
apk update
```

3. Then, install the MongoDB tools:

```bash
# Install MongoDB tools to import data
apk add mongodb-tools=100.7.0-r2
```

This will install the MongoDB shell (`mongo`), import (`mongoimport`), export (`mongoexport`), and other tools.
After installation, you can confirm that the tools are installed by running:

```bash
# Check if mongoimport and mongoexport are installed
mongoimport --version
mongoexport --version
```

Each of these commands should return the version of the respective MongoDB tool.

Run the following command to start the system:

check if you can access the docker daemon from the container

```bash
# Check if you can access the docker daemon from the container
docker images
```

#### Importing data

Let us import the data into the MongoDB cluster. This data will be synchronized into Elasticsearch by Monstache, a synchronization tool designed to continuously move data from MongoDB to Elasticsearch.

Inside docker-compose.yml on the root, change each of the following line to your local path
give it an absolute form the host (your machine) path where you have the data files. Follow the example below:

```bash
# Change the path to the data files
vim docker-compose.yml
:%s#/home/arsene/Project/school-projects/mdeforge/advanced-query#your-path-to-the-cloned-folder#g
```

Here are the steps you should follow:

1. Connect to the MongoDB cluster and select the database where you want to insert your data.

   - The MongoDB cluster is accessible on port 27019 using this connection string: `mongodb://localhost:27019`
   - You can do this using the MongoDB shell or a GUI tool such as MongoDB Compass.

2. Download the data files from this <a href="https://drive.google.com/drive/folders/1hydGUBmqTuMW2FFqBNMdmTCOmn-vSF6X">link</a> and unzip them. You can run this command to unzip all the files at once. UNZIP IT in files folder inside the cloned folder.

```bash
unzip \*.zip
```

3. Insert your data into the chosen database. You can do this either manually or by importing data from a file.
   You can speed up the process by using the script `import.sh` provided in the files folder. and run the following commands:

```bash
chmod +x import.sh
./import.sh relative_path_to_data_unzipped_folder
sh
```
