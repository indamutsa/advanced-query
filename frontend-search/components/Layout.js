import Footer from "./Footer";
import Navbar from "./Navbar";
import styles from "../styles/Layout.module.scss";

const Layout = ({ children }) => {
  return (
    <div className={styles.layout}>
      <Navbar />
      <div className={styles.footerFix}>
        {children}
        <Footer />
      </div>
    </div>
  );
};

export default Layout;
