#!/bin/bash

# Take folder path as argument
folder_path=$1

# Check if folder path argument is passed
if [ -z "$folder_path" ]; then
    echo "No folder path provided. Usage: ./script.sh /path/to/json/files"
    exit 1
fi

# Define array of collection names
collections=("users" "workspaces" "projects" "metamodels" "models" "dsls" "transformations")

# Define MongoDB link
mongo_link="mongodb://localhost:27019"
mongo_db="mdeforge"

# Start the import process
echo "$(date): Starting the import process..." | tee -a import.log

# Loop over collections
for collection in "${collections[@]}"
do
    # Check if collection exists and create it if it doesn't
    echo "$(date): Checking and creating collection (if it doesn't exist): $collection..." | tee -a import.log
    echo "if (!db.getCollectionNames().includes(\"$collection\")) { db.createCollection(\"$collection\") }" | mongo --quiet $mongo_link/$mongo_db

    echo "$(date): Importing data into collection: $collection..." | tee -a import.log
    mongoimport --uri $mongo_link --db $mongo_db --collection $collection --file $folder_path/$collection.json --jsonArray
    if [ $? -eq 0 ]; then
        echo "$(date): Successfully imported data into collection: $collection" | tee -a import.log
    else
        echo "$(date): Failed to import data into collection: $collection" | tee -a import.log
    fi
done

echo "$(date): Data import complete." | tee -a import.log
