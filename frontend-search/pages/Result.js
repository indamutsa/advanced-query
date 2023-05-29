import styles from "../styles/Result.module.scss";
import Image from "next/image";
import ResultBox from "../components/ResultBox";
import Link from "next/link";
import { useAppContext } from "../context/AppContext";
import { useRef, useState } from "react";
import { getAdvancedSearchData, getData } from "../services";
import { useEffect } from "react";

const Result = () => {
  const { state, dispatch } = useAppContext();
  const inputRef = useRef();
  const [results, setResults] = useState([]);
  const [total, setTotal] = useState(0);
  const [page, setPage] = useState(0);
  const [limit, setLimit] = useState(10);

  const calculatePage = (tot) => {
    try {
      let totNum = tot % 10 === 0 ? tot / 10 : Math.floor(tot / 10) + 1;
      return Array.from(Array(totNum).keys()).map((totNum) => totNum * limit);
    } catch (error) {
      alert("Error occured: ", error.message);
    }
  };

  const pages = calculatePage(total ? total : 0);

  const handleSubmit = async (e) => {
    e.preventDefault();
    // console.log("On submit....");
    try {
      setPage(0);

      let query = inputRef.current.value;
      dispatch({
        type: "search-query",
        value: {
          query,
          source: "result",
        },
      });

      let res = await getData(query);

      setResults(res.query.data);
      setTotal(res.query.total_hits);
    } catch (error) {
      alert("Error occured: ", error.message);
    }
  };

  const handleDataQ = async (page, limit) => {
    try {
      let res = await getAdvancedSearchData(
        state?.searchQuery?.query,
        page,
        limit,
        total
      );

      setResults(res.advancedQuery.data);
      setTotal(res.advancedQuery.total_hits);
      // console.log(results);
    } catch (error) {
      console.log("Error occured: ", error.message);
    }
  };

  const handleData = async (page, limit) => {
    try {
      let res;
      res = await getData(state?.searchQuery?.query, page, limit, total);

      setResults(res.query.data);
      setTotal(res.query.total_hits);
    } catch (error) {
      console.log("Error occured: ", error.message);
    }
  };

  useEffect(() => {
<<<<<<< HEAD
    console.log("Page changed === : ", results);
=======
    console.log("Page changed: ", results);
>>>>>>> eac889988eaa001bbb110548cab4098c97cf68e4

    if (state?.searchQuery?.source == "home") {
      // console.log("Changed from hoome", state.searchQuery);
      handleData();
    } else if (state?.searchQuery?.source == "advanced") {
      // console.log("Changed from advanced", state.searchQuery);
      handleDataQ();
    }
  }, [state?.searchQuery]);

  //===============
  const goPrevious = async () => {
    if (total == 0) {
      alert("No previous page");
    }

    setPage(page <= 0 ? pages.length - 1 : page - 1);
    if (state?.searchQuery?.source == "home") {
      // console.log("Changed from hoome", state.searchQuery);
      // handleData()
      await handleData(pages[page] == 0 ? 1 : pages[page], limit);
    } else if (state?.searchQuery?.source == "advanced") {
      // console.log("Changed from advanced", state.searchQuery);
      // handleDataQ()
      await handleDataQ(pages[page] == 0 ? 1 : pages[page], limit);
    }
    // await handleData(pages[page] == 0 ? 1 : pages[page], limit)
  };

  // ====================
  const goNext = async () => {
    if (total == 0) {
      alert("No next page");
    }
    setPage(pages[page] + limit > total ? 0 : page + 1);
    if (state?.searchQuery?.source == "home") {
      // console.log("Changed from hoome", state.searchQuery);
      // handleData()
      await handleData(pages[page] == 0 ? 1 : pages[page], limit);
    } else if (state?.searchQuery?.source == "advanced") {
      // console.log("Changed from advanced", state.searchQuery);
      // handleDataQ()
      await handleDataQ(pages[page] == 0 ? 1 : pages[page], limit);
    }
    // await handleData(pages[page] == 0 ? 1 : pages[page], limit)
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
                defaultValue={
                  typeof state?.searchQuery.query === "string"
                    ? state?.searchQuery.query
                    : ""
                }
                ref={inputRef}
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
            <div className={styles.total}>Total: {total}</div>
            <Link href="/advanced-search" passHref>
              <div className={styles.advanced}>Advanced Search</div>
            </Link>
          </div>
        </div>
        <div className={styles.result}>
          {results?.length > 0 ? (
            results.map((res, i) => <ResultBox key={i} data={res} />)
          ) : (
            <div className={styles.noData}>
              No data... Try to tune your query:{" "}
              {state?.searchQuery?.source == "home"
                ? state?.searchQuery?.query
                : "Advanced Search"}
            </div>
          )}
        </div>
        <div>
          <button
            style={{
              padding: "0.5em 2em",
              marginRight: "1em",
            }}
            onClick={goPrevious}
          >
            Previous
          </button>
          <button
            style={{
              padding: "0.5em 2em",
              marginRight: "1em",
            }}
            onClick={() => goNext()}
          >
            Next
          </button>
          <span>Page: {page + 1}</span>
        </div>
      </div>
    </div>
  );
};

export default Result;

// let results = [];

// const results = [
//   {
//     name: "SimpleOOP.ecore",
//     size: "3k",
//     createdAt: "Jul 17th 2021",
//     description:
//       " The model is typically represented as a database or object model, and the various aspects of the system are represented by relationships between objects in the model. MDA has been used extensively in the software engineering community, particularly in areas such as design and verification.",
//     storageUrl:
//       "http://178.238.238.209:3201/file/metamodels/SimpleOOP-1651518206305-59.ecore",
//   },
//   {
//     name: "Person.ecore",
//     size: "1.2k",
//     createdAt: "Jun 19th 2021",
//     description:
//       "This approach has several benefits, including improved clarity and consistency of the code, reduced complexity and cost, and improved maintainability.",
//     storageUrl:
//       "http://178.238.238.209:3201/file/metamodels/Person-1651518310371-43.ecore",
//   },
//   {
//     name: "ControllerUML.ecore",
//     size: "2.3k",
//     createdAt: "May 05th 2021",
//     description:
//       "The models are used to create a context for testing and validation, and to generate the code necessary to implement the system. MDA separates the specification of the system from its implementation, using models as a basis for design, test, and documentation.",
//     storageUrl:
//       "http://178.238.238.209:3201/file/metamodels/ControllerUML-1651518314958-25.ecore",
//   },
//   {
//     name: "Klaper.ecore",
//     size: "4.1k",
//     createdAt: "Jan 2nd 2021",
//     description:
//       "The models are used to create a context for testing and validation, and to generate the code necessary to implement the system. ",
//     storageUrl:
//       "http://178.238.238.209:3201/file/metamodels/Klaper-1651518321772-24.ecore",
//   },
//   {
//     name: "PetriNet.ecore",
//     size: "3.6k",
//     createdAt: "Jul 11th 2021",
//     description:
//       "Model driven architecture (MDA) is a software development process and design methodology that emphasizes models of the system being developed, as opposed to purely textual or procedural descriptions.",
//     storageUrl:
//       "http://178.238.238.209:3201/file/metamodels/PetriNet-1651518322912-96.ecore",
//   },
// ];
