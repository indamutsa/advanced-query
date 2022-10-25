import styles from "../styles/ItemPaginate.module.scss";
// import data from "../data/data.json";
import { useState } from "react";
import ReactPaginate from "react-paginate";

const ItemPaginate = ({ data }) => {
  const items = data;

  const [pageNumber, setPageNumber] = useState(0);


  const handleClick = (e) => {
    e.preventDefault();
    console.log("hello world");
    // Dispatch url, and the name
    // navigate to model-view
  }

  const itemsPerPage = 119;
  const pagesVisited = pageNumber * itemsPerPage;
  const displayItems = items
    .slice(pagesVisited, pagesVisited + itemsPerPage)
    .map((item, i) => {
      return (
        <div key={i} className={styles.item}>
          &#8226;
          <a onClick={handleClick}>{item.name}</a>
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
