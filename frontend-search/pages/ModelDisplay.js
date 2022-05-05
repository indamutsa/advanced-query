import PageTitle from "../components/common/PageTitle";
import DisplayItem from "../components/DisplayItem";
import styles from "../styles/ModelDisplay.module.scss";

let data = {
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

const keys = Object.keys(data);
const values = Object.values(data);

const ModelDisplay = () => {
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
        <div className={styles.edit}>Edit content</div>
      </div>
    </div>
  );
};

export default ModelDisplay;
