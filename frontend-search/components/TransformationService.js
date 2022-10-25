import styles from "../styles/TransformationService.module.scss";
import Dropdown from "./Dropdown";
import FieldDiv from "./common/FieldDiv";
import SearchInput from "./common/SearchInput";
import SearchRect from "./common/SearchRect";

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
              width={opData.size.inputwidth}
            />
          </SearchRect>
        </div>
      </div>
    </div>
  );
};

export default TransformationService;
