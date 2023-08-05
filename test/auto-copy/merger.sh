#!/bin/bash

# List of files to merge
files1=(
  "mongors2-deployment.yaml"
  "mongors2n1-claim0-persistentvolumeclaim.yaml"
  "mongors2n1-service.yaml"
  "mongors2n2-claim0-persistentvolumeclaim.yaml"
  "mongors2n2-pod.yaml"
  "mongors2n2-service.yaml"
  "mongors2n3-claim0-persistentvolumeclaim.yaml"
  "mongors2n3-pod.yaml"
  "mongors2n3-service.yaml"
  # Add more files as needed
)

#!/bin/bash

# List of files to merge
files=(
  "file1.txt"
  "file2.txt"
  "file3.txt"
  # Add more files as needed
)

# Check for the correct number of arguments
if [ "$#" -ne 1 ]; then
  echo "Usage: $0 <destination_folder>"
  exit 1
fi

# Check if the destination folder exists, create if not
if [ ! -d "$1" ]; then
  mkdir -p "$1"
fi

# Temporary file for merging
temp_merged_file=$(mktemp)

# Iterate through the files and merge them
for file in "${files[@]}"; do
  # Check if the file exists and is readable
  if [ -f "$file" ] && [ -r "$file" ]; then
    cat "$file" >> "$temp_merged_file"
    # Add three blank lines
    echo -e "\n\n\n" >> "$temp_merged_file"
    # Move the individual file to the destination
    mv "$file" "$1"
  else
    echo "Warning: File $file not found or not readable. Skipping."
  fi
done

# Copy merged file to destination
cp "$temp_merged_file" "$1/merged_files.txt"

# Clean up temporary file
rm "$temp_merged_file"

echo "Files merged and moved to $1"


