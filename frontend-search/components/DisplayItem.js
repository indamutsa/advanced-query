import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
// import the icons you need
import { faRefresh, faEdit } from "@fortawesome/free-solid-svg-icons";
import styles from "../styles/DisplayItem.module.scss";

const DisplayItem = ({ data }) => {
  const { key, value } = data;
  console.log(key, value);
  return (
    <div className={styles.dispItem}>
      <div className={styles.fieldItem}>
        <span>{key}:</span> <span>{value}</span>
      </div>
      <div className={styles.crudOp}>
        <div className={styles.editField}>
          Edit
          <FontAwesomeIcon
            icon={faEdit}
            style={{ fontSize: 13, marginLeft: 10, color: "white" }}
          />
        </div>
        <div className={styles.updateField}>
          Update
          <FontAwesomeIcon
            icon={faRefresh}
            style={{ fontSize: 13, marginLeft: 10, color: "white" }}
          />
        </div>
      </div>
    </div>
  );
};

export default DisplayItem;
