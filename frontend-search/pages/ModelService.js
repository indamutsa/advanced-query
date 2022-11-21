import TransformationService from "../components/TransformationService";
import ServiceSelect from "../components/ServiceSelect";
import styles from "../styles/Service.module.scss";
import { useAppContext } from "../context/AppContext";
import { useState } from "react";
import { useEffect } from "react";


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




const ModelService = () => {
  const { state, dispatch } = useAppContext();

  const execTransfo = () => {
    console.log(state.source_m, "Execute");
  }


  return (
    <div className={styles.container}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <div className={styles.title}>Advanced management services</div>
        <button onClick={execTransfo}>Execute</button>
      </div>
      <div className={styles.upperBox}>

        <div className={styles.titleComponent}>
          <ServiceSelect />
        </div>
        <TransformationService />


      </div>
      <div className={styles.console}>
        <div className={styles.consoleTitle}>Console</div>
        <div className={styles.consoleBox}>
          {state.operationResult}
        </div>
      </div>
    </div>
  );
};

export default ModelService;
