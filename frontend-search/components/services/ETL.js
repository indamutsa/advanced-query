import styles from "../../styles/TransformationService.module.scss";
import OpEditor from "../OpEditor";

const opData = {
  dropdown: {
    title: "Operator",
    metaTitle: "Input type",
    id: "ID",
    name: "Artifact name",
    unique_name: "Artifact unique_name",
    file: "Upload a file",
  },
  size: {
    fieldwidth: 10,
    dropwidth: 10,
    inputwidth: 15,
  },
};

const ETL = () => {

  return (
    <div className={styles.container}>
      <div className={styles.blocka}>
        <OpEditor artifact={"Source model"} />
        <OpEditor artifact={"Source metamodel"} />
      </div>
      <div className={styles.blockb}>
        <OpEditor artifact={"Target metamodel"} />
        <OpEditor artifact={"ETL Script"} />
      </div>
    </div>
  );
};

export default ETL;
