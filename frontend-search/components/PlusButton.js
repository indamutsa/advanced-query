import styles from "../styles/Advanced.module.scss";
import Image from "next/image";

const PlusButton = () => {
  return (
    <div className={styles.plus}>
      <Image src="/image/plus.svg" alt="plus" height="33px" width="33px" />
    </div>
  );
};

export default PlusButton;
