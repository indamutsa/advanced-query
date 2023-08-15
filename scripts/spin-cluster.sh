cat <<EOF > 1-es-master.yml
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: es-master
spec:
  serviceName: es-master
  replicas: 1
  selector:
    matchLabels:
      app: es-master
  template:
    metadata:
      labels:
        app: es-master
    spec:
      containers:
      - name: es-master
        image: indamutsa/elasticsearch:v1.0.0

        env:
        - name: node.name
          value: "es-master"
        - name: node.master
          value: "true"
        - name: node.data
          value: "false"
        - name: cluster.initial_master_nodes
          value: "es-master,es-worker1,es-worker2"  # <-- Add all nodes here
        - name: ES_JAVA_OPTS
          value: "-Xmx256m -Xms256m"
        - name: ELASTICSEARCH_URL
          value: "http://es-master:9200"          
        - name: ELASTIC_USERNAME
          value: elastic
        - name: ELASTIC_PASSWORD
          value: changeme
        ports:
        - containerPort: 9200
        - containerPort: 9300
        volumeMounts:
        - name: es-master-data
          mountPath: /data/db
  volumeClaimTemplates:
  - metadata:
      name: es-master-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi
---
apiVersion: v1
kind: Service
metadata:
  name: es-master
spec:
  selector:
    app: es-master
  ports:
    - protocol: TCP
      port: 9200
      targetPort: 9200
      name: http-port
    - protocol: TCP
      port: 9300
      targetPort: 9300
      name: transport-port
  type: ClusterIP



EOF

echo "Created es-master deployment and service..."


cat <<EOF > 2-es-worker1.yml
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: es-worker1
spec:
  serviceName: es-worker1
  replicas: 1
  selector:
    matchLabels:
      app: es-worker1
  template:
    metadata:
      labels:
        app: es-worker1
    spec:
      containers:
      - name: es-worker1
        image: indamutsa/elasticsearch:v1.0.0

        env:
        - name: node.name
          value: "es-worker1"
        - name: node.master
          value: "true"    # <-- Change this to true
        - name: node.data
          value: "true"
        - name: discovery.seed_hosts
          value: "es-master,es-worker1,es-worker2"   # <-- Add all nodes here

        - name: ES_JAVA_OPTS
          value: "-Xmx256m -Xms256m"
        - name: ELASTICSEARCH_URL
          value: "http://es-worker1:9200"          
        - name: ELASTIC_USERNAME
          value: elastic
        - name: ELASTIC_PASSWORD
          value: changeme
        ports:
        - containerPort: 9200
        - containerPort: 9300  
        volumeMounts:
        - name: es-worker1-data
          mountPath: /data/db
  volumeClaimTemplates:
  - metadata:
      name: es-worker1-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi
---
apiVersion: v1
kind: Service
metadata:
  name: es-worker1
spec:
  selector:
    app: es-worker1
  ports:
    - protocol: TCP
      port: 9200
      targetPort: 9200
      name: http-port
    - protocol: TCP
      port: 9300
      targetPort: 9300
      name: transport-port
  type: ClusterIP


EOF

echo "Created es-worker1 deployment and service..."


cat <<EOF > 3-es-worker2.yml
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: es-worker2
spec:
  serviceName: es-worker2
  replicas: 1
  selector:
    matchLabels:
      app: es-worker2
  template:
    metadata:
      labels:
        app: es-worker2
    spec:
      containers:
      - name: es-worker2
        image: indamutsa/elasticsearch:v1.0.0

        env:
        - name: node.name
          value: "es-worker2"
        - name: node.master
          value: "true"    # <-- Change this to true
        - name: node.data
          value: "true"
        - name: discovery.seed_hosts
          value: "es-master,es-worker1,es-worker2"   # <-- Add all nodes here
        - name: node.ingest
          value: "true"
        - name: ES_JAVA_OPTS
          value: "-Xmx256m -Xms256m"
        - name: ELASTICSEARCH_URL
          value: "http://es-worker2:9200"          
        - name: ELASTIC_USERNAME
          value: elastic
        - name: ELASTIC_PASSWORD
          value: changeme
        ports:
        - containerPort: 9200
        - containerPort: 9300
        volumeMounts:
        - name: es-worker2-data
          mountPath: /data/db
  volumeClaimTemplates:
  - metadata:
      name: es-worker2-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi
---
apiVersion: v1
kind: Service
metadata:
  name: es-worker2
spec:
  selector:
    app: es-worker2
  ports:
    - protocol: TCP
      port: 9200
      targetPort: 9200
      name: http-port
    - protocol: TCP
      port: 9300
      targetPort: 9300
      name: transport-port
  type: ClusterIP

  
EOF

echo "Created es-worker2 deployment and service..."

cat <<EOF > 4-logstash.yml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: logstash
spec:
  replicas: 1
  selector:
    matchLabels:
      app: logstash
  template:
    metadata:
      labels:
        app: logstash
    spec:
      containers:
      - name: logstash
        image: indamutsa/logstash:v1.0.0
        env:
        - name: ELASTICSEARCH_URL
          value: "http://es-master:9200"  # Adjust if needed
        ports:
        - containerPort: 5044
        - containerPort: 5000
        - containerPort: 9600
      restartPolicy: Always
---
apiVersion: v1
kind: Service
metadata:
  name: logstash
spec:
  selector:
    app: logstash
  ports:
    - name: logstash-tcp-5044
      protocol: TCP
      port: 5044
      targetPort: 5044
    - name: logstash-tcp-5000
      protocol: TCP
      port: 5000
      targetPort: 5000
    - name: logstash-tcp-9600
      protocol: TCP
      port: 9600
      targetPort: 9600
  type: ClusterIP

EOF

echo "Created logstash.sh"


cat <<EOF > 5-kibana.yml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: kibana
spec:
  replicas: 1
  selector:
    matchLabels:
      app: kibana
  template:
    metadata:
      labels:
        app: kibana
    spec:
      containers:
      - name: kibana
        image: indamutsa/kibana:v1.0.0
        ports:
        - containerPort: 5601
        env:
        - name: ELASTICSEARCH_URL
          value: "http://es-master:9200"  # Adjust if needed

      restartPolicy: Always

---
apiVersion: v1
kind: Service
metadata:
  name: kibana
spec:
  selector:
    app: kibana
  ports:
    - protocol: TCP
      port: 5601
      targetPort: 5601
  type: ClusterIP


EOF

echo "Created kibana.sh"




cat <<EOF > 6-filebeat-daemonset.yml
apiVersion: apps/v1
kind: DaemonSet
metadata:
  name: filebeat
spec:
  selector:
    matchLabels:
      app: filebeat
  template:
    metadata:
      labels:
        app: filebeat
    spec:
      containers:
      - name: filebeat
        image: indamutsa/filebeat:v1.0.0
        volumeMounts:
        - mountPath: /var/log
          name: system-logs
          readOnly: true
      volumes:
      - name: system-logs
        hostPath:
          path: /var/log
      terminationGracePeriodSeconds: 30

EOF

echo "Created filebeat.sh"

