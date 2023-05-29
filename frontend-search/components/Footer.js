import Image from "next/image";
import styles from "../styles/Footer.module.scss";
const Footer = () => {
  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <span>&copy;</span>
        <p>MDEForge {new Date().getUTCFullYear()}. All rights reserved</p>
      </div>
    </div>
  );
};

export default Footer;
