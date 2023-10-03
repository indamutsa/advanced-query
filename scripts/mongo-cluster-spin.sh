#!/bin/bash

rm -rf ../mongo-bundle

cat <<EOF > 1-mongodb-configservers.yaml
# Config server replica set 1
apiVersion: v1
kind: Service
metadata:
  name: mongocfg1
  labels:
    app: mongocfg1
spec:
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: mongocfg1
---
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: mongocfg1
spec:
  serviceName: "mongocfg1"
  replicas: 1
  selector:
    matchLabels:
      app: mongocfg1
  template:
    metadata:
      labels:
        app: mongocfg1
    spec:
      containers:
      - name: mongocfg1
        image: indamutsa/mongo:v1.0.0
        command:
        - mongod
        - --configsvr
        - --replSet
        - mongors1conf
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
        - name: mongodb-config-data
          mountPath: /data/db
  volumeClaimTemplates:
  - metadata:
      name: mongodb-config-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi
---

# Config server replica set 2
apiVersion: v1
kind: Service
metadata:
  name: mongocfg2
  labels:
    app: mongocfg2
spec:
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: mongocfg2
---
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: mongocfg2
spec:
  serviceName: "mongocfg2"
  replicas: 1
  selector:
    matchLabels:
      app: mongocfg2
  template:
    metadata:
      labels:
        app: mongocfg2
    spec:
      containers:
      - name: mongocfg2
        image: indamutsa/mongo:v1.0.0
        command:
        - mongod
        - --configsvr
        - --replSet
        - mongors1conf
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
        - name: mongodb-config-data
          mountPath: /data/db
  volumeClaimTemplates:
  - metadata:
      name: mongodb-config-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi
---
# Config server replica set 3
apiVersion: v1
kind: Service
metadata:
  name: mongocfg3
  labels:
    app: mongocfg3
spec:
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: mongocfg3
---
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: mongocfg3
spec:
  serviceName: "mongocfg3"
  replicas: 1
  selector:
    matchLabels:
      app: mongocfg3
  template:
    metadata:
      labels:
        app: mongocfg3
    spec:
      containers:
      - name: mongocfg3
        image: indamutsa/mongo:v1.0.0
        command:
        - mongod
        - --configsvr
        - --replSet
        - mongors1conf
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
        - name: mongodb-config-data
          mountPath: /data/db
  volumeClaimTemplates:
  - metadata:
      name: mongodb-config-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi
EOF

echo "Kubernetes manifests written to mongodb-configservers.yaml"


#!/bin/bash

cat <<EOF > 2-mongodb-shard1.yaml
# Replica Set 1
apiVersion: v1
kind: Service
metadata:
  name: mongors1n1
  labels:
    app: mongors1n1
spec:
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: mongors1n1
---
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: mongors1n1
spec:
  serviceName: "mongors1n1"
  replicas: 1
  selector:
    matchLabels:
      app: mongors1n1
  template:
    metadata:
      labels:
        app: mongors1n1
    spec:
      containers:
      - name: mongors1n1
        image: indamutsa/mongo:v1.0.0
        command:
        - mongod
        - --shardsvr
        - --replSet
        - mongors1
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
  volumeClaimTemplates:
  - metadata:
      name: mongodb-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi
# Replica 2          
---
apiVersion: v1
kind: Service
metadata:
  name: mongors1n2
  labels:
    app: mongors1n2
spec:
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: mongors1n2
---
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: mongors1n2
spec:
  serviceName: "mongors1n2"
  replicas: 1
  selector:
    matchLabels:
      app: mongors1n2
  template:
    metadata:
      labels:
        app: mongors1n2
    spec:
      containers:
      - name: mongors1n2
        image: indamutsa/mongo:v1.0.0
        command:
        - mongod
        - --shardsvr
        - --replSet
        - mongors1
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
  volumeClaimTemplates:
  - metadata:
      name: mongodb-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi
       
---
# Replica Set 3  
apiVersion: v1
kind: Service
metadata:
  name: mongors1n3
  labels:
    app: mongors1n3
spec:
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: mongors1n3
---
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: mongors1n3
spec:
  serviceName: "mongors1n3"
  replicas: 1
  selector:
    matchLabels:
      app: mongors1n3
  template:
    metadata:
      labels:
        app: mongors1n3
    spec:
      containers:
      - name: mongors1n3
        image: indamutsa/mongo:v1.0.0
        command:
        - mongod
        - --shardsvr
        - --replSet
        - mongors1
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
  volumeClaimTemplates:
  - metadata:
      name: mongodb-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi

EOF

echo "Kubernetes manifests written to mongodb-shard1.yaml"


#!/bin/bash

cat <<EOF > 3-mongodb-shard2.yaml
# Replica Set 1
apiVersion: v1
kind: Service
metadata:
  name: mongors2n1
  labels:
    app: mongors2n1
spec:
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: mongors2n1
---
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: mongors2n1
spec:
  serviceName: "mongors2n1"
  replicas: 1
  selector:
    matchLabels:
      app: mongors2n1
  template:
    metadata:
      labels:
        app: mongors2n1
    spec:
      containers:
      - name: mongors2n1
        image: indamutsa/mongo:v1.0.0
        command:
        - mongod
        - --shardsvr
        - --replSet
        - mongors2
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
  volumeClaimTemplates:
  - metadata:
      name: mongodb-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi
# Replica 2          
---
apiVersion: v1
kind: Service
metadata:
  name: mongors2n2
  labels:
    app: mongors2n2
spec:
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: mongors2n2
---
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: mongors2n2
spec:
  serviceName: "mongors2n2"
  replicas: 1
  selector:
    matchLabels:
      app: mongors2n2
  template:
    metadata:
      labels:
        app: mongors2n2
    spec:
      containers:
      - name: mongors2n2
        image: indamutsa/mongo:v1.0.0
        command:
        - mongod
        - --shardsvr
        - --replSet
        - mongors2
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
  volumeClaimTemplates:
  - metadata:
      name: mongodb-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi
       
---
# Replica Set 3  
apiVersion: v1
kind: Service
metadata:
  name: mongors2n3
  labels:
    app: mongors2n3
spec:
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: mongors2n3
---
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: mongors2n3
spec:
  serviceName: "mongors2n3"
  replicas: 1
  selector:
    matchLabels:
      app: mongors2n3
  template:
    metadata:
      labels:
        app: mongors2n3
    spec:
      containers:
      - name: mongors2n3
        image: indamutsa/mongo:v1.0.0
        command:
        - mongod
        - --shardsvr
        - --replSet
        - mongors2
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
  volumeClaimTemplates:
  - metadata:
      name: mongodb-data
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi

EOF

echo "Kubernetes manifests written to mongodb-shard1.yaml"


#!/bin/bash

cat <<EOF > 4-mongodb-routers.yaml
# Mongos Routers replica set 1
apiVersion: apps/v1
kind: Deployment
metadata:
  name: mongos1
spec:
  replicas: 1
  selector:
    matchLabels:
      app: mongos1
  template:
    metadata:
      labels:
        app: mongos1
    spec:
      containers:
      - name: mongos1
        image: indamutsa/mongo:v1.0.0
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
        resources:
          requests:
            memory: "1Gi"
            cpu: "1"
          limits:
            memory: "1Gi"
            cpu: "1"
      volumes:
      - name: config
        configMap:
          name: mongos1-config

---

apiVersion: v1
kind: Service
metadata:
  name: mongos1
spec:
  type: LoadBalancer
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: mongos1

---

apiVersion: v1
kind: ConfigMap
metadata:
  name: mongos1-config
data:
  addShards.js: |
    sh.addShard("mongors1/mongors1n1:27017,mongors1n2:27017,mongors1n3:27017");
    sh.addShard("mongors2/mongors2n1:27017,mongors2n2:27017,mongors2n3:27017");

    // For testing the sharding
    sh.enableSharding("testDb");
    db.createCollection("kittens");
    db.kittens.createIndex({ name: "hashed" });
    sh.shardCollection("testDb.kittens", { name: "hashed" });

    // MDEForge
    sh.enableSharding("mdeforge");
    db.createCollection("artifacts");
    db.mdeforge.createIndex({ storageUrl: "hashed" });
    sh.shardCollection("mdeforge.artifacts", { storageUrl: "hashed" });

---    

# Mongos Routers replica set 2
apiVersion: apps/v1
kind: Deployment
metadata:
  name: mongos2
spec:
  replicas: 1
  selector:
    matchLabels:
      app: mongos2
  template:
    metadata:
      labels:
        app: mongos2
    spec:
      containers:
      - name: mongos2
        image: indamutsa/mongo:v1.0.0
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
        resources:
          requests:
            memory: "1Gi"
            cpu: "1"
          limits:
            memory: "1Gi"
            cpu: "1"
      volumes:
      - name: config
        configMap:
          name: mongos2-config

---

apiVersion: v1
kind: Service
metadata:
  name: mongos2
spec:
  type: LoadBalancer
  ports:
  - port: 27017
    targetPort: 27017
  selector:
    app: mongos2

---

apiVersion: v1
kind: ConfigMap
metadata:
  name: mongos2-config
data:
  addShards.js: |
    sh.addShard("mongors1/mongors1n1:27017,mongors1n2:27017,mongors1n3:27017");
    sh.addShard("mongors2/mongors2n1:27017,mongors2n2:27017,mongors2n3:27017");

    // For testing the sharding
    sh.enableSharding("testDb");
    db.createCollection("kittens");
    db.kittens.createIndex({ name: "hashed" });
    sh.shardCollection("testDb.kittens", { name: "hashed" });

    // MDEForge
    sh.enableSharding("mdeforge");
    db.createCollection("artifacts");
    db.mdeforge.createIndex({ storageUrl: "hashed" });
    sh.shardCollection("mdeforge.artifacts", { storageUrl: "hashed" });

EOF

echo "Kubernetes manifests written to mongodb-routers.yaml"


#!/bin/bash

cat <<EOF > 5-setup-rs-job.yaml
apiVersion: batch/v1
kind: Job
metadata:
  name: setup-rs
spec:
  template:
    metadata:
      labels:
        job-name: setup-rs
    spec:
      containers:
      - name: setup-rs
        image: indamutsa/setup-rs:v1.0.4
        # command:
        # - /bin/sh
        # - -c
        # - |
        #   #!/bin/sh
        #   start_time=\$(date +%s)
        #   while true; do
        #     current_time=\$(date +%s)
        #     duration=\$((current_time - start_time))
            
        #     # Exit after 180 seconds (3 minutes)
        #     if [ \$duration -ge 180 ]; then
        #       echo "Timeout reached!"
        #       exit 1
        #     fi

        #     # Check connectivity to the services
        #     if mongo mongodb://mongos1:27017/ --eval "db.adminCommand('ping')" &&
        #        mongo mongodb://mongos2:27017/ --eval "db.adminCommand('ping')" &&
        #        mongo mongodb://mongocfg1:27017/ --eval "db.adminCommand('ping')" &&
        #        mongo mongodb://mongocfg2:27017/ --eval "db.adminCommand('ping')" &&
        #        mongo mongodb://mongocfg3:27017/ --eval "db.adminCommand('ping')" &&
        #        mongo mongodb://mongors1n1:27017/ --eval "db.adminCommand('ping')" &&
        #        mongo mongodb://mongors1n2:27017/ --eval "db.adminCommand('ping')" &&
        #        mongo mongodb://mongors1n3:27017/ --eval "db.adminCommand('ping')" &&
        #        mongo mongodb://mongors2n1:27017/ --eval "db.adminCommand('ping')" &&
        #        mongo mongodb://mongors2n2:27017/ --eval "db.adminCommand('ping')" &&
        #        mongo mongodb://mongors2n3:27017/ --eval "db.adminCommand('ping')";

        #     then
        #       echo "All services are reachable!"
        #       # Place additional setup tasks here if needed
              
        #       exit 0
        #     else
        #       echo "Waiting for all services to be reachable..."
        #       sleep 10
        #     fi
        #   done
      restartPolicy: Never
EOF

echo "Job manifest written to setup-rs-job.yaml"
