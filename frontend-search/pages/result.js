import styles from "../styles/Result.module.scss";
import Image from "next/image";
import ResultBox from "../components/ResultBox";
import Link from "next/link";

const result = () => {
  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.upperView}>
          <div className={styles.title}>Search results</div>
          <div className={styles.searchBar}>
            <input
              className={styles.search}
              name="searchartifacts"
              placeholder="Search artifacts..."
              type="text"
              required=""
            />
            <Link href="/advanced-search">
              <Image
                className={styles.magnify}
                src="/image/magnify-glass.svg"
                alt="magnify"
                height="32px"
                width="32px"
              />
            </Link>
          </div>
          <div className={styles.metaResults}>
            <div className={styles.total}>Total: 556</div>
            <Link href="/advanced-search">
              <div className={styles.advanced}>Advanced Search</div>
            </Link>
          </div>
        </div>
        <div className={styles.result}>
          <ResultBox />
          <ResultBox />
          <ResultBox />
          <ResultBox />
          <ResultBox />
          <ResultBox />
          <ResultBox />
          <ResultBox />
        </div>
      </div>
    </div>
  );
};

export default result;
