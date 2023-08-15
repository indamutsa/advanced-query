#!/bin/bash

# Replace with your repository details
OWNER="indamutsa"
REPO="advanced-query"
BRANCH="main"

# Fetch the latest commit SHA for the given repository and branch
SHA=$(curl -s "https://api.github.com/repos/$OWNER/$REPO/commits/$BRANCH" | jq -r '.sha')

# Export the SHA as an environment variable
export IMAGE_TAG=$SHA

echo "Starting Docker Compose with image tag: $IMAGE_TAG"
# Run Docker Compose
# docker-compose up
