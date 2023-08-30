Argo CD is a declarative, GitOps continuous delivery tool for Kubernetes. It follows the GitOps principles of using Git repositories as the source of truth for defining the desired application state. With Argo CD, you can automatically deploy and sync applications to Kubernetes clusters by just committing changes to your Git repository.

Here are the essentials of Argo CD CLI (Command Line Interface) from essential to advanced:

## Manual Installation

### 1. Prerequisites:

- A running Kubernetes cluster.
- kubectl CLI installed and configured to access your cluster.

### 2. Install Argo CD

Run the following `kubectl` command to install Argo CD:

```bash
kubectl create namespace argocd
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
```

This will create a new namespace 'argocd' and install Argo CD in it.

### 3. Access Argo CD API Server

Expose Argo CD API server using port-forwarding:

```bash
kubectl port-forward svc/argocd-server -n argocd 8080:443
```

Now, you can access Argo CD server at `https://localhost:8080`.

### 4. Download and install Argo CD CLI

Already installed in the container, please refer to the [installation guide](1.install-utilities.md) for more details.

## Basic Usage

### 1. Login

Login to Argo CD API server:

```bash
argocd login <argocd-server>
```

For example:

```bash
argocd login localhost:8080
```

### 2. Create an Application

Create a new application in Argo CD:

```bash
argocd app create <app-name> --repo <repo-url> --path <path-in-repo> --dest-namespace <namespace> --dest-server <cluster-url>
```

For example:

```bash
argocd app create my-app --repo https://github.com/example/example-repo.git --path /k8s-manifests --dest-namespace default --dest-server https://kubernetes.default.svc
```

### 3. Sync an Application

Sync an application to its desired state:

```bash
argocd app sync <app-name>
```

For example:

```bash
argocd app sync my-app
```

## Advanced Usage

### 1. App Management

- List all applications:

```bash
argocd app list
```

- Get application details:

```bash
argocd app get <app-name>
```

- Delete an application:

```bash
argocd app delete <app-name>
```

### 2. Cluster Management

- Add a cluster to Argo CD:

```bash
argocd cluster add <cluster-context>
```

- List all clusters:

```bash
argocd cluster list
```

### 3. Repository Management

- Add a repository to Argo CD:

```bash
argocd repo add <repo-url>
```

- List all repositories:

```bash
argocd repo list
```

### 4. Using Argo CD Autopilot

Argo CD Autopilot is a tool for setting up a complete GitOps workflow with Argo CD.

- Install Argo CD Autopilot:

```bash
brew install argoproj-labs/tap/argocd-autopilot
```

- Bootstrap a new repository with Argo CD and the App-of-Apps pattern:

```bash
argocd-autopilot repo bootstrap --repo <repo-url>
```

That covers the essentials of Argo CD CLI from basic to advanced usage. For more detailed information and advanced features, refer to the official [Argo CD documentation](https://argoproj.github.io/argo-cd/).
