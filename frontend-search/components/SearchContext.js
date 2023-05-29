import styles from "../styles/Advanced.module.scss";
import SearchRect from "../components/common/SearchRect";
import Dropdown from "./Dropdown";
import ContextRow from "./common/ContextRow";
import PlusButton from "./PlusButton";
import SearchInput from "./common/SearchInput";
import { useAppContext } from "../context/AppContext";

const opData = {
  dropdown: {
    title: "Operator",
    metaTitle: "Operator",
    gt: "greater than",
    lt: "less than",
    gte: "greater than or equal",
    lte: "less than or equal",
  },
  size: {
    fieldwidth: 10,
    dropwidth: 10,
    inputwidth: 5,
  },
};

const SearchContext = ({ data }) => {
  const { state, dispatch } = useAppContext();
  const { dropdown, size } = data;
  const { title } = dropdown;
  const { inputwidth } = size;


  return (
    <div className={styles.context}>
      <div className={styles.contextTitle}>{title}</div>

      <ContextRow>
        {title === "Search in context" && (
          <SearchRect>
            <Dropdown data={data} />
            <SearchInput
              type="text"
              placeholder="Search a field"
              width={inputwidth}
              onChange={(e) => dispatch({
                type: "advanced", value: {
                  value: e.target.value
                }
              })}
            />
          </SearchRect>
        )}

        {title === "Quality Assessment" && (
          <SearchRect>
            <Dropdown data={data} />
            <Dropdown data={opData} />
            <SearchInput
              type="text"
              placeholder="Value"
              width={opData.size.inputwidth}
            />
          </SearchRect>
        )}
        <PlusButton />
      </ContextRow>
    </div>
  );
};

export default SearchContext;
