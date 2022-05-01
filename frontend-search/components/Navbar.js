import Image from "next/image";
import styles from "../styles/Navbar.module.scss";
const Navbar = () => {
  const showLogo = true;
  return (
    <div className={styles.container}>
      {showLogo && (
        <div className={styles.logo}>
          <p>MDEFORGE</p>
          <div className={styles.logoImg}>
            <Image
              src={"/image/logo-image.svg"}
              alt=""
              width="150px"
              height="12px"
            />
          </div>
          <p>Search Facility</p>
        </div>
      )}
      <div className={styles.navbar}>
        <ul className={styles.list}>
          <li className={styles.listItem}>Browse</li>
          <li className={styles.listItem}>Services</li>
          <li className={styles.listItem}>Log In</li>
          <li className={styles.listItem}>Register</li>
        </ul>
      </div>
    </div>
  );
};

export default Navbar;
