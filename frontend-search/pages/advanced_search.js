import Image from "next/image";
import styles from "../styles/Advanced.module.scss";
import style from "../styles/Dropdown.module.scss";
import SearchRect from "../components/common/SearchRect";
import Button from "../components/common/Button";
import { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useRouter } from "next/router";
import ContextRow from "../components/common/ContextRow";
import SearchInput from "../components/common/SearchInput";
import PlusButton from "../components/PlusButton";
import FieldDiv from "../components/common/FieldDiv";
import DropDiv from "../components/common/DropDiv";
import { useRef } from "react";
import Modal from 'react-modal'

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
    REF: "Number of Total Reference",
    SF: "Number of Total eStructuralFeatures",
    CMC: "Number of concrete MetaClass",
    AMC: "Number of abstract MetaClass",
    MC: "Number of MetaClass",
    REF1: "Number of Total Reference",
    SF1: "Number of Total eStructuralFeatures",
    CMC1: "Number of concrete MetaClass",
    AMC1: "Number of abstract MetaClass",
    MC1: "Number of MetaClass",
    REF2: "Number of Total Reference",
    SF2: "Number of Total eStructuralFeatures",
    CMC2: "Number of concrete MetaClass",
    AMC2: "Number of abstract MetaClass",
    MC2: "Number of MetaClass",
  },
  size: {
    fieldwidth: 20,
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

const possibleTransData = {
  dropdown: {
    title: "Operator",
    metaTitle: "Operator",
    id: "ID",
    unique_name: "Artifact unique_name",
  },
  size: {
    fieldwidth: 10,
    dropwidth: 10,
    inputwidth: 10,
  },
};


// console.log(Qass.dropdown);

const Advanced = () => {

  const router = useRouter();

  const [isOpen, setIsOpen] = useState(false);
  const [isOpenQ, setIsOpenQ] = useState(false);
  const [isOpenOP, setIsOpenOP] = useState(false);
  const [isOpenT, setIsOpenT] = useState(false);


  const [item, setItem] = useState("");
  const [itemQ, setItemQ] = useState("");
  const [itemOP, setItemOP] = useState("");
  const [itemT, setItemT] = useState("");

  const [field, setField] = useState(true);
  const [fieldQ, setFieldQ] = useState(true);
  const [fieldOP, setFieldOP] = useState(true);
  const [fieldT, setFieldT] = useState(true);


  // Radio buttons
  const [allDate, setAllDate] = useState(true)
  const [specificDate, setSpecificDate] = useState(true)
  const [timeFrame, setTimeFrame] = useState(true)
  const [customFrame, setCustomFrame] = useState(true)

  // Dates
  const [date, setDate] = useState(new Date())
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date())
  const [period, setPeriod] = useState('');


  const searchInputRef = useRef()

  // console.log(isOpen);

  // const { dropdown, size } = data;

  // const { metaTitle } = dropdown;
  // const { fieldwidth, dropwidth } = size;

  let itemsSearch = Object.values(contextData.dropdown);

  itemsSearch = itemsSearch.filter(
    (item) =>
      item !== "All fields" &&
      item !== "Search in context"
  );
  // console.log(itemsSearch);

  let itemsQuality = Object.values(Qass.dropdown);
  itemsQuality = itemsQuality.filter(
    (item) =>
      item !== "Operator" &&
      item !== "Quality Assessment" &&
      item !== "Quality metrics / attributes"
  );

  let itemsOp = Object.values(opData.dropdown);
  itemsOp = itemsOp.filter(
    (item) =>
      item !== "Operator"
  );

  let itemsT = Object.values(possibleTransData.dropdown);
  itemsT = itemsT.filter(
    (item) =>
      item !== "Operator"
  );

  // Constructing the object
  const advancedObject = {
    searchContent: [
      {
        key: "",
        value: "",
      }
    ],
    qualityAssessment: [
      {
        key: "",
        operator: "",
        value: "",
      }
    ],
    optimalTransfo: {
      metamodelId: "",
    },
    publication: {

    }
  }

  const handleClick = () => {
    console.log(period, "***");
    // e.preventDefault();
    // router.push(`/result`);
    console.log(searchInputRef.current.value, Object.keys(contextData.dropdown).find(key => contextData.dropdown[key] === item));
  };

  const handleChange = (e) => {
    switch (e.target.id) {

      case 'all_date':
        setAllDate(true)
        setSpecificDate(true)
        setTimeFrame(true)
        setCustomFrame(true)
        break

      case 'datepub':
        setAllDate(false)
        setSpecificDate(false)
        setTimeFrame(true)
        setCustomFrame(true)
        break

      case 'timeframe':
        setAllDate(false)
        setSpecificDate(true)
        setTimeFrame(false)
        setCustomFrame(true)
        break

      case 'custom_timeframe':
        setAllDate(false)
        setSpecificDate(true)
        setTimeFrame(true)
        setCustomFrame(false)
        break
    }
  }

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.title}>Advanced Search</div>
        <form className={styles.contentSearch}>
          <div className={styles.search}>
            {/* <SearchContext data={contextData} /> */}
            {/* ===================== SEARCH CONTEXT ======================= */}
            <div className={styles.context}>
              <div className={styles.contextTitle}>{contextData.dropdown.title}</div>

              {/* ------Context Row---------- */}
              <ContextRow>
                <SearchRect>
                  {/* ------Dropdown ----------------- */}
                  {/* <Dropdown data={contextData} /> */}
                  <div>
                    {/* Field div------------------------------- */}
                    <FieldDiv id="react-modals" width={contextData.size.fieldwidth} onClick={(e) => {
                      setIsOpen(!isOpen);
                    }}>
                      <div className={style.container}>
                        <div className={style.field}>{field ? contextData.dropdown.metaTitle : item}</div>
                        <div

                          className={isOpen ? style.rotate : style.dropImage}
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
                    {/* Modal---------------------------------- */}
                    <Modal
                      isOpen={isOpen}
                      onRequestClose={() => { setIsOpen(false) }}
                      shouldCloseOnOverlayClick={true}
                      ariaHideApp={false}
                      style={
                        {
                          overlay: {
                            backgroundColor: 'rgba(0,0,0,0.4)'
                          },
                          content: {
                            // color: 'orange',
                            width: '20%',
                            height: '40%',
                            margin: 'auto',

                          }
                        }
                      }
                    >

                      <h3>Select a field</h3>
                      <div style={{}}>
                        {
                          itemsSearch.map((item, i) => (

                            <div
                              className={style.item}
                              key={i}
                              onClick={(e) => {
                                setIsOpen(!isOpen);
                                setItem(item);
                                setField(false);
                              }}
                            >
                              {item}
                            </div>
                          ))}

                      </div>

                      <Button
                        style={{
                          padding: ".2em 1em",
                          fontSize: '0.9em',
                          marginTop: '1em'
                        }}
                        onClick={() => { setIsOpen(!isOpen); }} search>
                        Close

                      </Button>
                    </Modal>

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
            {/* ||===================== SEARCH CONTEXT =================END======|| */}
            {/* ==================== Quality assessement ==================== */}
            {/* <SearchContext data={Qass} /> */}
            <div className={styles.context}>
              <div className={styles.contextTitle}>{Qass.dropdown.title}</div>

              <ContextRow>
                <SearchRect>
                  <div>
                    <FieldDiv width={Qass.size.fieldwidth}
                      onClick={() => {
                        setIsOpenQ(!isOpenQ);
                      }}
                    >
                      <div className={style.container}>
                        <div className={style.field}>{fieldQ ? Qass.dropdown.metaTitle : itemQ}</div>
                        <div

                          className={isOpenQ ? style.rotate : style.dropImage}
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
                    <Modal
                      isOpen={isOpenQ}
                      onRequestClose={() => { setIsOpenQ(false) }}
                      shouldCloseOnOverlayClick={true}
                      ariaHideApp={false}
                      style={
                        {
                          overlay: {
                            backgroundColor: 'rgba(0,0,0,0.4)'
                          },
                          content: {
                            // color: 'orange',
                            width: '30%',
                            height: '50%',
                            margin: 'auto',

                          }
                        }
                      }
                    >

                      <h3>Select quality parameter</h3>
                      <div
                        style={{
                          height: '80%',
                          overflowY: 'scroll',
                          overflowX: 'hidden',
                          marginTop: '1em'
                        }}>
                        {
                          itemsQuality.map((item_, i) => (
                            <div
                              className={style.item}
                              key={i}
                              onClick={(e) => {
                                setIsOpenQ(!isOpenQ);
                                setItemQ(item_);
                                setFieldQ(false);
                              }}
                            >
                              {item_}
                            </div>
                          ))}
                      </div>

                      <Button
                        style={{
                          padding: ".2em 1em",
                          fontSize: '0.9em',
                          marginTop: '1em'
                        }}
                        onClick={() => { setIsOpenQ(!isOpenQ); }} search>
                        Close
                      </Button>
                    </Modal>
                  </div>
                  {/* ---------Operator dropdown-------- */}
                  {/* <Dropdown data={opData} /> */}
                  <div>
                    <FieldDiv width={opData.size.fieldwidth}>
                      <div className={style.container}>
                        <div className={style.field}>{fieldOP ? opData.dropdown.metaTitle : itemOP}</div>
                        <div
                          onClick={() => {
                            setIsOpenOP(!isOpenOP);
                          }}
                          className={isOpenOP ? style.rotate : style.dropImage}
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
                    <DropDiv width={opData.size.dropwidth}>
                      {isOpenOP &&
                        itemsOp.map((item_op, i) => (
                          <div
                            className={style.item}
                            key={i}
                            onClick={(e) => {
                              setIsOpenOP(!isOpenOP);
                              setItemOP(item_op);
                              setFieldOP(false);
                            }}
                          >
                            {item_op}
                          </div>
                        ))}
                    </DropDiv>
                  </div>
                  <SearchInput
                    type="text"
                    placeholder="Value"
                    width={opData.size.inputwidth}
                  />
                </SearchRect>
                <PlusButton />
              </ContextRow>
            </div>
            {/* ||==================== Quality assessement ===========END=========|| */}
            {/* ===================== Possible transformations===================== */}
            {/* <PossibleTransformation /> */}
            <div className={styles.transformations}>
              <div className={styles.title}>Possible Transformation</div>
              <SearchRect>
                <FieldDiv width={10}>Metamodel</FieldDiv>
                {/* <Dropdown data={possibleTransData} /> */}
                <div>
                  <FieldDiv width={possibleTransData.size.fieldwidth}>
                    <div className={style.container}>
                      <div className={style.field}>{fieldT ? possibleTransData.dropdown.metaTitle : itemT}</div>
                      <div
                        onClick={() => {
                          setIsOpenT(!isOpenT);
                        }}
                        className={isOpenT ? style.rotate : style.dropImage}
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
                  <DropDiv width={possibleTransData.size.dropwidth}>
                    {isOpenT &&
                      itemsT.map((item_t, i) => (
                        <div
                          className={style.item}
                          key={i}
                          onClick={(e) => {
                            setIsOpenT(!isOpenT);
                            setItemT(item_t);
                            setFieldT(false);
                          }}
                        >
                          {item_t}
                        </div>
                      ))}
                  </DropDiv>
                </div>
                <SearchInput
                  type="text"
                  placeholder="Enter selected field..."
                  width={possibleTransData.size.inputwidth}
                />
              </SearchRect>
            </div>
          </div>
          {/* ||===================== Possible transformations=======END==============|| */}



          {/* ====================== THE DIVIDER ======================= */}

          <div className={styles.bar}>
            <div className={styles.gray}></div>
            <div className={styles.bluefish}></div>
          </div>

          {/* ====================== PUBLICATION =======================  */}
          <div className={styles.publication}>
            <div className={styles.pubTitle}>Publication date:</div>
            <div className={styles.titleDatePub}>
              <input type="radio" id="all_date" name="fav_language" value="HTML" style={{ marginRight: ".5em" }} onChange={handleChange} checked={allDate} />
              <label htmlFor="html">All dates</label>
            </div>
            <div className={styles.titleDatePub}>
              <input type="radio" id="datepub" name="fav_language" value="HTML" style={{ marginRight: ".5em" }} onChange={handleChange} />
              <label htmlFor="html">Specific date</label>
              <DatePicker
                selected={date}
                onChange={(date) => setDate(date)}
                timeInputLabel="Time:"
                dateFormat="MM-dd-yyyy h:mm aa"
                // dateFormat="MM/dd/yyyy"
                showTimeInput
                readOnly={specificDate}
                className={styles.boxDate}
              />
            </div>
            <div className={styles.titleDatePub}>
              <input type="radio" id="timeframe" name="fav_language" value="HTML" style={{ marginRight: ".5em" }} onChange={handleChange} />
              <label className={styles.recentOption} htmlFor="html">
                Last
              </label>
              <br />
              <select name="deityName" className={styles.boxDate} disabled={timeFrame} onChange={(e) => setPeriod(e.target.value)}>
                <option className={styles.option}>Select timeframe</option>
                <option className={styles.option}>7 days</option>
                <option className={styles.option}>Month</option>
                <option className={styles.option}>6 months</option>
                <option className={styles.option}>1 Year</option>
              </select>
            </div>
            <div className={styles.titleDatePub}>
              <input type="radio" id="custom_timeframe" name="fav_language" value="HTML" style={{ marginRight: ".5em" }} onChange={handleChange} />
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
                  readOnly={customFrame}
                />
              </div>
              <div className={styles.to}>
                <label>To:</label>
                <DatePicker
                  selected={endDate}
                  onChange={(date) => setEndDate(date)}
                  timeInputLabel="Time:"
                  dateFormat="MM-dd-yyyy h:mm aa"
                  // dateFormat="MM/dd/yyyy"
                  showTimeInput
                  className={styles.fromToBox}
                  readOnly={customFrame}
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

