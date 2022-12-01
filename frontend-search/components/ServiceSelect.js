import DropDiv from "./common/DropDiv";
import FieldDiv from "./common/FieldDiv";
import styles from "../styles/Dropdown.module.scss";
import { useState } from "react";
import Image from "next/image";
import { useAppContext } from "../context/AppContext";

const ServiceSelect = ({ handleClick }) => {
  const { state, dispatch } = useAppContext();
  const [isOpen, setIsOpen] = useState(true);
  const [item, setItem] = useState("");
  const [field, setField] = useState(true);
  const items = [
    "ETL Transformation",
    "EVL Validation",
    "EOL Model Object Query",
  ];




  const metaTitle = "Choose a service...";

  const fieldwidth = 30;
  const dropwidth = 24;
  return (
    <div>
      <FieldDiv width={fieldwidth}>
        <div className={styles.container} onClick={() => {
          setIsOpen(!isOpen);
        }}>
          <div className={styles.field}>{items[0]}</div>
          <div

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
                // setField(false);
                handleClick(item);
              }}
            >
              {item}
            </div>
          ))}
      </DropDiv>
    </div>
  );
};

export default ServiceSelect;
