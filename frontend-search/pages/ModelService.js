import ETL from "../components/services/ETL";
import EVL from "../components/services/EVL";
import EOL from "../components/services/EOL";
import ServiceSelect from "../components/ServiceSelect";
import styles from "../styles/Service.module.scss";
import { useAppContext } from "../context/AppContext";
import { useState } from "react";
import axios from "axios";
import Spinner from "../components/common/Spinner";
import { formatXml } from "../adhoc/formatXml";


const ModelService = () => {
  const { state, dispatch } = useAppContext();
  const sourceM = state?.source_m;
  const sourceMM = state?.source_mm;
  const targetMM = state?.target_mm;
  const script = state?.script;

  const [status, setStatus] = useState(false);
  const [result, setResult] = useState();

  const [etl, setEtl] = useState(true);
  const [evl, setEvl] = useState(false);
  const [eol, setEol] = useState(false);


  const handleClick = (value) => {
    switch (value) {
      case "ETL Transformation":
        setEtl(true);
        setEvl(false);
        setEol(false);
        break;
      case "EVL Validation":
        setEtl(false);
        setEvl(true);
        setEol(false);
        break;
      case "EOL Model Object Query":
        setEtl(false);
        setEvl(false);
        setEol(true);
        break;
      default:
        break;
    }
  }

  const execTransfo = async () => {
    // console.log("clockdsd");
    let res;
    try {
      setStatus(true);

      let arrTrans = [
        {
          name: sourceM?.name,
          content: sourceM?.content
        },
        {
          name: sourceMM?.name,
          content: sourceMM?.content
        },
        {
          name: targetMM?.name,
          content: targetMM?.content
        },
        {
          name: script?.name,
          content: script?.content
        }
      ];

      let arrVQ = [
        {
          name: sourceM?.name,
          content: sourceM?.content
        },
        {
          name: sourceMM?.name,
          content: sourceMM?.content
        },
        {
          name: script?.name,
          content: script?.content
        }
      ];

      if (etl) {// Executing the transformation
        res = await axios.post("http://localhost:8085/mms/transform/str", arrTrans)
        // res = await axios.post("https://178.238.238.209.sslip.io/etl/mms/transform/str", arrTrans)
        // res = await axios.post("http://178.238.238.209:8085/mms/transform/str", arrTrans)
      }
      else if (evl) {// Executing the validation
        res = await axios.post("http://localhost:8086/mms/validate/str", arrVQ)
        // res = await axios.post("https://178.238.238.209.sslip.io/evl/mms/validate/str", arrVQ)
        // res = await axios.post("http://178.238.238.209:8086/mms/validate/str", arrVQ)
      }
      else if (eol) {// Executing the query
        res = await axios.post("http://localhost:8087/mms/query/str", arrVQ)
         // res = await axios.post("https://178.238.238.209.sslip.io/eol/mms/query/str", arrVQ)
         // res = await axios.post("http://178.238.238.209:8087/mms/query/str", arrVQ)
      }

      if (res.status === 201) {
        setStatus(false);
        setResult(res.data);
      } else {
        setStatus(false);
        setResult(res.data);
      }
    } catch (error) {
      setStatus(false);
      setResult("Error occurred while executing the operation\nPlease check your input!" + "\n" + error.response.data.message);
    }
  }

  return (
    <div className={styles.container}>
      <div className={status ? styles.spinner : styles.spinnerNone}>
        <div className={styles.spinnerBorder}>
          <Spinner type={"bars"} color={"#2c5b69"} />
          <div className={styles.loading}>Loading...</div>
        </div>
      </div>
      <div>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
          <div className={styles.title}>Advanced management services</div>
          <button onClick={execTransfo}>Execute</button>
        </div>
        <div className={styles.upperBox}>

          <div className={styles.titleComponent}>
            <ServiceSelect handleClick={handleClick} />
          </div>
          {etl && <ETL />}
          {evl && <EVL />}
          {eol && <EOL />}



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



