import PageTitle from "../components/common/PageTitle";
import DisplayItem from "../components/DisplayItem";
import styles from "../styles/ModelDisplay.module.scss";
import { useAppContext } from "../context/AppContext";
import { useEffect } from "react";
import { useState } from "react";
import { useRouter } from "next/router";


let datam = {
  Name: "",
  Description: "",
  ID: "",
  Type: "",
  Unique_name: "",
  StorageUrl:
    "",
  Project: "",
  Workspace: "",
  "Access control": "",
  CreatedAt: "",
  "Last modifiedAt": "",
};

// let datam = {
//   Name: "SimpleOOP.ecore",
//   Description: "We are trying to save the metamodel using the api",
//   Type: "METAMODEL",
//   StorageUrl:
//     "http://178.238.238.209:3200/files/metamodels/SimpleOOP-1649864593972-32.ecore",
//   Project: "Project_id",
//   Workspace: "Workspace_id",
//   "Access control": "PUBLIC",
//   CreatedAt: "TimeStamp",
//   "Last modifiedAt": "TimeStamp",
// };


const ModelDisplay = () => {
  const { state, dispatch } = useAppContext();
  const [data, setData] = useState({})
  const router = useRouter();

  let { content, ...returnedData } = data;
  const keys = Object.keys(returnedData);
  const values = Object.values(returnedData);

  const typeDisp = {
    DSL: "script",
    METAMODEL: "metamodel",
    MODEL: "model",
  }

  useEffect(() => {

    if (Object.keys(state.item).length !== 0 && Object.keys(data).length === 0) {
      // fetch(`http://178.238.238.209:3200/store/artifact/${typeDisp[state.item.type]}/${state.item.id}`)
      fetch(`https://178.238.238.209.sslip.io/repo/store/artifact/${typeDisp[state.item.type]}/${state.item.id}`)
        .then((res) => res.json())
        .then((d) => {
          // console.log(d);
          let mdata = {
            Name: d.returnedData.name,
            Description: d.returnedData.description,
            Type: d.returnedData.type,
            Unique_name: d.returnedData.unique_name,
            ID: d.returnedData._id,
            content: d.returnedData.content,
            StorageUrl:
              d.returnedData.storageUrl,
            Project: "[ " + d.returnedData.project.toString() + " ]",
            Workspace: "Workspace_id",
            "Access control": d.returnedData.accessControl,
            CreatedAt: d.returnedData.createdAt,
            "Last modifiedAt": d.returnedData.updatedAt
          };
          setData(mdata)
        })
    }
    else {
      setData(datam)
    }
  }, [state,])

  const handleClick = (e) => {
    e.preventDefault();
    // console.log(data);
    dispatch({
      type: "content", value: data
    })
    // navigate to model-view
    router.push('/edit-artifact')
  }

  return (
    <div className={styles.container}>
      <PageTitle>
        Name: <span>{data.Name}</span>
      </PageTitle>
      <div className={styles.hrCenter}>
        <hr className={styles.hr} />
      </div>
      <div>
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
          <div onClick={e => handleClick(e)} className={styles.edit}>Edit content</div>
        </div>
      </div>
    </div>
  );
};

export default ModelDisplay;
