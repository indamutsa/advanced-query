# Logging Aggregation Stack

`The repositoru already contains the elk stack with filebeat. You can skip the installation part and go directly to the testing part.`

Start by installing the cluster:

```bash
kind create cluster --config config.yaml --name dev
```

Let us add elastic search, fluentd and kibana to our cluster.

```bash
helm repo add elastic https://helm.elastic.co
helm repo update
```

We might need to override the default values of the chart. We can do that by creating a file `es-values.yaml` and passing it to the helm command.

Install elastic search

```bash
helm install elasticsearch elastic/elasticsearch  --create-namespace -n logging -f es-values.yaml
```

Wait for the pods to be ready

```bash
kubectl get pods -n logging -l app=elasticsearch-master -w
```

The next component is kiban. We will use the helm chart:

```bash
helm install kibana elastic/kibana -n logging -f kibana-values.yaml
```

Go ahead and wait for the pods to be ready

```bash
kubectl get pods -n logging -l app=kibana -w
```

Let us port forward the kibana service to our local machine

```bash
kubectl port-forward -n logging svc/kibana-kibana 5601:5601
```

Let us install filebeat as our log shipper agent

```bash
helm install filebeat elastic/filebeat -n logging
```

We can test the setup by running the following command:

```bash
kubectl apply -f simple-app.yaml
```

Port forward the kibana service to our local machine

```bash
kubectl port-forward -n logging svc/kibana-kibana 5601:5601
```

Open kibana, create an index pattern `filebeat*`. Inside the kibana dashboard, you can create a new index pattern and name it `filebeat*` and select `@timestamp` as the time filter field name.

Filter the logs by `incoming` and you should see some logs with Traffic coming in.

## Cleanup

```bash
kind delete cluster --name dev
```
