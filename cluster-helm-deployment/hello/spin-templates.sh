#!/bin/bash


cat << 'EOF' > moongodb-configservers.yaml
# prettier-ignore

{{- range $cfg := .Values.mongodb.configServers }}
# Config server replica set
apiVersion: v1
kind: Service
metadata:
  name: {{ $cfg.name }}
  labels:
    app: {{ $cfg.name }}
spec:
  ports:
  - port: {{ $cfg.port }}
    targetPort: {{ $cfg.port }}
  selector:
    app: {{ $cfg.name }}
---
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: {{ $cfg.name }}
spec:
  serviceName: {{ $cfg.name }}
  replicas: {{ $cfg.replicas }}
  selector:
    matchLabels:
      app: {{ $cfg.name }}
  template:
    metadata:
      labels:
        app: {{ $cfg.name }}
    spec:
      containers:
      - name: {{ $cfg.name }}
        image: {{ $cfg.image }}
        command:
        {{- range $command := $cfg.command }}
        - {{ $command | quote}}
        {{- end }}
        ports:
        - containerPort: {{ $cfg.port }}
        env:
        - name: TERM
          value: {{ $cfg.env.TERM }}
        volumeMounts:
        - name: {{ $cfg.volumeName }}
          mountPath: {{ $cfg.mountPath }}
        # resources:
        #   requests:
        #     cpu: {{ $cfg.resources.requests.cpu | quote}}
        #     memory: {{ $cfg.resources.requests.memory }}
        #   limits:
        #     cpu: {{ $cfg.resources.limits.cpu | quote }}
        #     memory: {{ $cfg.resources.limits.memory }} 

  volumeClaimTemplates:
  - metadata:
      name: {{ $cfg.volumeName }}
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: {{ $cfg.storageSize }}
---
{{- end }}

EOF

echo "Kubernetes manifest written to mongodb-configservers.yaml"


cat << 'EOF' > es-cluster.yaml
# prettier-ignore

{{- range $node, $data := .Values.elasticsearch }}
# StatefulSet
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: {{ $data.name }}
spec:
  serviceName: {{ $data.name }}
  replicas: {{ $data.replicas }}
  selector:
    matchLabels:
      app: {{ $data.name }}
  template:
    metadata:
      labels:
        app: {{ $data.name }}
    spec:
      containers:
        - name: {{ $data.name }}
          image: {{ $data.image }}
          env:
            - name: node.name
              value: {{ $data.name }}
            - name: node.master
              value: {{ $data.env.master | quote }}
            - name: node.data
              value: {{ $data.env.data  | quote }}
            {{- if eq $node "es-master" }}
            - name: cluster.initial_master_nodes
              value: {{ $data.env.nodes  | quote }}
            {{- else }}
            - name: discovery.seed_hosts
              value: {{ $data.env.seed_hosts  | quote }}
            {{- end }}
            {{- if $data.env.ingest }}
            - name: node.ingest
              value: {{ $data.env.ingest | quote  }}
            {{- end }}
            - name: ES_JAVA_OPTS
              value: {{ $data.env.java_opts  | quote }}
            - name: ELASTICSEARCH_URL
              value: {{ $data.env.es_url  | quote }}
            - name: ELASTIC_USERNAME
              value: {{ $data.env.es_username  | quote }}
            - name: ELASTIC_PASSWORD
              value: {{ $data.env.es_password  | quote }}
          ports:
            - containerPort: {{ $data.env.port_1 }}
            - containerPort: {{ $data.env.port_2 }}
          volumeMounts:
            - name: {{ $data.name }}-data
              mountPath: /data/db
          # resources:
          #   requests:
          #     cpu: {{ $data.resources.requests.cpu | quote }}
          #     memory: {{ $data.resources.requests.memory }}
          #   limits:
          #     cpu: {{ $data.resources.limits.cpu | quote }}
          #     memory: {{ $data.resources.limits.memory }}
  volumeClaimTemplates:
    - metadata:
        name: {{ $data.name }}-data
      spec:
        accessModes: ["ReadWriteOnce"]
        resources:
          requests:
            storage: {{ $data.size }}
---
# Service
# prettier-ignore
apiVersion: v1
kind: Service
metadata:
  name: {{ $data.name }}
spec:
  selector:
    app: {{ $data.name }}
  ports:
    - protocol: TCP
      port: {{ $data.env.port_1 }}
      targetPort: {{ $data.env.port_1 }}
      name: http-port
    - protocol: TCP
      port: {{ $data.env.port_2 }}
      targetPort: {{ $data.env.port_2 }}
      name: transport-port
  type: ClusterIP
---
{{- end }}


EOF

echo "Kubernetes manifest written to es-cluster.yaml"


cat << 'EOF' > mongodb-router.yaml
# prettier-ignore

{{- range .Values.mongos.routers }}
# Deployment for {{ .name }}
apiVersion: apps/v1
kind: Deployment
metadata:
  name: {{ .name }}
spec:
  replicas: {{ $.Values.mongos.replicas }}
  selector:
    matchLabels:
      app: {{ .name }}
  template:
    metadata:
      labels:
        app: {{ .name }}
    spec:
      containers:
      - name: {{ .name }}
        image: {{ $.Values.mongos.image }}
        command: 
        - mongos
        - --configdb
        - mongors1conf/mongocfg1:27017,mongocfg2:27017,mongocfg3:27017
        - --port
        - "27017" 
        - --bind_ip_all
        ports:
        - containerPort: 27017
        volumeMounts:
        - name: config
          mountPath: /home/app
        # resources:
        #   requests:
        #     memory: {{ $.Values.mongos.resources.requests.memory }}
        #     cpu: {{ $.Values.mongos.resources.requests.cpu | quote }}
        #   limits:
        #     memory: {{ $.Values.mongos.resources.limits.memory }}
        #     cpu: {{ $.Values.mongos.resources.limits.cpu | quote }}
      volumes:
      - name: config
        configMap:
          name: {{ .name }}-config
---
# Service for {{ .name }}
apiVersion: v1
kind: Service
metadata:
  name: {{ .name }}
spec:
  type: LoadBalancer
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: {{ .name }}
---
# ConfigMap for {{ .name }}
apiVersion: v1
kind: ConfigMap
metadata:
  name: {{ .name }}-config
data:
  addShards.js: |
    {{ $.Values.mongos.configData | nindent 4 }}
---
{{- end }}

EOF

echo "Kubernetes manifest written to mongodb-router.yaml"


cat << 'EOF' > mongodb-shards.yaml
# prettier-ignore
{{- range $shard := .Values.mongodb.shards }}
{{- range $node := $shard.nodes }}

# Service for {{ $node }}
apiVersion: v1
kind: Service
metadata:
  name: {{ $node }}
  labels:
    app: {{ $node }}
spec:
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: {{ $node }}
---

# StatefulSet for {{ $node }}
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: {{ $node }}
spec:
  serviceName: {{ $node | quote }}
  replicas: {{ $.Values.mongodb.replicas }}
  selector:
    matchLabels:
      app: {{ $node }}
  template:
    metadata:
      labels:
        app: {{ $node }}
    spec:
      containers:
      - name: {{ $node }}
        image: {{ $.Values.mongodb.image }}
        command:
        - mongod
        - --shardsvr
        - --replSet
        - {{ $shard.name }}
        - --dbpath
        - /data/db
        - --port
        - "27017"
        - --bind_ip_all
        ports:
        - containerPort: 27017
        env:
        - name: TERM
          value: xterm
        volumeMounts:
        - name: mongodb-data
          mountPath: /data/db
        # resources:
        #   requests:
        #     memory: {{ $shard.resources.requests.memory }}
        #     cpu: {{ $shard.resources.requests.cpu | quote }}
        #   limits:
        #     memory: {{ $shard.resources.limits.memory }}
        #     cpu: {{ $shard.resources.limits.cpu | quote }}
  volumeClaimTemplates:
  - metadata:
      name: mongodb-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: {{ $.Values.mongodb.storageSize | quote }}
---
{{- end }}
{{- end }}

EOF

echo "Kubernetes manifest written to mongodb-shards.yaml"


cat << 'EOF' > filebeat.yaml
# prettier-ignore
apiVersion: apps/v1
kind: DaemonSet
metadata:
  name: {{ .Values.filebeat.name }}
spec:
  selector:
    matchLabels:
      app: {{ .Values.filebeat.label }}
  template:
    metadata:
      labels:
        app: {{ .Values.filebeat.label }}
    spec:
      containers:
      - name: {{ .Values.filebeat.name }}
        image: {{ .Values.filebeat.image }}
        volumeMounts:
        - mountPath: /var/log
          name: system-logs
          readOnly: true
        # resources:
        #   requests:
        #     memory: {{ .Values.filebeat.resources.requests.memory }}
        #     cpu: {{ .Values.filebeat.resources.requests.cpu }}
        #   limits:
        #     memory: {{ .Values.filebeat.resources.limits.memory }}
        #     cpu: {{ .Values.filebeat.resources.limits.cpu }}  
      volumes:
      - name: system-logs
        hostPath:
          path: /var/log
  
      terminationGracePeriodSeconds: 30

EOF

echo "Kubernetes manifest written to filebeat.yaml"


cat << 'EOF' > frontend-search.yaml
# prettier-ignore
apiVersion: apps/v1
kind: Deployment
metadata:
  name: {{ .Values.frontendSearch.name }}
spec:
  replicas: {{ .Values.frontendSearch.replicas }}
  selector:
    matchLabels:
      app: {{ .Values.frontendSearch.label }}
  template:
    metadata:
      labels:
        app: {{ .Values.frontendSearch.label }}
    spec:
      containers:
      - name: {{ .Values.frontendSearch.containerName }}
        image: {{ .Values.frontendSearch.image }}
        ports:
        - containerPort: {{ .Values.frontendSearch.containerPort }}
        # resources:
        #   requests:
        #     memory: {{ .Values.frontendSearch.resources.requests.memory }}
        #     cpu: {{ .Values.frontendSearch.resources.requests.cpu | quote}}
        #   limits:
        #     memory: {{ .Values.frontendSearch.resources.limits.memory }}
        #     cpu: {{ .Values.frontendSearch.resources.limits.cpu | quote }}
---
# prettier-ignore
apiVersion: v1
kind: Service
metadata:
  name: {{ .Values.frontendSearch.name }}
spec:
  selector:
    app: {{ .Values.frontendSearch.label }}
  ports:
    - protocol: TCP
      port: {{ .Values.frontendSearch.servicePort }}
      targetPort: {{ .Values.frontendSearch.containerPort }}
  type: {{ .Values.frontendSearch.serviceType }}

EOF

echo "Kubernetes manifest written to frontend-search.yaml"

cat << 'EOF' > kibana.yaml
# prettier-ignore

apiVersion: apps/v1
kind: Deployment
metadata:
  name: {{ .Values.kibana.name }}
spec:
  replicas: {{ .Values.kibana.replicas }}
  selector:
    matchLabels:
      app: {{ .Values.kibana.name }}
  template:
    metadata:
      labels:
        app: {{ .Values.kibana.name }}
    spec:
      containers:
      - name: {{ .Values.kibana.name }}
        image: {{ .Values.kibana.image }}
        ports:
        - containerPort: {{ .Values.kibana.port }}
        env:
        - name: ELASTICSEARCH_URL
          value: {{ .Values.kibana.elasticsearchUrl }}
        # resources:
        #   requests:
        #     cpu: {{ .Values.kibana.resources.requests.cpu | quote}}
        #     memory: {{ .Values.kibana.resources.requests.memory }}
        #   limits:
        #     cpu: {{ .Values.kibana.resources.limits.cpu | quote }}
        #     memory: {{ .Values.kibana.resources.limits.memory }}
      restartPolicy: Always

---
# prettier-ignore
apiVersion: v1
kind: Service
metadata:
  name: {{ .Values.kibana.name }}
spec:
  selector:
    app: {{ .Values.kibana.name }}
  ports:
    - protocol: TCP
      port: {{ .Values.kibana.port }}
      targetPort: {{ .Values.kibana.port }}
  type: ClusterIP

EOF

echo "Kubernetes manifest written to kibana.yaml"

cat << 'EOF' > monstache.yaml
# prettier-ignore
apiVersion: apps/v1
kind: Deployment
metadata:
  name: {{ .Values.monstache.name }}
spec:
  replicas: {{ .Values.monstache.replicas }}
  selector:
    matchLabels:
      app: {{ .Values.monstache.label }}
  template:
    metadata:
      labels:
        app: {{ .Values.monstache.label }}
    spec:
      containers:
      - name: {{ .Values.monstache.containerName }}
        image: {{ .Values.monstache.image }}
        args:
        {{- range .Values.monstache.args }}
        - "{{ . }}"
        {{- end }}

        ports:
        - containerPort: {{ .Values.monstache.containerPort }}
        livenessProbe:
          httpGet:
            path: {{ .Values.monstache.livenessProbe.path }}
            port: {{ .Values.monstache.livenessProbe.port }}
          initialDelaySeconds: {{ .Values.monstache.livenessProbe.initialDelaySeconds }}
          periodSeconds: {{ .Values.monstache.livenessProbe.periodSeconds }}
          timeoutSeconds: {{ .Values.monstache.livenessProbe.timeoutSeconds }}
          failureThreshold: {{ .Values.monstache.livenessProbe.failureThreshold }}
        # resources:
        #   requests:
        #     memory: {{ .Values.monstache.resources.requests.memory }}
        #     cpu: {{ .Values.monstache.resources.requests.cpu | quote}}
        #   limits:
        #     memory: {{ .Values.monstache.resources.limits.memory }}
        #     cpu: {{ .Values.monstache.resources.limits.cpu | quote }}
      restartPolicy: {{ .Values.monstache.restartPolicy }}

---
# prettier-ignore
apiVersion: v1
kind: Service
metadata:
  name: {{ .Values.monstache.name }}
spec:
  selector:
    app: {{ .Values.monstache.label }}
  ports:
    - protocol: TCP
      port: {{ .Values.monstache.servicePort }}
      targetPort: {{ .Values.monstache.containerPort }}
  type: {{ .Values.monstache.serviceType }}

EOF

echo "Kubernetes manifest written to monstache.yaml"


cat << 'EOF' > persistence-api.yaml
# prettier-ignore
apiVersion: apps/v1
kind: Deployment
metadata:
  name: {{ .Values.persistenceApi.name }}
spec:
  replicas: {{ .Values.persistenceApi.replicas }}
  selector:
    matchLabels:
      app: {{ .Values.persistenceApi.label }}
  template:
    metadata:
      labels:
        app: {{ .Values.persistenceApi.label }}
    spec:
      containers:
      - name: {{ .Values.persistenceApi.name }}
        image: {{ .Values.persistenceApi.image }}
        ports:
        - containerPort: {{ .Values.persistenceApi.port }}
        # resources:
        #   requests:
        #     memory: {{ .Values.persistenceApi.resources.requests.memory }}
        #     cpu: {{ .Values.persistenceApi.resources.requests.cpu | quote}}
        #   limits:
        #     memory: {{ .Values.persistenceApi.resources.limits.memory }}
        #     cpu: {{ .Values.persistenceApi.resources.limits.cpu | quote }}
---
# prettier-ignore
apiVersion: v1
kind: Service
metadata:
  name: {{ .Values.persistenceApi.name }}
spec:
  selector:
    app: {{ .Values.persistenceApi.label }}
  ports:
    - protocol: TCP
      port: {{ .Values.persistenceApi.port }}
      targetPort: {{ .Values.persistenceApi.port }}
  type: ClusterIP
---
EOF

echo "Kubernetes manifest written to persistence-api.yaml"

cat << 'EOF' > query-engine.yaml
# prettier-ignore
apiVersion: apps/v1
kind: Deployment
metadata:
  name: {{ .Values.queryEngine.name }}
spec:
  replicas: {{ .Values.queryEngine.replicas }}
  selector:
    matchLabels:
      app: {{ .Values.queryEngine.label }}
  template:
    metadata:
      labels:
        app: {{ .Values.queryEngine.label }}
    spec:
      initContainers:
      - name: wait-for-es
        image: busybox
        command: 
        - "/bin/sh"
        - "-c"
        - |
          sleep 120; echo "Waiting for es-master:9200 to become available... | 120 sleep" 
          until nc -z es-master 9200; do
            echo "Waiting for es-master:9200 to become available..."
            sleep 5
          done
      containers:
      - name: {{ .Values.queryEngine.containerName }}
        image: {{ .Values.queryEngine.image }}
        ports:
        - containerPort: {{ .Values.queryEngine.containerPort }}
        # resources:
        #   requests:
        #     memory: {{ .Values.queryEngine.resources.requests.memory }}
        #     cpu: {{ .Values.queryEngine.resources.requests.cpu | quote}}
        #   limits:
        #     memory: {{ .Values.queryEngine.resources.limits.memory }}
        #     cpu: {{ .Values.queryEngine.resources.limits.cpu | quote }}

---
# prettier-ignore
apiVersion: v1
kind: Service
metadata:
  name: {{ .Values.queryEngine.name }}
spec:
  selector:
    app: {{ .Values.queryEngine.label }}
  ports:
    - protocol: TCP
      port: {{ .Values.queryEngine.servicePort }}
      targetPort: {{ .Values.queryEngine.containerPort }}
  type: {{ .Values.queryEngine.serviceType }}


EOF

echo "Kubernetes manifest written to query-engine.yaml"


cat << 'EOF' > setup-mongo-cluster.yaml
# prettier-ignore

apiVersion: batch/v1
kind: Job
metadata:
  name: {{ .Values.setupRs.name }}
spec:
  template:
    metadata:
      labels:
        job-name: {{ .Values.setupRs.label }}
    spec:
      containers:
      - name: {{ .Values.setupRs.name }}
        image: {{ .Values.setupRs.image }}
        # resources:
          # requests:
          #   memory: {{ .Values.setupRs.resources.requests.memory }}
          #   cpu: {{ .Values.setupRs.resources.requests.cpu | quote}}
          # limits:
          #   memory: {{ .Values.setupRs.resources.limits.memory }}
          #   cpu: {{ .Values.setupRs.resources.limits.cpu | quote }}
      restartPolicy: {{ .Values.setupRs.restartPolicy }}
EOF

echo "Kubernetes manifest written to setup-mongo-cluster.yaml"


cat << 'EOF' > values.yaml
# Default values for cluster-helm-deployment.
# Declare variables to be passed into your templates.

elasticsearch:
  es-master:
    replicas: 1
    image: indamutsa/elasticsearch:v1.0.0
    name: "es-master"
    env:
      master: "true"
      data: "false"
      nodes: "es-master,es-worker1,es-worker2"
      java_opts: "-Xmx256m -Xms256m"
      es_url: "http://es-master:9200"
      es_username: "elastic"
      es_password: "changeme"
      port_1: 9200
      port_2: 9300
    size: 1Gi
    resources:
      requests:
        memory: "256Mi"
        cpu: "250m"
      limits:
        memory: "512Mi"
        cpu: "500m" 
          
  es-worker1:
    replicas: 1
    image: indamutsa/elasticsearch:v1.0.0
    name: "es-worker1"
    env:
      master: "true"
      data: "true"
      seed_hosts: "es-master,es-worker1,es-worker2"
      java_opts: "-Xmx256m -Xms256m"
      es_url: "http://es-worker1:9200"
      es_username: "elastic"
      es_password: "changeme"
      port_1: 9200
      port_2: 9300
    size: 1Gi
    resources:
      requests:
        memory: "256Mi"
        cpu: "250m"
      limits:
        memory: "512Mi"
        cpu: "500m"    

  es-worker2:
    replicas: 1
    image: indamutsa/elasticsearch:v1.0.0
    name: "es-worker2"
    env:
      master: "true"
      data: "true"
      seed_hosts: "es-master,es-worker1,es-worker2"
      ingest: "true"
      java_opts: "-Xmx256m -Xms256m"
      es_url: "http://es-worker2:9200"
      es_username: "elastic"
      es_password: "changeme"
      port_1: 9200
      port_2: 9300
    size: 1Gi
    resources:
      requests:
        memory: "256Mi"
        cpu: "250m"
      limits:
        memory: "512Mi"
        cpu: "500m" 

mongodb:
  image: indamutsa/mongo:v1.0.0
  replicas: 1
  storageSize: 1Gi

  shards:
    - name: mongors1
      nodes:
        - mongors1n1
        - mongors1n2
        - mongors1n3
      resources:
        requests:
          memory: "256Mi"
          cpu: "250m"
        limits:
          memory: "512Mi"
          cpu: "500m"
      
    - name: mongors2
      nodes:
        - mongors2n1
        - mongors2n2
        - mongors2n3
      resources:
        requests:
          memory: "256Mi"
          cpu: "250m"
        limits:
          memory: "512Mi"
          cpu: "500m"

  configServers:
    - name: "mongocfg1"
      replicas: 1
      image: "indamutsa/mongo:v1.0.0"
      port: 27017
      command:
        - "mongod"
        - "--configsvr"
        - "--replSet"
        - "mongors1conf"
        - "--dbpath"
        - "/data/db"
        - "--port"
        - "27017"
        - "--bind_ip_all"
      env:
        TERM: "xterm"
      volumeName: "mongodb-config-data"
      mountPath: "/data/db"
      storageSize: "1Gi"
      resources:
        requests:
          memory: "256Mi"
          cpu: "250m"
        limits:
          memory: "512Mi"
          cpu: "500m"

    - name: "mongocfg2"
      replicas: 1
      image: "indamutsa/mongo:v1.0.0"
      port: 27017
      command:
        - "mongod"
        - "--configsvr"
        - "--replSet"
        - "mongors1conf"
        - "--dbpath"
        - "/data/db"
        - "--port"
        - "27017"
        - "--bind_ip_all"
      env:
        TERM: "xterm"
      volumeName: "mongodb-config-data"
      mountPath: "/data/db"
      storageSize: "1Gi"
      resources:
        requests:
          memory: "256Mi"
          cpu: "250m"
        limits:
          memory: "512Mi"
          cpu: "500m"

    - name: "mongocfg3"
      replicas: 1
      image: "indamutsa/mongo:v1.0.0"
      port: 27017
      command:
        - "mongod"
        - "--configsvr"
        - "--replSet"
        - "mongors1conf"
        - "--dbpath"
        - "/data/db"
        - "--port"
        - "27017"
        - "--bind_ip_all"
      env:
        TERM: "xterm"
      volumeName: "mongodb-config-data"
      mountPath: "/data/db"
      storageSize: "1Gi"
      resources:
        requests:
          memory: "256Mi"
          cpu: "250m"
        limits:
          memory: "512Mi"
          cpu: "500m"
mongos:
  image: indamutsa/mongo:v1.0.0
  replicas: 1
  resources:
    requests:
      memory: "64Mi"
      cpu: "250m"
    limits:
      memory: "128Mi"
      cpu: "500m"
  routers:
    - name: mongos1
    - name: mongos2
  configData: |
    sh.addShard("mongors1/mongors1n1:27017,mongors1n2:27017,mongors1n3:27017");
    sh.addShard("mongors2/mongors2n1:27017,mongors2n2:27017,mongors2n3:27017");
    sh.enableSharding("testDb");
    db.createCollection("kittens");
    db.kittens.createIndex({ name: "hashed" });
    sh.shardCollection("testDb.kittens", { name: "hashed" });
    sh.enableSharding("mdeforge");
    db.createCollection("artifacts");
    db.mdeforge.createIndex({ storageUrl: "hashed" });
    sh.shardCollection("mdeforge.artifacts", { storageUrl: "hashed" });

kibana:
  name: kibana
  replicas: 1
  image: indamutsa/kibana:v1.0.0
  port: 5601
  elasticsearchUrl: "http://es-master:9200"
  resources:
    requests:
      memory:  "1Gi"
      cpu: "750m"
    limits:
      memory: "2Gi"
      cpu: "1.5"
setupRs:
  name: setup-rs
  label: setup-rs
  image: indamutsa/setup-rs:v1.0.5
  restartPolicy: OnFailure
  resources:
    requests:
      memory: "64Mi"
      cpu: "250m"
    limits:
      memory: "128Mi"
      cpu: "500m"

filebeat:
  name: filebeat
  label: filebeat
  image: indamutsa/filebeat:v1.0.0
  resources:
    requests:
      memory: "64Mi"
      cpu: "250m"
    limits:
      memory: "128Mi"
      cpu: "500m"
persistenceApi:
  name: persistence-api
  label: persistence-api
  image: indamutsa/persistence-api:v1.0.1
  replicas: 1
  port: 3200
  resources:
    requests:
      memory: "64Mi"
      cpu: "250m"
    limits:
      memory: "128Mi"
      cpu: "500m"

queryEngine:
  name: query-engine
  label: query-engine
  replicas: 1
  containerName: query-engine
  image: indamutsa/query-engine:v1.0.2
  containerPort: 3300
  resources:
    requests:
      memory: "64Mi"
      cpu: "250m"
    limits:
      memory: "128Mi"
      cpu: "500m"
  servicePort: 3300
  serviceType: ClusterIP


frontendSearch:
  name: frontend-search
  label: frontend-search
  replicas: 1
  containerName: frontend-search
  image: indamutsa/frontend-search:v1.0.0
  containerPort: 3500
  resources:
    requests:
      memory: "64Mi"
      cpu: "250m"
    limits:
      memory: "128Mi"
      cpu: "500m"
  servicePort: 3500
  serviceType: ClusterIP


monstache:
  name: monstache-deployment
  label: monstache
  replicas: 1
  containerName: monstache
  image: indamutsa/monstache:v1.0.0
  args:
    - "-f"
    - "/app/monstache.config.toml"
  containerPort: 8080
  livenessProbe:
    path: /healthz
    port: 8080
    initialDelaySeconds: 1
    periodSeconds: 1
    timeoutSeconds: 30
    failureThreshold: 300
  resources:
    requests:
      memory: "256Mi"
      cpu: "250m"
    limits:
      memory: "512Mi"
      cpu: "500m"
  restartPolicy: Always
  servicePort: 8080
  serviceType: ClusterIP

EOF

echo "Wrote the values for the helm chart to the fiile values.yaml"

mv values.yaml ../values.yaml