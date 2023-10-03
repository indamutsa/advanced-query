#!/bin/bash

# Get the current git SHA (commit hash) and take the first 8 characters
IMAGE_TAG=$(git rev-parse HEAD | cut -c 1-8)

if [ -z "$IMAGE_TAG" ]; then
  echo "ERROR: Unable to retrieve git SHA (commit hash)."
  exit 1
fi

# Directory containing the YAML files
DIR="./update-img/"

# Iterate through each YAML file in the directory
for file in $DIR*.yaml; do
  echo "Updating $file with tag $IMAGE_TAG..."

  # Update the image tag for any image within the indamutsa/ namespace
  sed -i "s|indamutsa/\(.*\):[a-f0-9]\{8\}|indamutsa/\1:$IMAGE_TAG|g" $file
done
sleep 5
echo "Update complete."
