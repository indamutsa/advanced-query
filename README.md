# MDEForge-Search System

MDEForge-Search, a novel tool introduced in this paper, addresses the need for efficient discovery and retrieval of modeling artifacts in the emerging field of model-driven engineering. Utilizing advanced discovery mechanisms, it retrieves heterogeneous artifacts within a megamodel context, promoting reuse across model management services. It features a domain-specific approach for queries using keywords, search tags, conditional operators, and a transformation chain discoverer, all in relation to quality model assessment services. Validated within a recommender system modeling framework, it leverages over 5,000 model artifacts currently stored in our cloud-based repository, MDEForge. Below is a guide on how to install and run the system from your host.

## Installation guide

Make sure docker is installed on your machine and you have a basic knowledge of docker and docker-compose. If not, please refer to the official documentation of docker and docker-compose. Here is a guide on how you can do this:

1. Clone the git repository of the project.

```bash
# Clone the repository
git clone https://github.com/indamutsa/advanced-query.git
```

2. Let us spin up the kubernetes cluster using kind. Kind is a tool for running local Kubernetes clusters using Docker container “nodes”. kind was primarily designed for testing Kubernetes itself, but may be used for local development or CI. Install it in your host machine by following the instructions in the official documentation. Once installed, run the following commands to create a cluster.

```bash
# Create a kind cluster
kind delete cluster --name mdeforge; kind create cluster --name mdeforge
```

3. Get a working container. Everything will be installed via a disposable container to avoid installing various on your host. Run the command below in your host terminal in the folder cloned.

```bash
# Run a working container
docker run -it --rm --net host --name working-container \
-v /var/run/docker.sock:/var/run/docker.sock \
-v ${HOME}/.kube/:/root/.kube/ \
-v ${PWD}:/work \
-w /work alpine sh
```

- [1. Install Utilities](documentation/1.install-utilities.md)
- [2. Spin the cluster using _docker-compose_](chapter3.md)
- [3. Data Ingestion](documentation/3.data-ingestion.md)
- [4. Install the cluster using kubectl](documentation/4.installation-kubectl.md)
