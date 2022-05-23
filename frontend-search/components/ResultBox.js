import styles from "../styles/ResultBox.module.scss";
import Link from "next/link";

const ResultBox = ({ data }) => {
  // console.log(data);
  const { name, size, date, description, link } = data;
  return (
    <div className={styles.container}>
      <div className={styles.upperDiv}>
        <Link passHref href={link}>
          <a target="_blank" className={styles.url}>
            {link}
          </a>
        </Link>
        <div className={styles.name}>
          <p> Name:</p> <span>{name}</span>
        </div>
        <div className={styles.size}> Size: {size} </div>
        <div className={styles.date}>{date}</div>
      </div>
      <div className={styles.bottomDiv}>
        <div className={styles.description}>
          <span>Description: </span>
          <span>{resizeDesc(description)}</span>
        </div>
        <Link href="/artifact-display" passHref>
          <div className={styles.viewDownload}>View / Download</div>
        </Link>
      </div>
    </div>
  );
};

export default ResultBox;

function resizeDesc(text) {
  if (text.length > 232) return text.substring(0, 232) + "...";
  return text;
}

// (size < 5000) NOT (ext="xmi") OR (CMC == 2 AND AVGATTR <= 2) keyword1 AND conformsTo="unique_name" hasAttribute="name" AND isTransformable="ID"
