import styles from "../styles/ResultBox.module.scss";
import Link from "next/link";

const ResultBox = () => {
  return (
    <div className={styles.container}>
      <div className={styles.upperDiv}>
        <Link
          passHref
          href="http://178.238.238.209:3201/file/metamodels/SimpleOOP-1651518206305-59.ecore"
        >
          <a target="_blank" className={styles.url}>
            http://178.238.238.209:3201/file/metamodels/SimpleOOP-1651518206305-59.ecore
          </a>
        </Link>
        <div className={styles.name}>
          <p> Name:</p> <span>SimpleOOP.ecore</span>
        </div>
        <div className={styles.size}> Size: 3k </div>
        <div className={styles.date}>Jul 17th 2021</div>
      </div>
      <div className={styles.bottomDiv}>
        <div className={styles.description}>
          <span>Description: </span>
          <span>
            MDEForge is a cloud-based repository for model artifacts that
            supports advanced query mechanisms and provides collaborative
            features for sharing, reusing and executing transformations on model
            artifacts
          </span>
        </div>
        <Link href="artifact-display" passHref>
          <div className={styles.viewDownload}>View / Download</div>
        </Link>
      </div>
    </div>
  );
};

export default ResultBox;
