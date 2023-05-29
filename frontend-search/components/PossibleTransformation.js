import styles from "../styles/Advanced.module.scss";
import Dropdown from "./Dropdown";
import FieldDiv from "./common/FieldDiv";
import SearchInput from "./common/SearchInput";
import SearchRect from "./common/SearchRect";

const opData = {
  dropdown: {
    title: "Operator",
    metaTitle: "Operator",
    id: "ID",
    name: "Artifact name",
    unique_name: "Artifact unique_name",
    file: "Upload a file",
  },
  size: {
    fieldwidth: 15,
    dropwidth: 25,
    inputwidth: 15,
  },
};

const PossibleTransformation = () => {
  return (
    <div className={styles.transformations}>
      <div className={styles.title}>Possible Transformation</div>
      <SearchRect>
        <FieldDiv width={10}>Metamodel</FieldDiv>
        <Dropdown data={opData} />
        <SearchInput
          type="text"
          placeholder="Enter selected field..."
          width={opData.size.inputwidth}
        />
      </SearchRect>

      <SearchRect>
        <FieldDiv width={10}>Etl script</FieldDiv>
        <Dropdown data={opData} />
        <SearchInput
          type="text"
          placeholder="Enter selected field..."
          width={opData.size.inputwidth}
        />
      </SearchRect>
    </div>
  );
};

export default PossibleTransformation;
