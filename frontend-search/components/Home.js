<<<<<<< HEAD
import { useRef } from "react";
=======
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
import Image from "next/image";
import Link from "next/link";
import styles from "../styles/Home.module.scss";
import { useRouter } from "next/router";
import { useAppContext } from "../context/AppContext";
<<<<<<< HEAD
import { getData } from "../services";

const Home = () => {
  const router = useRouter();
  const inputRef = useRef("Hello");
=======

const Home = () => {
  const router = useRouter();
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b

  // UseContext when using useReducer
  const { state, dispatch } = useAppContext();

  const handleSubmit = (e) => {
    e.preventDefault();
<<<<<<< HEAD
    let searchQuery = inputRef.current.value;

    dispatch({ type: "add_number", value: searchQuery });
=======
    dispatch({ type: "add_number", value: 3 });
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
    router.push(`/result`);
  };

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
          <form onSubmit={handleSubmit}>
            <input
              className={styles.searchArtifacts}
              name="searchartifacts"
              placeholder="Search artifacts..."
              type="text"
              required=""
<<<<<<< HEAD
              ref={inputRef}
=======
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
            />
          </form>

          <Image
            src="/image/magnify-glass.svg"
            alt=""
            width="40px"
            height="40px"
            onClick={handleSubmit}
          />
        </div>
        <Link href="/advanced-search" passHref>
          <div className={styles.advanced}>Advanced Search</div>
        </Link>
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
