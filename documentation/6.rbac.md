## Create Kubernetes cluster

- What is RBAC?

<br />
RBAC is a method of regulating access to computer or network resources based on the roles of individual users within an enterprise. In this context, access is the ability of an individual user to perform a specific task, such as view, create, or modify a file. Roles are assigned to users when they are created, and access permissions are assigned to roles. The control of access by assigning roles to users simplifies user management.

Remember we need to create a service account for argocd to access the cluster. We will create a service account and bind it to the cluster-admin role. However before this, let us make sure we know what role and cluster role are.

The role is a set of permissions that define what actions can be performed within a namespace. The cluster role is a set of permissions that define what actions can be performed within the cluster. The role binding is a way to bind a role to a user or a group of users. The cluster role binding is a way to bind a cluster role to a user or a group of users.

The cluster-admin role is a cluster-wide role that gives superuser access to all resources in the cluster and in all namespaces. The cluster-admin role is a cluster-wide role that gives superuser access to all resources in the cluster and in all namespaces.

Hence be careful when assigning this role to a service account.

```bash
cd kubernetes/rbac
kind create cluster --name rbac --image kindest/node:v1.26.3
```

## Kubernetes CA Certificate

Kubernetes does not have a concept of users, instead it relies on certificates and would only
trust certificates signed by its own CA. </br>

To get the CA certificates for our cluster, easiest way is to access the master node. </br>
Because we run on `kind`, our master node is a docker container. </br>
The CA certificates exists in the `/etc/kubernetes/pki` folder by default. </br>
If you are using `minikube` you may find it under `~/.minikube/.`

Access the master node:

```bash
docker exec -it rbac-control-plane bash

ls -l /etc/kubernetes/pki
total 60
-rw-r--r-- 1 root root 1135 Sep 10 01:38 apiserver-etcd-client.crt
-rw------- 1 root root 1675 Sep 10 01:38 apiserver-etcd-client.key
-rw-r--r-- 1 root root 1143 Sep 10 01:38 apiserver-kubelet-client.crt
-rw------- 1 root root 1679 Sep 10 01:38 apiserver-kubelet-client.key
-rw-r--r-- 1 root root 1306 Sep 10 01:38 apiserver.crt
-rw------- 1 root root 1675 Sep 10 01:38 apiserver.key
-rw-r--r-- 1 root root 1066 Sep 10 01:38 ca.crt
-rw------- 1 root root 1675 Sep 10 01:38 ca.key
drwxr-xr-x 2 root root 4096 Sep 10 01:38 etcd
-rw-r--r-- 1 root root 1078 Sep 10 01:38 front-proxy-ca.crt
-rw------- 1 root root 1679 Sep 10 01:38 front-proxy-ca.key
-rw-r--r-- 1 root root 1103 Sep 10 01:38 front-proxy-client.crt
-rw------- 1 root root 1675 Sep 10 01:38 front-proxy-client.key
-rw------- 1 root root 1679 Sep 10 01:38 sa.key
-rw------- 1 root root  451 Sep 10 01:38 sa.pub

exit the container
```

# Kubernetes Users

As mentioned before, Kubernetes has no concept of users, it trusts certificates that is signed by its CA. <br/>
This allows a lot of flexibility as Kubernetes lets you bring your own auth mechanisms, such as [OpenID Connect](https://kubernetes.io/docs/reference/access-authn-authz/authentication/#openid-connect-tokens) or OAuth. </br>

 <p> This allows managed Kubernetes offerings to use their cloud logins to authenticate. </p>

So on Azure, I can use my Microsoft account, GKE my Google account and AWS EKS my Amazon account. </br>

You will need to consult your cloud provider to setup authentication. </br>
Example [Azure AKS](https://docs.microsoft.com/en-us/azure/aks/azure-ad-integration-cli)

## User Certificates

First thing we need to do is create a certificate signed by our Kubernetes CA. </br>
We have the CA, let's make a certificate. </br>

Easy way to create a cert is use `openssl` which we already installed in the container.

Let us delete some certs that we will be creating in this section

```bash
# Delete previous certs
cd rbac
rm -f *.crt *.key *.srl *.csr *.pem
```

Copy the certs out of our master node:

```bash
docker cp mdeforge-control-plane:/etc/kubernetes/pki/ca.crt ca.crt
docker cp mdeforge-control-plane:/etc/kubernetes/pki/ca.key ca.key
```

Let's create a certificate for Bob Smith:

```bash
#start with a private key
openssl genrsa -out bob.key 2048

```

Now we have a key, we need a certificate signing request (CSR). </br>
We also need to specify the groups that Bob belongs to. </br>
Let's pretend Bob is part of the `Shopping` team and will be developing
applications for the `Shopping`

```bash
openssl req -new -key bob.key -out bob.csr -subj "/CN=Bob Smith/O=Shopping"
```

Use the CA to generate our certificate by signing our CSR. </br>
We may set an expiry on our certificate as well

```bash
openssl x509 -req -in bob.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out bob.crt -days 1
```

## Building a kube config

Let us combine some commends below:
We are going to set a new cluster entry in our new kubeconfig file. </br>
This is very important to avoid messing with our current kubeconfig. But beforefore we do that, we shall extract the server url from the current kubeconfig. </br>
We will replace that with the new server url in the next command. </br> And then we will set the cluster entry in our new kubeconfig file. </br>

```bash
# Let us make sure we get this KUBECONFIG variable out of the way
rm ~/.kube/new-config

# We extract the server url from the current kubeconfig
server_url=$(kubectl config view --minify --context=$(kubectl config current-context) -o=jsonpath='{.clusters[0].cluster.server}')

# We set the new kubeconfig
export KUBECONFIG=~/.kube/new-config

# We set the cluster entry
kubectl config set-cluster dev-cluster --server=$server_url \
--certificate-authority=ca.crt \
--embed-certs=true

cat ~/.kube/new-config
```

Now we need to create a user entry for Bob Smith.

```bash
kubectl config set-credentials bob --client-certificate=bob.crt --client-key=bob.key --embed-certs=true
kubectl config set-context dev --cluster=dev-cluster --namespace=shopping --user=bob

# If you query the nodes, you will see that we are not able to access the cluster because the context is not set
kubectl get nodes

# We set the context
kubectl config use-context dev

kubectl get pods
```

Error from server (Forbidden): pods is forbidden: User "Bob Smith" cannot list resource "pods" in API group "" in the namespace "shopping"

## Give Bob Smith Access

This time, we need to go back to our master node to create a role and rolebinding. </br>
So change the KUBECONFIG back to the default one

```bash
export KUBECONFIG=~/.kube/config
```

Now let us give our buddy Bob Smith access to the cluster. </br>

```bash
# Let us create the namespace for bob in the master node or admin node
kubectl create ns shopping

# Assign to him the role of pod/exec in the shopping namespace
kubectl -n shopping apply -f role/role.yaml
kubectl -n shopping apply -f role/rolebinding.yaml
```

## Test Access as Bob

Go back to Bob KUBECONFIG

```bash
export KUBECONFIG=~/.kube/new-config
```

```bash
kubectl get pods
#No resources found in shopping namespace.
```

# Kubernetes Service Accounts

So we've covered users, but what about applications or services running in our cluster ? </br>
Most business apps will not need to connect to the kubernetes API unless you are building something that integrates with your cluster, like a CI/CD tool, an autoscaler or a custom webhook. </br>

Generally applications will use a service account to connect. </br>
You can read more about [Kubernetes Service Accounts](https://kubernetes.io/docs/tasks/configure-pod-container/configure-service-account/).

Let's deploy a service account. But remember, we are still using Bob's kubeconfig, so we need to change it back to the default one

```bash
export KUBECONFIG=~/.kube/config
kubectl -n shopping apply -f service-account/serviceaccount.yaml
```

Now we can deploy a pod that uses the service account, let us change the KUBECONFIG back to Bob's

```bash
export KUBECONFIG=~/.kube/new-config
```

Now let us run the pod that uses the service account we just created.

```bash
kubectl -n shopping apply -f example-pod.yaml
```

Now we can test the access from within that pod by trying to list pods, remember we gave Bob to pod/exec in the shopping namespace:

```bash
kubectl -n shopping exec -it shopping-api -- bash

# Point to the internal API server hostname
APISERVER=https://kubernetes.default.svc

# Path to ServiceAccount token
SERVICEACCOUNT=/var/run/secrets/kubernetes.io/serviceaccount

# Read this Pod's namespace
NAMESPACE=$(cat ${SERVICEACCOUNT}/namespace)

# Read the ServiceAccount bearer token
TOKEN=$(cat ${SERVICEACCOUNT}/token)

# Reference the internal certificate authority (CA)
CACERT=${SERVICEACCOUNT}/ca.crt

# Now let us test access using our servicename inside the pod to List pods through the API
curl --cacert ${CACERT} --header "Authorization: Bearer $TOKEN" -s ${APISERVER}/api/v1/namespaces/shopping/pods/

# we should see the error below for not having access
-----
# root@shopping-api:/# curl --cacert ${CACERT} --header "Authorization: Bearer $TOKEN" -s ${APISERVER}/api/v1/namespaces/shopping/pods/
# {
#   "kind": "Status",
#   "apiVersion": "v1",
#   "metadata": {},
#   "status": "Failure",
#   "message": "pods is forbidden: User \"system:serviceaccount:shopping:shopping-api\" cannot list resource \"pods\" in API group \"\" in the namespace \"shopping\"",
#   "reason": "Forbidden",
#   "details": {
#     "kind": "pods"
#   },
#   "code": 403
# }root@shopping-api:/#
```

To allow this pod to list pods in the shopping namespace, we need to create a role and rolebinding for the service account from our master node

```bash
exit # exit the pod

# Let us change the KUBECONFIG back to the default one
export KUBECONFIG=~/.kube/config

# Now we can allow this pod to list pods in the shopping namespace
kubectl -n shopping apply -f service-account/serviceaccount-role.yaml
kubectl -n shopping apply -f service-account/serviceaccount-rolebinding.yaml
```

Now let us test access using our servicename inside the pod to List pods through the API.

We go back in bob's kubeconfig

```bash
export KUBECONFIG=~/.kube/new-config
```

And we access the pod using instructions at line 264.
If we try run `curl` command again we can see now we are able to get a json
response with pod information

Key Note:
ClusterRole and ClusterRoleBinding look the same as Role and RoleBinding, but they are cluster wide. </br>
So if you want to give access to a service account across all namespaces, you would use ClusterRole and ClusterRoleBinding. </br>

And be careful when giving a user ClusterRole and ClusterRoleBinding, because you can give access him the entire cluster. </br>
