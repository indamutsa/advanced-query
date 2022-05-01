import Image from "next/image";
import styles from "../styles/Home.module.scss";

const Home = () => {
  return (
    <div className={styles.container}>
      <div className={styles.title}>
        <div className={styles.mde}>MDEFORGE Search Facility</div>
        <div className={styles.mdeImg}>
          <Image src="/image/mde.svg" alt="" width="540px" height="81px" />
        </div>
      </div>
      <div className={styles.searchBar}>
        <div className={styles.bar}>
          <input
            className={styles.searchArtifacts}
            name="searchartifacts"
            placeholder="Search artifacts..."
            type="text"
            required=""
          />
          <Image
            src="/image/magnify-glass.svg"
            alt=""
            width="40px"
            height="40px"
          />
        </div>

        <div className={styles.advanced}>Advanced Search</div>
      </div>
      <div className={styles.description}>
        <p>
          MDEForge is a cloud-based repository for model artifacts that supports
          advanced query mechanisms and provides collaborative features for
          sharing, reusing and executing transformations on model artifacts.
          <br />
          <br />
          MDEForge uses the MDEForge Query engine to provide powerful search
          capabilities. The repository can be accessed through various APi
          specifications and through a web interface. It supports artifact
          peristence operations, model management services, search and it is
          tuned to support machine learning techniques.
        </p>
      </div>
    </div>
  );
};

export default Home;
