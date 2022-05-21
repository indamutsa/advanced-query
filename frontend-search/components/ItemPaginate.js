import styles from "../styles/ItemPaginate.module.scss";
import data from "../data/data.json";
import { useState } from "react";
import ReactPaginate from "react-paginate";

const ItemPaginate = () => {
  const items = data;
  const [pageNumber, setPageNumber] = useState(0);

  const itemsPerPage = 119;
  const pagesVisited = pageNumber * itemsPerPage;
  const displayItems = items
    .slice(pagesVisited, pagesVisited + itemsPerPage)
    .map((item, i) => {
      return (
        <div key={i} className={styles.item}>
          &#8226; {item.name}
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
