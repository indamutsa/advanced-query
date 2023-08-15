# MDEForge-Search System

MDEForge-Search, a novel tool introduced in this paper, addresses the need for efficient discovery and retrieval of modeling artifacts in the emerging field of model-driven engineering. Utilizing advanced discovery mechanisms, it retrieves heterogeneous artifacts within a megamodel context, promoting reuse across model management services. It features a domain-specific approach for queries using keywords, search tags, conditional operators, and a transformation chain discoverer, all in relation to quality model assessment services. Validated within a recommender system modeling framework, it leverages over 5,000 model artifacts currently stored in our cloud-based repository, MDEForge. Below is a guide on how to install and run the system from your host.

<!--
apk add --no-cache docker curl py-pip python3-dev libffi-dev openssl-dev gcc libc-dev make  zip bash openssl git && pip install docker-compose && echo "http://dl-cdn.alpinelinux.org/alpine/v3.14/community" >> /etc/apk/repositories && apk update && apk add mongodb-tools && mongoimport --version && mongoexport --version -->

## Installation guide

Make sure docker is installed on your machine and you have a basic knowledge of docker and docker-compose. If not, please refer to the official documentation of docker and docker-compose. Here is a guide on how you can do this:

1. Clone the git repository of the project.

```bash
git clone https://github.com/indamutsa/advanced-query.git
```

2. Get a working container. Everything will be installed via a disposable container to avoid installing various on your host. Run the command below in your host terminal in the folder cloned.

```bash
docker run -it --rm --net host --name working-container -v /var/run/docker.sock:/var/run/docker.sock -v ${HOME}/.kube/:/root/.kube/ -v ${PWD}:/work -w /work alpine sh
```

3. Update the package repository and install necessary dependencies.

```bash
apk update
apk add --no-cache docker curl py-pip python3-dev libffi-dev openssl-dev gcc libc-dev make  zip bash openssl git
```

4. Install Docker Compose with pip (Python's package manager).

```bash
pip install docker-compose
```

Now, Docker Compose should be installed and you can confirm the installation by running:

```bash
docker-compose --version
```

It will return the version of Docker Compose installed, something like `docker-compose version 1.25.0, build 0a186604`.

---

To import data, we need to install MongoDB tools in an Alpine Linux container, you can use the official MongoDB packages. Here are the steps:

1. Start by adding the official MongoDB repository to your `/etc/apk/repositories` file:

```bash
echo "http://dl-cdn.alpinelinux.org/alpine/v3.14/community" >> /etc/apk/repositories
```

2. Update your package lists:

```bash
apk update
```

3. Then, install the MongoDB tools:

```bash
apk add mongodb-tools
```

Please make sure to replace `v3.14` with your specific Alpine version if it's different.

This will install the MongoDB shell (`mongo`), import (`mongoimport`), export (`mongoexport`), and other tools.

After installation, you can confirm that the tools are installed by running:

```bash
mongoimport --version
mongoexport --version
```

Each of these commands should return the version of the respective MongoDB tool.

Run the following command to start the system:

check if you can access the docker daemon from the container

```bash
docker images
```

It should return the list of images available on your system. At least alpine should be present.

Inside docker-compose.yml, change each of the following line to your local path
give it an absolute form the host (your machine) path where you have the data files. Follow the example below:

```
vi docker-compose.yml
:%s#/home/arsene/Project/school-projects/mdeforge/advanced-query#your-path-to-the-cloned-folder#g
```

### Using docker-compose

_N.B: The project will take around 15 minutes to setup depending on the connection and the host machine speed_

This might be the easier and faster way to run the system.

Run the following command to start the system:

```bash
docker-compose up # Now use start-dc.sh to start the system
```

You can also run the system in detached mode by adding the `-d` flag:

```bash
docker-compose up -d # Now use start-dc.sh to start the system
```

If you want to make sure changes to the docker-compose.yml file are applied, you can run the following command:

```bash
docker-compose up -d --build --force-recreate # Now use start-dc.sh to start the system
```

#### Importing data

Let us import the data into the MongoDB cluster. This data will be synchronized into Elasticsearch by Monstache, a synchronization tool designed to continuously move data from MongoDB to Elasticsearch.

Here are the steps you should follow:

1. Connect to the MongoDB cluster and select the database where you want to insert your data.

   - The MongoDB cluster is accessible on port 27019 using this connection string: `mongodb://localhost:27019`
   - You can do this using the MongoDB shell or a GUI tool such as MongoDB Compass.

2. Download the data files from this <a href="https://drive.google.com/drive/folders/1hydGUBmqTuMW2FFqBNMdmTCOmn-vSF6X">link</a> and unzip them. You can run this command to unzip all the files at once. UNZIP IT in files folder inside the cloned folder.
   ```
   unzip \*.zip
   ```
3. Insert your data into the chosen database. You can do this either manually or by importing data from a file.
   You can speed up the process by using the script `import.sh` provided in the files folder. and run the following commands:
   ```
   chmod +x import.sh
   ./import.sh relative_path_to_data_unzipped_folder
   sh
   ```
4. Let us rerurn monstache container to make sure the synchronization is working fine. Change the directory to the folder containing the docker-compose.yml file and run the following command:
   ```
   docker-compose up -d --force-recreate monstache
   ```
   This command will restart the Monstache container, which will trigger the synchronization process.
5. The frontend is accessible on port 3500. You can access it by navigating to `http://localhost:3500` in your browser. You can also access the Kibana dashboard on port 5601 to monitor the progress of the synchronization inside the dev tools section.

6. You can stop the system by running the following command:
   Be careful, the commands below will stop all the containers, images and volumes and remove them.

   ```
   docker-compose down -v
   docker rm $(docker ps -aq)
   docker volume rm $(docker volume ls -q)
   docker rmi -f $(docker images -q) #remove all images
   ```

   You can stop one by one by running the following commands:

   ```
   docker-compose down -v
   docker stop container_name && docker rm container_name
   docker rmi -f image_name
   ```

## Kubernetes deployment

Now that we have deployed the system using docker-compose, let us deploy it using Kubernetes. We will use Minikube to deploy the system locally. You can also use a cloud provider such as AWS, GCP, or Azure to deploy the system.

We are going to use kind to deploy the system. Kind is a tool for running local Kubernetes clusters using Docker container “nodes”. kind was primarily designed for testing Kubernetes itself, but may be used for local development or CI.

Let us first get a working container. Everything will be installed via a disposable container to avoid installing various on your host. Run the command below in your host terminal in the folder cloned.

```bash
# Create a kind cluster
cd ~/.../advanced-query
kind create cluster --name mdeforge
```

Next up, I will be running a small container where I will be doing all the work from:
You can skip this part if you already have `kubectl` and `helm` on your machine.

#### Run a working container

```bash
docker run -it --rm --net host -v ${HOME}/.kube/:/root/.kube/ -v ${PWD}:/work -w /work alpine sh
```

#### Install `kubectl`

```bash
apk add --no-cache curl
curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl
chmod +x ./kubectl
mv ./kubectl /usr/local/bin/kubectl
```

#### Install `helm`

```bash
curl -LO https://get.helm.sh/helm-v3.7.2-linux-amd64.tar.gz
tar -C /tmp/ -zxvf helm-v3.7.2-linux-amd64.tar.gz
rm helm-v3.7.2-linux-amd64.tar.gz
mv /tmp/linux-amd64/helm /usr/local/bin/helm
chmod +x /usr/local/bin/helm
```

Now we have `helm` and `kubectl` and can access our `kind` cluster:

#### Check if we can access the cluster

````bash

```bash
kubectl get nodes
NAME                  STATUS   ROLES                  AGE   VERSION
vault-control-plane   Ready    control-plane,master   37s   v1.21.1
````

#### Terraform CLI

```bash
# Get Terraform

curl -o /tmp/terraform.zip -LO https://releases.hashicorp.com/terraform/1.5.5/terraform_1.5.5_linux_amd64.zip
unzip /tmp/terraform.zip
chmod +x terraform && mv terraform /usr/local/bin/
terraform
```

## RUN THE CLUSTER

I like editing the yaml using the script and generate the yaml using the script, this way I can keep track of the changes I made to the yaml file in one single source of truth.
The script I am using is the hello folder and it is called `spin-templates.sh`

You can run the script to generate data after editing the templates:

```bash
# The scrui
./../hello/spin-templates.sh # While in templates folder
```

this will generate the yaml files in the templates folder.

To run the cluster:
cdhange the directory to cluster-helm-deployment, and run the following commands:

```bash
helm install mdeforge . -f values.yaml
```

In case you want to visualize all yaml files generated by helm, you can run the following command:

```bash
helm template mdeforge . -f values.yaml
# It can be forwarded to a file like this:
helm template mdeforge . -f values.yaml > mdeforge.yaml
```

--- ############################################################### ---

Get ArgoCD helm chart repository

```bash
helm repo add argo https://argoproj.github.io/argo-helm
helm repo update
```

Look for it in the helm repo

```bash
helm search repo argocd
```

To overwrite the default values, we can get the values file from the repo and edit it

```bash
helm show values argo/argo-cd --version 3.35.4 > argocd-values.yaml
```

Change the folder to argocd and initialize terraform to run argocd

```bash
terraform init
```

Apply it to run argocd

```bash
terraform apply --auto-approve
```

verify that argocd is running

```bash
kubectl get po -n argocd
```

Get its Secrets:

```bash
kubectl get secret -n argocd
```

Get the initial password

```bash
kubectl get secrets argocd-initial-admin-secret -o yaml -n argocd
```

Decode the password | the username is `admin`

```bash
echo -n 'password from above' | base64 -d
```

Port forward the argocd server

```bash
kubectl port-forward svc/argocd-server -n argocd 8080:443
```

and follow the instructions.

After that we can add application yaml to instruct argocd to track our repo

We will add some configuration and build agent to automate the build process.

<!-- prettier-ignore-start -->
❯ tree -L 2

.
├── cluster-deployment.sh
├── cluster-helm-deployment
│   ├── charts
│   ├── Chart.yaml
│   ├── hello
│   ├── templates
│   └── values.yaml
├── cluster-manifest-gen.sh
├── docker-compose.yml
├── elastic-bundle
│   ├── elasticsearch
│   ├── extensions
│   ├── filebeat
│   ├── kibana
│   └── logstash
├── elk.md
├── figures
│   └── querydia.jpg
├── files
│   ├── import.sh
│   ├── new
│   └── new-folder
├── frontend-search
│   ├── adhoc
│   ├── components
│   ├── context
│   ├── data
│   ├── Dockerfile
│   ├── next.config.js
│   ├── node_modules
│   ├── package.json
│   ├── pages
│   ├── public
│   ├── README.md
│   ├── services
│   ├── styles
│   ├── test
│   ├── yarn-error.log
│   └── yarn.lock
├── kind-config.yml
├── manifest-legacy
│   ├── main-depl
│   ├── merger.sh
│   ├── mongocfg
│   ├── mongors1
│   ├── mongors2
│   └── mongos
├── persistence-api
│   ├── ad-hoc
│   ├── config
│   ├── Dockerfile
│   ├── index.js
│   ├── localStorage
│   ├── logs
│   ├── lowcomote-storage.json
│   ├── middleware
│   ├── MIT License.txt
│   ├── models
│   ├── node_modules
│   ├── note.txt
│   ├── package.json
│   ├── public
│   ├── route
│   ├── services
│   ├── startup
│   ├── test.http
│   └── yarn.lock
├── push.sh
├── query-engine
│   ├── config
│   ├── controller
│   ├── data
│   ├── Dockerfile
│   ├── graphql
│   ├── microsyntax
│   ├── node_modules
│   ├── package.json
│   ├── package-lock.json
│   ├── README.md
│   ├── router
│   ├── server.js
│   ├── service
│   ├── test.json
│   ├── utils
│   └── yarn.lock
├── README.md
├── run.sh
├── scripts
│   ├── cluster-deployment.sh
│   ├── cluster-manifest-gen.sh
│   ├── import.sh
│   ├── merger.sh
│   ├── mongo-cluster-spin.sh
│   ├── push.sh
│   ├── runit.sh
│   ├── run.sh
│   ├── setup.sh
│   ├── spin-cluster-.sh
│   ├── spin-cluster.sh
│   ├── spin-elk-mongo.sh
│   ├── spinner.sh
│   ├── spin-templates.sh
│   ├── start-dc.sh
│   └── update-image.sh
├── setup
│   ├── addShards.js
│   ├── Dockerfile
│   ├── initConfig.js
│   ├── initShard1.js
│   ├── initShard2.js
│   ├── runit.sh
│   └── setup.sh
├── start-dc.sh
├── test
│   ├── auto-copy
│   ├── docker-compose.yml
│   ├── setup
│   ├── update-image.sh
│   └── update-img
└── yarn.lock

59 directories, 61 files

<!-- prettier-ignore-end -->

Create a repo to track with argocd

```bash
gh repo create
```

The first example is made of a simple application that will be deployed in the argo namespace. We have a folder at the root called app which contains the namespace and the deployment yaml files. And we have folder called example 1. This folder contains the application.yaml file. The application.yaml file is the one that will be used by argocd to deploy the application.

First apply the application.yaml file to argocd

```bash
kubectl apply -f 1-example/application.yaml
```

Now change the tag and push the image to the registry using the build-agent.sh script. The build-agent.sh script will build the image and push it to the registry, and push the changes to the repo after updating 1-deployment.yaml file with the new tag using the `sed` command.

```bash
./build-agent.sh v1.0.6
```

We shall see that the application is deployed in the argo namespace inside the dashboard of argocd `http://localhost:8080`.

All the resoureces including argocd deployment can be deleted by running

```bash
❯ kubectl delete all,secrets,configmaps,pv,pvc --all --all-namespaces
```

<br />

### Essential terraform commands

Terraform is a popular Infrastructure as Code (IaC) tool that allows users to define and provide data center infrastructure using a declarative configuration language. The `--yes` flag you mentioned doesn't exist directly in Terraform as of my last training cut-off in September 2021. However, Terraform does have a `-auto-approve` flag which skips the interactive approval of plan executions.

Here are some common Terraform commands:

1. **Initialization**: Sets up the backend and downloads required providers.

   ```
   terraform init
   ```

2. **Validating the Configuration**: Checks if the configuration files in the directory are syntactically valid and internally consistent.

   ```
   terraform validate
   ```

3. **Generating an Execution Plan**: Shows you what will happen when you apply your configuration.

   ```
   terraform plan
   ```

4. **Applying the Configuration**: Applies the changes required to achieve the desired state of the configuration.

   ```
   terraform apply
   ```

   If you want to automatically approve the apply without seeing the plan (not recommended for production use):

   ```
   terraform apply -auto-approve
   ```

5. **Destroy**: Destroys all the resources that have been created.

   ```
   terraform destroy
   ```

   To automatically approve the destruction:

   ```
   terraform destroy -auto-approve
   ```

6. **Refreshing the State**: Updates the local state file with the current state of the infrastructure.

   ```
   terraform refresh
   ```

7. **Outputting**: Shows the outputs from your configuration.

   ```
   terraform output
   ```

8. **Formatting**: Rewrites Terraform configuration files in the standard format.

   ```
   terraform fmt
   ```

9. **Importing Existing Infrastructure**: Takes already running infrastructure and brings it under Terraform management.

   ```
   terraform import [arguments] ADDRESS ID
   ```

10. **Workspace Management**: Manages workspaces, which allow for multiple distinct sets of infrastructure resources.

```
terraform workspace list
terraform workspace select NAME
terraform workspace new NAME
terraform workspace delete NAME
```

Remember, Terraform can be a very powerful tool, and with the `-auto-approve` flag, you can potentially make large changes without confirmation. Always be sure you understand the implications of your commands, especially when working with real-world infrastructure.
