import TransformationService from "../components/TransformationService";
import ServiceSelect from "../components/ServiceSelect";
import styles from "../styles/Service.module.scss";
import { useAppContext } from "../context/AppContext";
import { useState } from "react";
import { useEffect } from "react";
import axios from "axios";
import Spinner from "../components/common/Spinner";
import { formatXml } from "../adhoc/formatXml";


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
  const sourceM = state.source_m;
  const sourceMM = state.source_mm;
  const targetMM = state.target_mm;
  const script = state.script;

  const [status, setStatus] = useState(false);
  const [result, setResult] = useState();

  const execTransfo = async () => {
    // console.log(state.source_m, state.source_mm, state.target_mm, state.script);
    // Creating request object
    setStatus(true);

    let arr = [
      {
        name: sourceM.name,
        content: sourceM.content
      },
      {
        name: sourceMM.name,
        content: sourceMM.content
      },
      {
        name: targetMM.name,
        content: targetMM.content
      },
      {
        name: script.name,
        content: script.content
      }
    ];

    // Executing the transformation
    const res = await axios.post("http://178.238.238.209:8085/mms/transform/str", arr)

    // console.log(res.status);
    if (res.status === 201) {
      setStatus(false);
      setResult(res.data);
    } else {
      setStatus(false);
      setResult("Error occurred while executing the transformation\nPlease check your input!");
    }
  }

  // useEffect(() => {
  //   setStatus(false);
  //   setResult(result);
  // }, [result])


  return (
    <div className={styles.container}>
      <div className={status ? styles.spinner : styles.spinnerNone}>
        <div className={styles.spinnerBorder}>
          <Spinner type={"bars"} color={"#2c5b69"} />
          <div style={{ backgroundColor: "white", padding: "5px 15px", display: "inline", margin: "" }}>Loading...</div>
        </div>
      </div>
      <div>
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
            <pre>{formatXml(result)}</pre>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ModelService;
