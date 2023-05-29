# MDEForge-Search System
MDEForge-Search, a novel tool introduced in this paper, addresses the need for efficient discovery and retrieval of modeling artifacts in the emerging field of model-driven engineering. Utilizing advanced discovery mechanisms, it retrieves heterogeneous artifacts within a megamodel context, promoting reuse across model management services. It features a domain-specific approach for queries using keywords, search tags, conditional operators, and a transformation chain discoverer, all in relation to quality model assessment services. Validated within a recommender system modeling framework, it leverages over 5,000 model artifacts currently stored in our cloud-based repository, MDEForge. Below is a guide on how to install and run the system from your host.

<!-- 

apk add --no-cache docker curl py-pip python3-dev libffi-dev openssl-dev gcc libc-dev make  zip bash openssl git && pip install docker-compose && echo "http://dl-cdn.alpinelinux.org/alpine/v3.14/community" >> /etc/apk/repositories && apk update && apk add mongodb-tools && mongoimport --version && mongoexport --version -->
## Installation guide

Here is a guide on how you can do this:

1. Clone the git repository of the project.

```bash
git clone https://github.com/indamutsa/advanced-query.git
```

2. Get a working container. Everything will be installed via a disposable container to avoid installing various on your host. Run the command below in your host terminal in the folder cloned.

```bash
docker run -it --rm --net host -v /var/run/docker.sock:/var/run/docker.sock -v ${HOME}/.kube/:/root/.kube/ -v ${PWD}:/work -w /work alpine sh 
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
give it an absolute form the host (your machine) path where you have the data files

```
 /home/arsene/Project/school-projects/mdeforge/advanced-query
```

### Using docker-compose
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




#### Importing data
Let us import the data into the MongoDB cluster. This data will be synchronized into Elasticsearch by Monstache, a synchronization tool designed to continuously move data from MongoDB to Elasticsearch.

Here are the steps you should follow:
1. Connect to the MongoDB cluster and select the database where you want to insert your data.

   - The MongoDB cluster is accessible on port 27019 using this connection string: `mongodb://localhost:27019`
   - You can do this using the MongoDB shell or a GUI tool such as MongoDB Compass.
2. Download the data files from this <a href="https://drive.google.com/drive/folders/1hydGUBmqTuMW2FFqBNMdmTCOmn-vSF6X">link</a> and unzip them. You can run this command to unzip all the files at once.
   ```
   unzip \*.zip
   ```
3. Insert your data into the chosen database. You can do this either manually or by importing data from a file.
   You can speed up the process by using the script `import.sh` provided in the files folder. From the unzipped folder, mv import.sh script into the folder containing the unzipped and run the following commands:
   ```
   bash
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


### Using Kubernetes
This will require some knowledge of Kubernetes. 

Let us first install some utilities:

Install `kubectl`

```
curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl
chmod +x ./kubectl
mv ./kubectl /usr/local/bin/kubectl
```

Install `helm`

```
curl -fsSL -o get_helm.sh https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3
chmod 700 get_helm.sh
./get_helm.sh
```

Install `kind`

```
# For AMD64 / x86_64
[ $(uname -m) = x86_64 ] && curl -Lo ./kind https://kind.sigs.k8s.io/dl/v0.19.0/kind-linux-amd64
# For ARM64
[ $(uname -m) = aarch64 ] && curl -Lo ./kind https://kind.sigs.k8s.io/dl/v0.19.0/kind-linux-arm64
chmod +x ./kind
mv ./kind /usr/local/bin/kind
```

Start a Kubernetes cluster using `kind`

```
kind create cluster --name mdeforge
```

Let us inspect the cluster

```
kubectl cluster-info --context kind-mdeforge
```

You should see something like this:

```
Kubernetes control plane is running at https://127.0.0.1:38513
CoreDNS is running at https://127.0.0.1:38513/api/v1/namespaces/kube-system/services/kube-dns:dns/proxy

To further debug and diagnose cluster problems, use 'kubectl cluster-info dump'.
```

Make sure the nodes are ready

```
kubectl get nodes
NAME                     STATUS   ROLES           AGE   VERSION
mdeforge-control-plane   Ready    control-plane   83s   v1.27.1
```

Change the folder to kubernetes folder and cd in the helm-charts.

Helm is a package manager for Kubernetes that simplifies deployment of applications to your Kubernetes clusters. Below are some of the most frequently used Helm commands:

1. **Search a Chart**
    ```bash
    helm search hub <chart>  # Searches for a chart on Helm Hub
    ```

2. **Add a Chart Repository**
    ```bash
    helm repo add <repo_name> <repo_url>  # Adds a chart repository
    helm repo update  # Updates chart repository
    ```

3. **Install a Chart**
    ```bash
    helm install <release_name> <chart>  # Installs a chart
    ```

4. **Update a Chart**
    ```bash
    helm upgrade <release_name> <chart>  # Updates the deployed chart
    ```

5. **Rollback a Chart**
    ```bash
    helm rollback <release_name> <revision_number>  # Rollbacks to an older version of a release
    ```

6. **List all Deployed Charts**
    ```bash
    helm list  # Lists all the deployed charts
    ```

7. **Show Chart Information**
    ```bash
    helm show chart <chart>  # Shows information of a chart
    ```

8. **Uninstall a Release**
    ```bash
    helm uninstall <release_name>  # Uninstalls a release
    ```

9. **Create a Chart**
    ```bash
    helm create <chart_name>  # Creates a new chart with the given name
    ```

10. **Lint a Chart**
    ```bash
    helm lint <chart_path>  # Examines a chart for possible issues
    ```

11. **Package a Chart**
    ```bash
    helm package <chart_path>  # Packages a chart into a versioned chart archive
    ```

These are some basic commands. Depending on your use-case, you might need to use other commands as well. For the complete list of commands, you can run `helm --help` or check the Helm documentation. 

Remember to replace `<release_name>`, `<chart>`, `<repo_name>`, `<repo_url>`, `<revision_number>`, and `<chart_path>` with your actual values.

---

Let us spin up the cluster by running the following commands:

```
helm install .
```

You can check the status of the pods by running the following command:

```
kubectl get pods
```

You can check the status of the services by running the following command:

```
kubectl get services
```

You can check the status of the deployments by running the following command:

```
kubectl get deployments
```

You can check the status of the persistent volumes by running the following command:

```
kubectl get pv
```

You can check the status of the persistent volume claims by running the following command:

```
kubectl get pvc
```

You can check the status of the above resources by running the following command:

```
kubectl get all
```

To feed the data in the cluster, port forward the cluster primary node to your local machine. You might also need to port forward the Elasticsearch service to your local machine and then follow the steps inside docker-compose section from _importing data_ subsection .

port forwading uses this command:

```
kubectl port-forward <pod_name> <local_port>:<pod_port>
```
