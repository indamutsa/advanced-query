#!/bin/bash

# This script pushes the current branch to the remote repository
# and sets the upstream branch to the current branch.

# sudo chown 1000:1000 -R .  
git add .
git commit -m "$1"
git pull
git add .
git commit -m "$1"

# Change the IMAGE_TAG to the current git SHA (commit hash)
# ---------------------------------------------------------
# Get the current git SHA (commit hash) and take the first 8 characters
IMAGE_TAG=$(git rev-parse HEAD | cut -c 1-8)

if [ -z "$IMAGE_TAG" ]; then
  echo "ERROR: Unable to retrieve git SHA (commit hash)."
  exit 1
fi

# Directory containing the YAML files
DIR="./helm-deployment/"

# Iterate through each YAML file in the directory
for file in $DIR*.yaml; do
  echo "Updating $file with tag $IMAGE_TAG..."

  # Update the image tag for any image within the indamutsa/ namespace
  sed -i "s|indamutsa/\(.*\):[a-f0-9]\{40\}|indamutsa/\1:$IMAGE_TAG|g" $file
done

sleep 2
echo "Update complete."
# ---------------------------------------------------------

git push
echo "Changes pushed successfully"