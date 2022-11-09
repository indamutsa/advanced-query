import Image from "next/image";
import styles from "../styles/Advanced.module.scss";
import style from "../styles/Dropdown.module.scss";
import SearchContext from "../components/SearchContext";
import SearchRect from "../components/common/SearchRect";
import PossibleTransformation from "../components/PossibleTransformation";
import Button from "../components/common/Button";
import { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useRouter } from "next/router";
import ContextRow from "../components/common/ContextRow";
import Dropdown from "../components/Dropdown";
import SearchInput from "../components/common/SearchInput";
import PlusButton from "../components/PlusButton";
import FieldDiv from "../components/common/FieldDiv";
import DropDiv from "../components/common/DropDiv";
import { useRef } from "react";

const contextData = {
  dropdown: {
    title: "Search in context",
    metaTitle: "All fields",
    name: "Name",
    unique_name: "Unique name",
    desc: "Description",
    ext: "Extension",
    accessControl: "Access control",
    content: "Content",
    type: "Type",
    size: "Size",
  },
  size: {
    fieldwidth: 16,
    dropwidth: 8,
    inputwidth: 22,
  },
};

const Qass = {
  dropdown: {
    title: "Quality Assessment",
    metaTitle: "Quality metrics / attributes",
    REF: "Number of TotalReference",
    SF: "Number of Total eStructuralFeatures",
    CMC: "Number of concrete MetaClass",
    AMC: "Number of abstract MetaClass",
    MC: "Number of MetaClass",
  },
  size: {
    fieldwidth: 16,
    dropwidth: 16,
    inputwidth: 22,
  },
};

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

const Advanced = () => {
  const [startDate, setStartDate] = useState(new Date());
  const router = useRouter();
  const [isOpen, setIsOpen] = useState(true);
  const [item, setItem] = useState("");
  const [field, setField] = useState(true);
  const searchInputRef = useRef()

  // const { dropdown, size } = data;

  // const { metaTitle } = dropdown;
  // const { fieldwidth, dropwidth } = size;

  let items = Object.values(contextData.dropdown);
  items = items.filter(
    (item) =>
      item !== "All fields" &&
      item !== "Search in context" &&
      item !== "Operator" &&
      item !== "Quality Assessment" &&
      item !== "Quality metrics / attributes" &&
      item !== "Choose a service..."
  );


  const handleClick = () => {
    // e.preventDefault();
    // router.push(`/result`);
    console.log(searchInputRef.current.value, Object.keys(contextData.dropdown).find(key => contextData.dropdown[key] === item));
  };

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.title}>Advanced Search</div>
        <form className={styles.contentSearch}>
          <div className={styles.search}>
            {/* <SearchContext data={contextData} /> */}
            <div className={styles.context}>
              <div className={styles.contextTitle}>{contextData.dropdown.title}</div>

              {/* ------Content Row---------- */}
              <ContextRow>
                <SearchRect>
                  {/* ------Dropdown ----------------- */}
                  {/* <Dropdown data={contextData} /> */}
                  <div>
                    <FieldDiv width={contextData.size.fieldwidth}>
                      <div className={style.container}>
                        <div className={style.field}>{field ? contextData.dropdown.metaTitle : item}</div>
                        <div
                          onClick={(e) => {
                            setIsOpen(!isOpen);
                            console.log(e.target.value);
                          }}
                          className={isOpen ? style.dropImage : style.rotate}
                        >
                          <Image
                            src="/image/dropdown.svg"
                            alt=""
                            height="22px"
                            width="22px"
                          />
                        </div>
                      </div>
                    </FieldDiv>
                    <DropDiv width={contextData.size.dropwidth}>
                      {!isOpen &&
                        items.map((item, i) => (
                          <div
                            className={style.item}
                            key={i}
                            onClick={(e) => {
                              setIsOpen(!isOpen);
                              setItem(item);
                              setField(false);
                              // The function below inside 
                            }}
                          >
                            {item}
                          </div>
                        ))}
                    </DropDiv>
                  </div>
                  <SearchInput
                    type="text"
                    placeholder="Search a field"
                    width={contextData.size.inputwidth}
                    ref={searchInputRef}
                  />
                </SearchRect>
                <PlusButton />
              </ContextRow>

            </div>
            <SearchContext data={Qass} />
            {/* -------- Possible transformations------------ */}
            <PossibleTransformation />
          </div>
          <div className={styles.bar}>
            <div className={styles.gray}></div>
            <div className={styles.bluefish}></div>
          </div>
          <div className={styles.publication}>
            <div className={styles.pubTitle}>Publication date:</div>
            <div className={styles.titleDatePub}>
              <input type="radio" id="html" name="fav_language" value="HTML" /> {" "}
              <label htmlFor="html">All dates</label>
            </div>
            <div className={styles.titleDatePub}>
              <input type="radio" id="html" name="fav_language" value="HTML" /> {" "}
              <label htmlFor="html">Specific date</label>
              <DatePicker
                selected={startDate}
                onChange={(date) => setStartDate(date)}
                timeInputLabel="Time:"
                dateFormat="MM-dd-yyyy h:mm aa"
                // dateFormat="MM/dd/yyyy"
                showTimeInput
                className={styles.boxDate}
              />
            </div>
            <div className={styles.titleDatePub}>
              <input type="radio" id="html" name="fav_language" value="HTML" /> {" "}
              <label className={styles.recentOption} htmlFor="html">
                Last
              </label>
              <br />
              <select name="deityName" className={styles.boxDate}>
                <option className={styles.option}>7 days</option>
                <option className={styles.option}>Month</option>
                <option className={styles.option}>6 months</option>
                <option className={styles.option}>1 Year</option>
              </select>
            </div>
            <div className={styles.titleDatePub}>
              <input type="radio" id="html" name="fav_language" value="HTML" /> {" "}
              <label htmlFor="html">Custom range:</label>
              <div className={styles.from}>
                <label>From:</label>
                <DatePicker
                  selected={startDate}
                  onChange={(date) => setStartDate(date)}
                  timeInputLabel="Time:"
                  dateFormat="MM-dd-yyyy h:mm aa"
                  // dateFormat="MM/dd/yyyy"
                  showTimeInput
                  className={styles.fromToBox}
                />
              </div>
              <div className={styles.to}>
                <label>To:</label>
                <DatePicker
                  selected={startDate}
                  onChange={(date) => setStartDate(date)}
                  timeInputLabel="Time:"
                  dateFormat="MM-dd-yyyy h:mm aa"
                  // dateFormat="MM/dd/yyyy"
                  showTimeInput
                  className={styles.fromToBox}
                />
              </div>
            </div>
          </div>
        </form>
        <div className={styles.bottomView}>
          <div className={styles.instruction}>
            <div className={styles.title}>Instruction</div>
            <p className={styles.text}>
              MDEForge is a cloud-based repository for model artifacts that
              supports advanced query mechanisms and provides collaborative
              features for sharing, reusing and executing transformations on
              model artifacts. <br />
              <br />
              MDEForge uses the MDEForge Query engine to provide powerful search
              capabilities. The repository can be accessed through various APi
              specifications and through a web interface. It supports artifact
              peristence operations, model management services, search and it is
              tuned to support machine learning techniques.
            </p>
          </div>
          <div className={styles.buttons}>
            <Button style={{ marginRight: "20px" }}>Reset</Button>

            <Button onClick={handleClick} search>
              Search
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Advanced;


// dispatch gets the key by the value
//                                 dispatch({
//                                   type: "advanced", value: {
//                                     key: Object.keys(dropdown).find(key => dropdown[key] === item)
//                                   }
//                                 })


{/* <div className={styles.context}>
              <div className={styles.contextTitle}>{contextData.dropdown.title}</div>

              <ContextRow>
                {contextData?.dropdown?.title === "Search in context" && (
                  <SearchRect>
                    <Dropdown data={contextData} />
                    <SearchInput
                      type="text"
                      placeholder="Search a field"
                      width={contextData.size.inputwidth}
                    />
                  </SearchRect>
                )}

                {contextData?.dropdown?.title === "Quality Assessment" && (
                  <SearchRect>
                    <Dropdown data={contextData} />
                    <Dropdown data={opData} />
                    <SearchInput
                      type="text"
                      placeholder="Value"
                      width={contextData.size.inputwidth}
                    />
                  </SearchRect>
                )}
                <PlusButton />
              </ContextRow>
            </div> */}



{/* --------Quality assessemnt block------------ */ }
{/* {contextData?.dropdown?.title === "Quality Assessment" && (
                  <SearchRect>
                    <Dropdown data={contextData} />
                    <Dropdown data={opData} />
                    <SearchInput
                      type="text"
                      placeholder="Value"
                      width={contextData.size.inputwidth}
                    />
                  </SearchRect>
                )} */}