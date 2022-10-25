import PageTitle from "../components/common/PageTitle";
import ItemPaginate from "../components/ItemPaginate";
import Letter from "../components/Letter";
<<<<<<< HEAD
import SelectType from "../components/SelectType";
import styles from "../styles/Browse.module.scss";
import finalData from "../data/final-data.json"
import { useAppContext } from "../context/AppContext";




const opData = {
  dropdown: {
    // title: "Select Type",
    metaTitle: "Select Type",
    model: "Model",
    metamodel: "Metamodel",
    dsl: "DSL",
  },
  size: {
    fieldwidth: 15,
    dropwidth: 12,
    inputwidth: 12,
  },
};


const browse = ({ data }) => {
  const { state, dispatch } = useAppContext();

  data = data.filter(el => {
    if (state.letter === "All") return true
    return el.name.charAt(0) === state.letter
  });

  // console.log(data[0]);
  data = data.filter(el => {
    if (state.dataType === "SELECT ALL") return true
    if (el.type === state.dataType) return true
    else return false
  });

  // console.log(state);
  return (
    <div className={styles.container}>
      <div className={styles.upperContent}>
        <div className={styles.upperTitles}>

          <PageTitle>Browse model artifacts</PageTitle>
          <SelectType data={opData} />
        </div>
=======
import styles from "../styles/Browse.module.scss";
const browse = () => {
  return (
    <div className={styles.container}>
      <div className={styles.upperContent}>
        <PageTitle>Browse model artifacts</PageTitle>
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b

        <div className={styles.alphabets}>
          <div className={styles.title}>Alphabetical</div>
          <Letter />
        </div>
      </div>
      <div className={styles.bottomContent}>
<<<<<<< HEAD
        <ItemPaginate data={data} />
=======
        <ItemPaginate />
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
      </div>
    </div>
  );
};

export default browse;
<<<<<<< HEAD



// This function gets called at build time on server-side.
// It may be called again, on a serverless function, if
// revalidation is enabled and a new request comes in
export async function getStaticProps() {
  // console.log(finalData.length);

  return {
    props: {
      data: finalData
    },
    // Next.js will attempt to re-generate the page:
    // - When a request comes in
    // - At most once every 10 seconds
    revalidate: 10, // In seconds
  }
}



// This gets called on every request
// export async function getServerSideProps() {
//   // Fetch data from external API
//   const res = await fetch(`http://localhost:3300/search-all`)
//   const data = await res.json()



//   // Pass data to the page via props
//   return { props: { dataN: data.data } }
// }



// const [data, setData] = useState([]);
//   const args = {
//     idx: 3
//   }



//   useEffect(() => {
//     const fetcher = async () => {
//       try {
//         let res = await axios.post(`http://localhost:3300/search-all`, args);
//         let { data } = res.data;
//         console.log(data);

//         let processedData = data.map(element => {
//           let newData = {};
//           newData.id = element.id;
//           newData.name = element.data.name
//           newData.storageUrl = element.data.storageUrl
//           return newData;

//         });

//         setData(processedData)
//         // console.log(data.length);
//       } catch (error) {
//         console.log(error);
//       }
//     }

//     fetcher()
//   }, [])



=======
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
