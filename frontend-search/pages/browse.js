import PageTitle from "../components/common/PageTitle";
import ItemPaginate from "../components/ItemPaginate";
import Letter from "../components/Letter";
import styles from "../styles/Browse.module.scss";
const browse = () => {
  return (
    <div className={styles.container}>
      <div className={styles.upperContent}>
        <PageTitle>Browse model artifacts</PageTitle>

        <div className={styles.alphabets}>
          <div className={styles.title}>Alphabetical</div>
          <Letter />
        </div>
      </div>
      <div className={styles.bottomContent}>
        <ItemPaginate />
      </div>
    </div>
  );
};

export default browse;
