Kubectl is a command line tool for interacting with a Kubernetes cluster. Here is a list of essential to advanced `kubectl` commands along with examples:

1. **Basic Commands**

- **kubectl get:** This command is used to list one or more resources.

```bash
  # List all pods in the namespace
  kubectl get pods

  # List all pods in all namespaces
  kubectl get pods --all-namespaces

  # List a single replication controller with specified NAME
  kubectl get replicationcontroller my-rc
```

- **kubectl describe:** This command shows detailed information about a resource.

```bash
  # Describe a node
  kubectl describe nodes my-node

  # Describe a pod
  kubectl describe pods my-pod
```

- **kubectl create:** This command is used to create a resource from a file or stdin.

```bash
  # Create a pod using the data in pod.json.
  kubectl create -f ./pod.json

  # Create a pod based on the JSON passed into stdin.
  cat pod.json | kubectl create -f -
```

- **kubectl delete:** This command deletes resources either from a file, stdin, or specifying label selectors, names, resource selectors, or resources.

```bash
  # Delete a pod using the type and name specified in pod.json.
  kubectl delete -f ./pod.json

  # Delete all pods and services with label name=myLabel.
  kubectl delete pods,services -l name=myLabel
```

- **kubectl edit:** This command edits the resource on the server.

```bash
  # Edit the service named 'docker-registry':
  kubectl edit svc/docker-registry
```

- **kubectl apply:** This command applies a configuration change to a resource from a file or stdin.

```bash
  # Apply the configuration in pod.json to a pod.
  kubectl apply -f ./pod.json
```

2. **Intermediate Commands**

- **kubectl rollout:** This command manages a rollout.

```bash
  # View the rollout status of a deployment
  kubectl rollout status deployment/my-deployment

  # Rollback to the previous deployment
  kubectl rollout undo deployment/my-deployment
```

- **kubectl label:** This command updates the labels on a resource.

```bash
  Update pod 'foo' with the label 'unhealthy' and the value 'true'.
  kubectl label pods foo unhealthy=true
```

- **kubectl annotate:** This command updates the annotations on a resource.

```bash
  # Update pod 'foo' with the annotation 'description' and the value 'my frontend'.
  # If the same annotation is set multiple times, only the last value will be applied
  kubectl annotate pods foo description='my frontend'
```

- **kubectl scale:** This command sets a new size for a Deployment, ReplicaSet, Replication Controller, or StatefulSet.

```bash
  # Scale a replicaset named 'foo' to 3.
  kubectl scale --replicas=3 rs/foo

  # Scale a resource identified by type and name specified in "foo.yaml" to 3.
  kubectl scale --replicas=3 -f foo.yaml
```

- **kubectl autoscale:** This command auto-scales a set of pods.

```bash
  # Auto scale a deployment "foo"
  kubectl autoscale deployment foo --min=2 --max=10
```

3. **Advanced Commands**

- **kubectl port-forward:** This command forwards one or more local ports to a pod.

```bash
  # Listen on ports 5000 and 6000 locally, forwarding data to/from ports 5000 and 6000 in the pod
  kubectl port-forward pod/mypod 5000 6000

  # Listen on port 8888 locally, forwarding to 5000 in the pod
  kubectl port-forward pod/mypod 8888:5000
```

- **kubectl proxy:** This command runs a proxy to the Kubernetes API server.

```bash
  # To run a proxy to the Kubernetes API server
  kubectl proxy
```

- **kubectl run:** This command runs a particular image on the cluster.

```bash
  # Start a single instance of nginx.
  kubectl run nginx --image=nginx

  # Start a single instance of hazelcast and let the container expose port 5701.
  kubectl run hazelcast --image=hazelcast --port=5701
```

- **kubectl exec:** This command executes a command in a container.

```bash
  # Get output from running 'date' from pod 123456-7890, using the first container by default
  kubectl exec 123456-7890 date

  # Get output from running 'date' in ruby-container from pod 123456-7890
  kubectl exec 123456-7890 -c ruby-container date
```

- **kubectl cp:** This command copies files and directories to and from containers.

```bash
  # Copy /tmp/foo_dir local directory to /tmp/bar_dir in a remote pod in the default namespace
  kubectl cp /tmp/foo_dir <some-pod>:/tmp/bar_dir
```

- **kubectl taint:** This command applies a taint to a node.

```bash
  # Apply a taint on a node
  kubectl taint nodes node1 key=value:NoSchedule

  # Remove a taint on a node
  kubectl taint nodes node1 key:NoSchedule-
```

Note: In all the above examples, you can also use a filename in place of `-f`, e.g. `kubectl create --filename ./pod.json`.

This is by no means an exhaustive list of `kubectl` commands, but it covers most of the common use cases. For a complete list of commands and options, you can always run `kubectl --help` or refer to the [official Kubernetes documentation](https://kubernetes.io/docs/reference/generated/kubectl/kubectl-commands).
