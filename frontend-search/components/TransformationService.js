import styles from "../styles/TransformationService.module.scss";
import Dropdown from "./Dropdown";
import FieldDiv from "./common/FieldDiv";
import SearchInput from "./common/SearchInput";
import SearchRect from "./common/SearchRect";
import axios from "axios";
import { useRef } from "react";
import { useAppContext } from "../context/AppContext";



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

const TransformationService = () => {
  const { dispatch } = useAppContext()

  const sourceMRef = useRef();
  const sourceMMRef = useRef();
  const targetMMRef = useRef();
  const scriptRef = useRef();

  const execTrans = async () => {
    const sourceMID = sourceMRef.current.value
    const sourceMMID = sourceMMRef.current.value
    const targetMMID = targetMMRef.current.value
    const scriptID = scriptRef.current.value
    console.log(sourceMID);

    try {
      // Calling individual artifacts
      const sourceM = await axios.get(`http://178.238.238.209:3200/store/artifact/model/${sourceMID}`);
      const sourceMM = await axios.get(`http://178.238.238.209:3200/store/artifact/metamodel/${sourceMMID}`)
      const targetMM = await axios.get(`http://178.238.238.209:3200/store/artifact/metamodel/${targetMMID}`)
      const script = await axios.get(`http://178.238.238.209:3200/store/artifact/script/${scriptID}`)

      // Creating request object
      let arr = [
        {
          name: sourceM.data.returnedData.name,
          content: sourceM.data.returnedData.content
        },
        {
          name: sourceMM.data.returnedData.name,
          content: sourceMM.data.returnedData.content
        },
        {
          name: targetMM.data.returnedData.name,
          content: targetMM.data.returnedData.content
        },
        {
          name: script.data.returnedData.name,
          content: script.data.returnedData.content
        }
      ];

      // Executing the transformation
      const res = await axios.post("http://178.238.238.209:8085/mms/transform/str", arr)
      console.log(res.data);

      dispatch({ type: "operationResult", value: res.data })

      return res.data
    } catch (error) {
      dispatch({ type: "operationResult", value: error.message })
      return error.message
    }

  }



  return (
    <div className={styles.container}>
      <div className={styles.blocka}>
        <div className={styles.blockb}>
          <SearchRect width={35}>
            <FieldDiv width={10}>Source model</FieldDiv>
            <Dropdown data={opData} />
            <SearchInput
              type="text"
              placeholder="Enter selected field..."
              width={opData.size.inputwidth}
              ref={sourceMRef}
            />
          </SearchRect>
        </div>

        <div className={styles.blockb}>
          <SearchRect width={35}>
            <FieldDiv width={10}>Source metamodel</FieldDiv>
            <Dropdown data={opData} />
            <SearchInput
              type="text"
              placeholder="Enter selected field..."
              ref={sourceMMRef}
              width={opData.size.inputwidth}
            />
          </SearchRect>
        </div>
      </div>
      <div className={styles.blocka}>
        <div className={styles.blockb}>
          <SearchRect width={35}>
            <FieldDiv width={10}>Target metamodel</FieldDiv>
            <Dropdown data={opData} />
            <SearchInput
              type="text"
              placeholder="Enter selected field..."
              ref={targetMMRef}
              width={opData.size.inputwidth}
            />
          </SearchRect>
        </div>
        <div className={styles.blockb}>
          <SearchRect width={35}>
            <FieldDiv width={8}>Script</FieldDiv>
            <Dropdown data={opData} />
            <SearchInput
              type="text"
              placeholder="Enter selected field..."
              ref={scriptRef}
              width={opData.size.inputwidth}
            />
          </SearchRect>
        </div>
      </div>
      <button className={styles.execute} onClick={execTrans}>
        Execute
      </button>
    </div>
  );
};

export default TransformationService;


// -----------------------------------------

// const sourceM = await axios.get(`http://178.238.238.209:3200/store/artifact/model/62702f7e6320d300138daa59`)
// const sourceMM = await axios.get(`http://178.238.238.209:3200/store/artifact/metamodel/62702a4d6320d300138ce572`)
// const targetMM = await axios.get(`http://178.238.238.209:3200/store/artifact/metamodel/62702a4d6320d300138ce572`)
// const script = await axios.get(`http://178.238.238.209:3200/store/artifact/script/635fdcab19b0930014799eba`)