import styles from "../styles/ResultBox.module.scss";
const ResultBox = () => {
  return (
    <div className={styles.container}>
      <div className={styles.upperDiv}>
        <div className={styles.url}>
          http://178.238.238.209:3200/files/metamodels/SimpleOOP-1649864593972-32.ecore
        </div>
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
        <div className={styles.viewDownload}>View / Download</div>
      </div>
    </div>
  );
};

export default ResultBox;
