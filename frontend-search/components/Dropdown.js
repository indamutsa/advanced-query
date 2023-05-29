import Image from "next/image";
import { useState } from "react";
import FieldDiv from "./common/FieldDiv";
import styles from "../styles/Dropdown.module.scss";
import DropDiv from "./common/DropDiv";
import { useAppContext } from "../context/AppContext";

const Dropdown = ({ data, handleInput }) => {
  const { state, dispatch } = useAppContext();
  const [isOpen, setIsOpen] = useState(true);
  const [item, setItem] = useState("");
  const [field, setField] = useState(true);
  const [object, setObject] = useState({
    key: "",
    value: ""
  });
  const { dropdown, size } = data;

  const { metaTitle } = dropdown;
  const { fieldwidth, dropwidth } = size;

  let items = Object.values(dropdown);
  items = items.filter(
    (item) =>
      item !== "All fields" &&
      item !== "Search in context" &&
      item !== "Operator" &&
      item !== "Quality Assessment" &&
      item !== "Quality metrics / attributes" &&
      item !== "Choose a service..."
  );



  return (
    <div>
      <FieldDiv width={fieldwidth}>
        <div className={styles.container}>
          <div className={styles.field}>{field ? metaTitle : item}</div>
          <div
            onClick={() => {
              setIsOpen(!isOpen);
            }}
            className={isOpen ? styles.dropImage : styles.rotate}
          >
            <Image
              src="/image/dropdown.svg"
              alt=""
              height="22px"
              width="22px"
            />
          </div>
        </div>
      </FieldDiv>
      <DropDiv width={dropwidth}>
        {!isOpen &&
          items.map((item, i) => (
            <div
              className={styles.item}
              key={i}
              onClick={(e) => {
                setIsOpen(!isOpen);
                setItem(item);
                setField(false);
                handleInput(item);
                // The function below inside dispatch gets the key by the value
                dispatch({
                  type: "advanced", value: {
                    key: Object.keys(dropdown).find(key => dropdown[key] === item)
                  }
                })
              }}
            >
              {item}
            </div>
          ))}
      </DropDiv>
    </div>
  );
};

export default Dropdown;
