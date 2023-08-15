# Use a specific version of node:lts-alpine to ensure reproducibility
FROM node:14-alpine

# Add bash (if absolutely necessary, otherwise consider using the default shell)
RUN apk --no-cache add bash

# Create app directory and other necessary directories
WORKDIR /usr/src/app

# Avoid copying everything to reduce the context size and avoid copying unnecessary files
# .dockerignore can be used to exclude files and directories
COPY package.json yarn.lock ./

# Install app dependencies
RUN yarn install --frozen-lockfile

# Copy the rest of the app
COPY . .

# Create the localStorage directory after the app to avoid potential overwrites
RUN mkdir -p /localStorage/artifacts

# Specify the port the app runs on
EXPOSE 3200

# Use the CMD instruction correctly
CMD ["bash", "-c", "sleep 40 && npm run server"]
