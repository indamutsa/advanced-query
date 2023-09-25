## RUN THE CLUSTER USING ARGOCD - GITOPS

Let us change the directory to argocd folder:

```bash
cd argocd
```

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
mkdir -p terraform-deploy/values
cd terraform-deploy/values
helm show values argo/argo-cd --version 3.35.4 > argocd-values.yaml
cd ..
```

Let us use terraform to install argocd.
Change the folder to argocd and initialize terraform-deploy to run argocd

```bash
# cd terraform-deploy
terraform init
terraform plan
```

Apply it to run argocd

```bash
terraform apply --auto-approve
```

Verify that argocd is running

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

Combine the two to get the password

```bash
# Get the password
PASSWORD=$(kubectl get secrets argocd-initial-admin-secret -n argocd -o jsonpath='{.data.password}' | base64 -d)
echo $PASSWORD
```

Port forward the argocd server

```bash
kubectl port-forward svc/argocd-server -n argocd 8080:443
```

and follow the instructions.

After that we can add application yaml to instruct argocd to track our repo

We will add some configuration and build agent to automate the build process.

<!-- prettier-ignore-start -->
```md
❯ tree -L 2

.
├── argocd
│   ├── application.yaml
│   └── terraform-deploy
├── cluster-deployment.sh
├── cluster-helm-deployment
│   ├── charts
│   ├── Chart.yaml
│   ├── hello
│   ├── templates
│   └── values.yaml
├── cluster-manifest-gen.sh
├── docker-compose.yml
├── elastic-bundle
│   ├── elasticsearch
│   ├── extensions
│   ├── filebeat
│   ├── kibana
│   └── logstash
├── elk.md
├── figures
│   └── querydia.jpg
├── files
│   ├── import.sh
│   ├── new
│   └── new-folder
├── frontend-search
│   ├── adhoc
│   ├── components
│   ├── context
│   ├── data
│   ├── Dockerfile
│   ├── next.config.js
│   ├── node_modules
│   ├── package.json
│   ├── pages
│   ├── public
│   ├── README.md
│   ├── services
│   ├── styles
│   ├── test
│   ├── yarn-error.log
│   └── yarn.lock
├── kind-config.yml
├── manifest-legacy
│   ├── main-depl
│   ├── merger.sh
│   ├── mongocfg
│   ├── mongors1
│   ├── mongors2
│   └── mongos
├── mongo-bundle
│   └── monstache
├── persistence-api
│   ├── ad-hoc
│   ├── config
│   ├── Dockerfile
│   ├── index.js
│   ├── localStorage
│   ├── logs
│   ├── lowcomote-storage.json
│   ├── middleware
│   ├── MIT License.txt
│   ├── models
│   ├── node_modules
│   ├── note.txt
│   ├── package.json
│   ├── public
│   ├── route
│   ├── services
│   ├── startup
│   ├── test.http
│   └── yarn.lock
├── push.sh
├── query-engine
│   ├── config
│   ├── controller
│   ├── data
│   ├── Dockerfile
│   ├── graphql
│   ├── microsyntax
│   ├── node_modules
│   ├── package.json
│   ├── package-lock.json
│   ├── README.md
│   ├── router
│   ├── server.js
│   ├── service
│   ├── test.json
│   ├── utils
│   └── yarn.lock
├── README.md
├── run.sh
├── scripts
│   ├── cluster-deployment.sh
│   ├── cluster-manifest-gen.sh
│   ├── import.sh
│   ├── merger.sh
│   ├── mongo-cluster-spin.sh
│   ├── push.sh
│   ├── runit.sh
│   ├── run.sh
│   ├── setup.sh
│   ├── spin-cluster-.sh
│   ├── spin-cluster.sh
│   ├── spin-elk-mongo.sh
│   ├── spinner.sh
│   ├── spin-templates.sh
│   ├── start-dc.sh
│   └── update-image.sh
├── setup
│   ├── addShards.js
│   ├── Dockerfile
│   ├── initConfig.js
│   ├── initShard1.js
│   ├── initShard2.js
│   ├── runit.sh
│   └── setup.sh
├── start-dc.sh
├── test
│   ├── auto-copy
│   ├── docker-compose.yml
│   ├── setup
│   ├── update-image.sh
│   └── update-img
└── yarn.lock

63 directories, 62 files
```
<!-- prettier-ignore-end -->

The folder `argocd` contains the application.yaml file that instructs argocd to track our repo and deploy the application.
First apply the application.yaml file to argocd

```bash
# cd argocd
cd ..
pwd # should be argocd
kubectl apply -f mdeforge-project.yaml
sleep 10
kubectl apply -f application.yaml
```

We shall see that the application is deployed in the argo namespace inside the dashboard of argocd `http://localhost:8080`.

All the resoureces including argocd deployment can be deleted by running

```bash
❯ kubectl delete all,secrets,configmaps,pv,pvc --all --all-namespaces
kind delete cluster --name mdeforge
```

For more information about `argocd cli`, please refer to the essentials of helm [here](5-1-argocd-guide.md)

---