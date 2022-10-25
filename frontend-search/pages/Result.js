import styles from "../styles/Result.module.scss";
import Image from "next/image";
import ResultBox from "../components/ResultBox";
import Link from "next/link";
import { useRouter } from "next/router";
import { useAppContext } from "../context/AppContext";
<<<<<<< HEAD
import { useRef, useState } from "react";
import { getData } from "../services";

const Result = () => {
  const router = useRouter();
  const inputRef = useRef();
  const [results, setResults] = useState([]);

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

  const handleSubmit = async (e) => {
    e.preventDefault();

    let searchQuery = inputRef.current.value;
    let res = await getData(searchQuery);
    setResults(res.query.data);
=======

const results = [
  {
    name: "SimpleOOP.ecore",
    size: "3k",
    date: "Jul 17th 2021",
    description:
      " The model is typically represented as a database or object model, and the various aspects of the system are represented by relationships between objects in the model. MDA has been used extensively in the software engineering community, particularly in areas such as design and verification.",
    link: "http://178.238.238.209:3201/file/metamodels/SimpleOOP-1651518206305-59.ecore",
  },
  {
    name: "Person.ecore",
    size: "1.2k",
    date: "Jun 19th 2021",
    description:
      "This approach has several benefits, including improved clarity and consistency of the code, reduced complexity and cost, and improved maintainability.",
    link: "http://178.238.238.209:3201/file/metamodels/Person-1651518310371-43.ecore",
  },
  {
    name: "ControllerUML.ecore",
    size: "2.3k",
    date: "May 05th 2021",
    description:
      "The models are used to create a context for testing and validation, and to generate the code necessary to implement the system. MDA separates the specification of the system from its implementation, using models as a basis for design, test, and documentation.",
    link: "http://178.238.238.209:3201/file/metamodels/ControllerUML-1651518314958-25.ecore",
  },
  {
    name: "Klaper.ecore",
    size: "4.1k",
    date: "Jan 2nd 2021",
    description:
      "The models are used to create a context for testing and validation, and to generate the code necessary to implement the system. ",
    link: "http://178.238.238.209:3201/file/metamodels/Klaper-1651518321772-24.ecore",
  },
  {
    name: "PetriNet.ecore",
    size: "3.6k",
    date: "Jul 11th 2021",
    description:
      "Model driven architecture (MDA) is a software development process and design methodology that emphasizes models of the system being developed, as opposed to purely textual or procedural descriptions.",
    link: "http://178.238.238.209:3201/file/metamodels/PetriNet-1651518322912-96.ecore",
  },
];

const Result = () => {
  const router = useRouter();

  // UseContext when using useReducer
  const { state, dispatch } = useAppContext();
  const { number } = state;
  // console.log(number);

  const handleSubmit = (e) => {
    e.preventDefault();
    router.push(`/result`);
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
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
<<<<<<< HEAD
                ref={inputRef}
=======
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
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
          {results.map((res, i) => (
            <ResultBox key={i} data={res} />
          ))}
        </div>
      </div>
    </div>
  );
};

export default Result;
