import TransformationService from "../components/TransformationService";
import ServiceSelect from "../components/ServiceSelect";
import styles from "../styles/Service.module.scss";

const data = {
  dropdown: {
    metaTitle: "Choose a service...",
    etl: "ETL Transformation",
    evl: "EVL Validation",
    eol: "EOL Model object query",
  },
  size: {
    fieldwidth: 10,
    dropwidth: 10,
    inputwidth: 10,
  },
};

const service = () => {
  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.upperView}>
          <div className={styles.title}>Advanced management services</div>
          <div className={styles.upperBox}>
            <div className={styles.box}>
              <div className={styles.titleComponent}>
                <ServiceSelect />
              </div>
              <TransformationService />
            </div>
          </div>
          <div className={styles.console}>
            <div className={styles.consoleTitle}>Console</div>
            <div className={styles.consoleBox}></div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default service;
