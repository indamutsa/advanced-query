rsconf = {
  _id: "mongors1conf",
  configsvr: true,
  members: [
    { _id: 0, host: "mongocfg1" },
    { _id: 1, host: "mongocfg2" },
    { _id: 2, host: "mongocfg3" },
  ],
};

// Initiate the replicaset
rs.initiate(rsconf);
