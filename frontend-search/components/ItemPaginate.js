import styles from "../styles/ItemPaginate.module.scss";
// import data from "../data/data.json";
import { useState } from "react";
import ReactPaginate from "react-paginate";
import { useAppContext } from "../context/AppContext";
import { useRouter } from "next/router";

const ItemPaginate = ({ data }) => {
  const items = data;
  const { state, dispatch } = useAppContext();
  const router = useRouter();
  const [pageNumber, setPageNumber] = useState(0);


  const handleClick = (e, item) => {
    e.preventDefault();
    dispatch({ type: "item", value: item })
    // navigate to model-view
    router.push('/artifact-display')
  }

  const itemsPerPage = 119;
  const pagesVisited = pageNumber * itemsPerPage;
  const displayItems = items
    .slice(pagesVisited, pagesVisited + itemsPerPage)
    .map((item, i) => {
      return (
        <div key={i} className={styles.item}>
          &#8226;
          <a onClick={e => handleClick(e, item)}>{item.name}</a>
        </div>
      );
    });

  const pageCount = Math.ceil(items.length / itemsPerPage);

  const changePage = ({ selected }) => {
    // console.log(selected);
    setPageNumber(selected);
  };

  return (
    <div>
      <div className={styles.items}>{displayItems}</div>
      <div className={styles.pagination}>
        <ReactPaginate
          previousLabel={"Prev"}
          nextLabel={"Next"}
          pageCount={pageCount}
          onPageChange={changePage}
          containerClassName={styles.paginateContainer}
          previousLinkClassName={styles.previousItem}
          nextLinkClassName={styles.nextItem}
          activeClassName={styles.activeItem}
        />
      </div>
    </div>
  );
};

export default ItemPaginate;
