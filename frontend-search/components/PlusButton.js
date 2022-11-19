import styles from "../styles/Plus.module.scss";
import Image from "next/image";

const PlusButton = () => {
  return (
    <span className={styles.plus}>
      <Image src="/image/plus.svg" alt="plus" height="23px" width="23px" />
    </span>
  );
};

export default PlusButton;
