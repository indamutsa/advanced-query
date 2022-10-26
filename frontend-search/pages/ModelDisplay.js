import PageTitle from "../components/common/PageTitle";
import DisplayItem from "../components/DisplayItem";
import styles from "../styles/ModelDisplay.module.scss";
import Link from "next/link";
import { useAppContext } from "../context/AppContext";
import { useEffect } from "react";
import { useState } from "react";


let datam = {
  Name: "SimpleOOP.ecore",
  Description: "We are trying to save the metamodel using the api",
  Type: "METAMODEL",
  StorageUrl:
    "http://178.238.238.209:3200/files/metamodels/SimpleOOP-1649864593972-32.ecore",
  Project: "Project_id",
  Workspace: "Workspace_id",
  "Access control": "PUBLIC",
  CreatedAt: "TimeStamp",
  "Last modifiedAt": "TimeStamp",
};


const ModelDisplay = () => {
  const [data, setData] = useState({})


  const keys = Object.keys(data);
  const values = Object.values(data);


  const { state, dispatch } = useAppContext();
  const typeDisp = {
    DSL: "script",
    METAMODEL: "metamodel",
    MODEL: "model",
  }

  useEffect(() => {
    console.log(state);
    if (Object.keys(state.item).length !== 0) {
      fetch(`http://localhost:3200/store/artifact/${typeDisp[state.item.type]}/${state.item.id}`)
        .then((res) => res.json())
        .then((data) => {
          let mdata = {
            Name: data ? data.returnedData.name : "SimpleOOP.ecore",
            Description: data ? data.returnedData.description : "We are trying to save the metamodel using the api",
            Type: data ? data.returnedData.type : "METAMODEL",
            StorageUrl:
              data ? data.returnedData.storageUrl : "http://178.238.238.209:3200/files/metamodels/SimpleOOP-1649864593972-32.ecore",
            Project: data ? "[ " + data.returnedData.project.toString() + " ]" : "Project_id",
            Workspace: "Workspace_id",
            "Access control": data ? data.returnedData.accessControl : "PUBLIC",
            CreatedAt: data ? data.returnedData.createdAt : "TimeStamp",
            "Last modifiedAt": data ? data.returnedData.updatedAt : "TimeStamp",
          };
          setData(mdata)
        })
    }
    else {
      setData(datam)
    }
  }, [state])

  return (
    <div className={styles.container}>
      <PageTitle>
        Name: <span>SimpleOOP.ecore</span>
      </PageTitle>
      <div className={styles.hrCenter}>
        <hr className={styles.hr} />
      </div>
      <div className={styles.centerDisplay}>
        <div className={styles.modelDisp}>
          {keys.map((item, i) => {
            let value = values[i];
            let obj = { key: item, value: value };

            return <DisplayItem key={i} data={obj} />;
          })}
        </div>
      </div>
      <div className={styles.editContent}>
        <Link href="/edit-artifact" passHref>
          <div className={styles.edit}>Edit content</div>
        </Link>
      </div>
    </div>
  );
};

export default ModelDisplay;
