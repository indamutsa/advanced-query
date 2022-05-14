import styles from "../styles/Result.module.scss";
import Image from "next/image";
import ResultBox from "../components/ResultBox";
import Link from "next/link";
import { useRouter } from "next/router";
import { useAppContext } from "../context/AppContext";

const Result = ({ data }) => {
  const router = useRouter();

  // UseContext when using useReducer
  const { state, dispatch } = useAppContext();
  const { number } = state;
  console.log(number);

  const handleSubmit = (e) => {
    e.preventDefault();
    router.push(`/result`);
  };

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.upperView}>
          <div className={styles.title}>Search results</div>
          <div className={styles.searchBar}>
            <form onSubmit={handleSubmit}>
              <input
                className={styles.search}
                name="searchartifacts"
                placeholder="Search artifacts..."
                type="text"
                required=""
              />
            </form>

            <Image
              className={styles.magnify}
              src="/image/magnify-glass.svg"
              alt="magnify"
              height="32px"
              width="32px"
              onClick={handleSubmit}
            />
          </div>
          <div className={styles.metaResults}>
            <div className={styles.total}>Total: 556</div>
            <Link href="/advanced-search" passHref>
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

export default Result;
