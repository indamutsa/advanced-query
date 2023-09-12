# Introduction to Istio

## We need a Kubernetes cluster

Lets create a Kubernetes cluster to play with using miniKube

```bash
minikube start --cpus=4 --memory=8192
minikube addons enable ingress
```

Enable some addons:

```bash
minikube addons enable ingress
minikube addons enable dashboard
minikube addons enable metrics-server
```

Start the dashboard:

```bash
minikube dashboard
```

# Getting Started with Istio

Firstly, I like to do most of my work in containers so everything is reproducable <br/>
and my machine remains clean.

## Start a container to work in:

```bash
docker run -it --rm --net host --name minikube-access-container \
-e KUBECONFIG=${HOME}/.kube/config \
-e MINIKUBE_HOME=${HOME}/.minikube \
-v /var/run/docker.sock:/var/run/docker.sock \
-v ${HOME}/.kube/:${HOME}/.kube/ \
-v ${HOME}/.minikube/:${HOME}/.minikube/ \
-v ${PWD}:/work \
-w /work alpine sh
```

Go ahead and install some utilities [here](../installation.md)

## Deploy our microservices (Video catalog)

```bash
kubectl apply -f applications/playlists-api/
kubectl apply -f applications/playlists-db/
kubectl apply -f applications/videos-api/
kubectl apply -f applications/videos-web/
kubectl apply -f applications/videos-db/

# Delete
kubectl delete -f applications/playlists-api/
kubectl delete -f applications/playlists-db/
kubectl delete -f applications/videos-api/
kubectl delete -f applications/videos-web/
kubectl delete -f applications/videos-db/
```

## Make sure our applications are running

```bash
kubectl get pods
NAME                            READY   STATUS    RESTARTS   AGE
playlists-api-d7f64c9c6-rfhdg   1/1     Running   0          2m19s
playlists-db-67d75dc7f4-p8wk5   1/1     Running   0          2m19s
videos-api-7769dfc56b-fsqsr     1/1     Running   0          2m18s
videos-db-74576d7c7d-5ljdh      1/1     Running   0          2m18s
videos-web-598c76f8f-chhgm      1/1     Running   0          100s
```

## Make sure our ingress controller is running

```bash
kubectl get deploy -n ingress-nginx
# NAME                                READY   UP-TO-DATE   AVAILABLE   AGE
# my-nginx-nginx-ingress-controller   1/1     1            1           37m

```

For minikube -- Test the Ingress Rule: To test, you can use curl by first getting the Minikube IP.

```bash
minikube ip
```

We'll need a fake DNS name `servicemesh.demo` <br/>
Let's fake one by adding the following entry in our hosts (`C:\Windows\System32\drivers\etc\hosts`) file: <br/>

```text
127.0.0.1  servicemesh.demo

```

## Access our application in the browser

We should be able to access our site under `http://servicemesh.demo/home/`

<br/>
<hr/>

## Install Istio CLI

```bash
curl -L https://istio.io/downloadIstio | ISTIO_VERSION=1.19.0 TARGET_ARCH=x86_64 sh -
mv istio-1.19.0/bin/istioctl /usr/local/bin/
chmod +x /usr/local/bin/istioctl
mv istio-1.19.0 /tmp/
```

## Pre flight checks

Istio has a great capability to check compatibility with the target cluster <br/>

```bash
istioctl x precheck
# ✔ No issues found when checking the cluster. Istio is safe to install or upgrade!
#   To get started, check out https://istio.io/latest/docs/setup/getting-started/
```

## Istio Profiles

https://istio.io/latest/docs/setup/additional-setup/config-profiles/

```bash
istioctl profile list

istioctl install --set profile=default

kubectl -n istio-system get pods

istioctl proxy-status

```

# Mesh our video catalog services

There are 2 ways to mesh:

1. Automated Injection:

You can set the `istio-injection=enabled` label on a namespace to have the istio side car automatically injected into any pod that gets created in the labelled namespace

This is a more permanent solution:
Pods will need to be recreated for injection to occur

```bash
kubectl label namespace/default istio-injection=enabled

# restart all pods to get sidecar injected
kubectl delete pods --all
```

2. Manual Injection:
   This may only be temporary as your CI/CD system may roll out the previous YAML.
   You may want to add this command to your CI/CD to keep only certain deployments part of the mesh.

```bash
kubectl get deploy
NAME            READY   UP-TO-DATE   AVAILABLE   AGE
playlists-api   1/1     1            1           8h
playlists-db    1/1     1            1           8h
videos-api      1/1     1            1           8h
videos-db       1/1     1            1           8h
videos-web      1/1     1            1           8h
```

Lets manually inject istio sidecar into our Ingress Controller:

```bash
kubectl -n ingress-nginx get deploy ingress-nginx-controller -o yaml | istioctl kube-inject -f - | kubectl apply -f -

# Get ingress nginx pods
kubectl -n ingress-nginx get pods


# You can manually inject istio sidecar to every deployment like this:
kubectl get deploy playlists-api -o yaml | istioctl kube-inject -f - | kubectl apply -f -
kubectl get deploy playlists-db -o yaml | istioctl kube-inject -f - | kubectl apply -f -
kubectl get deploy videos-api -o yaml | istioctl kube-inject -f - | kubectl apply -f -
kubectl get deploy videos-db -o yaml | istioctl kube-inject -f - | kubectl apply -f -
kubectl get deploy videos-web -o yaml | istioctl kube-inject -f - | kubectl apply -f -
```

# TCP \ HTTP traffic

Let's run a `curl` loop to generate some traffic to our site </br>
We'll make a call to `/home/` and to simulate the browser making a call to get the playlists, <br/>
we'll make a follow up call to `/api/playlists`

```bash
cat <<EOF | bash
while true; do
  curl http://servicemesh.demo/home/
  curl http://servicemesh.demo/api/playlists
  sleep 1
done
EOF
```

Run it in background

```bash
cat <<EOF | bash &
while true; do
  curl http://servicemesh.demo/home/
  curl http://servicemesh.demo/api/playlists
  sleep 1
done
EOF
```

# Observability

If you check the tmp folder, you'll see a `istio-1.19.0` folder <br/>
You can see that istio comes up with a lot of components to help with observability <br/>
Inside samples/addons tools like `kiali`, `grafana`, `prometheus` etc.

## Grafana

```bash
kubectl apply -n istio-system -f /tmp/istio-1.19.0/samples/addons/grafana.yaml
```

We can see the components in the `istio-system` namespace:

```bash
kubectl -n istio-system get pods
```

Access grafana dashboards :

```bash
kubectl -n istio-system port-forward svc/grafana 3000
```

Inside Dashboard, Click on IstioMesh dashboard. Wait a little bit and we should see some traffic.

## Kiali

`NOTE: this may fail because CRDs need to generate, if so, just rerun the command:`

```bash
kubectl apply -f /tmp/istio-1.19.0/samples/addons/kiali.yaml

kubectl -n istio-system get pods
kubectl -n istio-system port-forward svc/kiali 20001
```

Here is the kiali graph:

<!-- Insert image -->

# Virtual Services

## Auto Retry

Let's add a fault in the `videos-api` by setting `env` variable `FLAKY=true`

```bash
kubectl edit deploy videos-api

# To confirm the error:
kubectl logs videos-api-7df7bb788-2lr8x -c videos-api --tail=50
```

```bash
# Let us create a virtual service to retry the request 10 times
kubectl apply -f istio/retries/videos-api.yaml
```

Once a fix is in place, we can remove the virtual service:

```bash
# Let us turn flaky off to emulate a fix
kubectl edit deploy videos-api

# Let us remove the virtual service
kubectl delete -f istio/retries/videos-api.yaml
```

We can describe pods using `istioctl`

```bash
# istioctl x describe pod <videos-api-POD-NAME>

istioctl x describe pod videos-api-584768f497-jjrqd
Pod: videos-api-584768f497-jjrqd
   Pod Ports: 10010 (videos-api), 15090 (istio-proxy)
Suggestion: add 'version' label to pod for Istio telemetry.
--------------------
Service: videos-api
   Port: http 10010/HTTP targets pod port 10010
VirtualService: videos-api
   1 HTTP route(s)
```

Analyse our namespace:

```bash
istioctl analyze --namespace default
```

## Traffic Splits

Let's deploy V2 of our application which has a header that's under development

```bash
# Apply the videos-web-v2 deployment
kubectl apply -f istio/traffic-splits/videos-web-v2.yaml

# we can see v2 pods
kubectl get pods
```

Let's send 50% of traffic to V1 and 50% to V2 by using a `VirtualService`

```bash
# We can use a VirtualService to split traffic
kubectl apply -f istio/traffic-splits/split-videos-web.yaml


# Start by deleting the traffic split
kubectl delete -f istio/traffic-splits/split-videos-web.yaml
kubectl delete -f istio/traffic-splits/videos-web-v2.yaml
```

## Canary Deployments

Traffic splits has its uses, but sometimes we may want to route traffic to other <br/>
parts of the system using feature toggles, for example, setting a `cookie`<br/>
<br/>
Let's send all users that have the cookie value `version=v2` to V2 of our `videos-web`.

```bash
# Apply the videos-web-v2 deployment
kubectl apply -f istio/traffic-splits/videos-web-v2.yaml

# Apply the canary deployment
kubectl apply -f istio/canary/canary-videos-web.yaml

# Delete the canary deployment
kubectl delete -f istio/canary/canary-videos-web.yaml
```

We can confirm this works, by setting the cookie value `version=v2` followed by accessing https://servicemesh.demo/home/ on a browser page <br/>

<br />

Using the istio mesh, we can set up the istio [gateway](/home/arsene/Project/cloud-projects/devops-stop-center/tech-tutorial-1/kubernetes/multi-node-kind-cluster/4-servicemesh/gateway/readme.md), More traffic management options can be found [here](/home/arsene/Project/cloud-projects/devops-stop-center/tech-tutorial-1/kubernetes/multi-node-kind-cluster/4-servicemesh/traffic-management/readme.md). In that folder, we can exploit the Istio Service Mesh services to manage traffic in our cluster.
