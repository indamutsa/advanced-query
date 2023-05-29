import styles from "../styles/Plus.module.scss";
import Image from "next/image";

const PlusButton = ({ handleClick, i, mk, size }) => {
  return (
    <span className={styles.plus} onClick={() => {
      handleClick(i, mk, size)
    }}>
      <img src={i == 0 ? "/image/plus.svg" : "/image/minus.svg"} height="23rem" width="23rem" alt="d" />
    </span>
  );
};

export default PlusButton;
