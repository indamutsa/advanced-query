import styles from "../styles/Advanced.module.scss";
import SearchContext from "../components/SearchContext";
import SearchRect from "../components/common/SearchRect";
import PossibleTransformation from "../components/PossibleTransformation";
import Button from "../components/common/Button";
import { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const contextData = {
  dropdown: {
    title: "Search in context",
    metaTitle: "All fields",
    name: "Name",
    unique_name: "Unique name",
    desc: "Description",
    ext: "Extension",
  },
  size: {
    fieldwidth: 16,
    dropwidth: 16,
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

const Advanced = () => {
  const [startDate, setStartDate] = useState(new Date());

  const handleClick = () => {
    e.preventDefault();
    router.push(`/result`);
  };

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.title}>Advanced Search</div>
        <div className={styles.contentSearch}>
          <div className={styles.search}>
            <SearchContext data={contextData} />
            <SearchContext data={Qass} />
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
        </div>
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
