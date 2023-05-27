import styles from "../styles/ResultBox.module.scss";
import Link from "next/link";
import { useAppContext } from "../context/AppContext";
import { useRouter } from "next/router";
import { useState } from "react";

const ResultBox = ({ data }) => {
  const { state, dispatch } = useAppContext();
  const router = useRouter();

  const { id, name, size, type, createdAt, description, storageUrl } = data;
  let item = {
    id,
    name,
    storageUrl,
    type,
  };
  const handleClick = (e, item) => {
    e.preventDefault();
    dispatch({ type: "item", value: item });
    // navigate to model-view
    router.push("/artifact-display");
  };

  const confirmus = (e) => {
    let text = "Do you want to download the artifact?";
    if (window.confirm(text) == true) {
      window.open(e.target.innerText, "_blank").focus();
    }
  };

  const bytesToKb = (bytes) => {
    const kb = bytes / 1024;
    return Math.round(kb * 10) / 10;
  };

  return (
    <div className={styles.container}>
      <div className={styles.upperDiv}>
        <p onClick={confirmus} className={styles.url}>
          {storageUrl}
        </p>

        <div className={styles.name}>
          <p> Name:</p> <span>{name}</span>
        </div>
        <div className={styles.size}> Size: {bytesToKb(size)} Kb</div>
        <div className={styles.date}>{createdAt}</div>
      </div>
      <div className={styles.bottomDiv}>
        <div className={styles.description}>
          <span>Description: </span>
          <span>{resizeDesc(description)}</span>
        </div>
        <Link href="/artifact-display" passHref>
          <div
            onClick={(e) => handleClick(e, item)}
            className={styles.viewDownload}
          >
            View / Download
          </div>
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
