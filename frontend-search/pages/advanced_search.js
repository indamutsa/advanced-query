import Image from "next/image";
import styles from "../styles/Advanced.module.scss";
import style from "../styles/Dropdown.module.scss";
import SearchRect from "../components/common/SearchRect";
import Button from "../components/common/Button";
import { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useRouter } from "next/router";
import ContextRow from "../components/common/ContextRow";
import SearchInput from "../components/common/SearchInput";
import PlusButton from "../components/PlusButton";
import FieldDiv from "../components/common/FieldDiv";
import DropDiv from "../components/common/DropDiv";
import { useRef } from "react";
import Modal from 'react-modal';
import { debounce } from "lodash";
import { useMemo } from "react";
import { getAdvancedSearchData } from "../services";
import metrics from "../data/qass";
import { useAppContext } from "../context/AppContext";

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
    fieldwidth: 10,
    dropwidth: 8,
    inputwidth: 30,
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
    inputwidth: 13,
  },
};

const opData = {
  dropdown: {
    title: "Operator",
    metaTitle: "Operator",
    eq: "equal",
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

const opDat = {
  dropdown: {
    AND: "AND",
    OR: "OR",
    NOT: "NOT",
  },
  size: {
    fieldwidth: 6,
    dropwidth: 5,
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
    inputwidth: 30,
  },
};

const getKeyByValue = (obj, value) => {
  return Object.keys(obj).filter(key => obj[key] === value)[0];
};

const getKeyByVal = (obj, value) => {
  return Object.keys(obj).filter(key => obj[key].name === value)[0];
};




export const ContextSearcher = ({ handleClick, i, size, handleInput }) => {

  const [isOpen, setIsOpen] = useState(false);
  const [item, setItem] = useState("");
  const [field, setField] = useState(true);

  const [isOpenOP, setIsOpenOP] = useState(false);
  const [itemOP, setItemOP] = useState(opDat.dropdown.AND);
  const [fieldOP, setFieldOP] = useState(true);

  const searchInputRef = useRef()

  const handler = useMemo(
    () => debounce((value) => handleInput(value), 250),
    [searchInputRef?.current?.value]
  );

  let itemsSearch = Object.values(contextData.dropdown);

  itemsSearch = itemsSearch.filter(
    (item) =>
      item !== "All fields" &&
      item !== "Search in context"
  );

  let itemsOp = Object.values(opDat.dropdown);
  itemsOp = itemsOp.filter(
    (item) =>
      item !== "Operator"
  );

  return (
    <div>
      {/* ------Context Row---------- */}
      <ContextRow>
        <SearchRect>
          {/* ------Dropdown ----------------- */}
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
                        searchInputRef.current.value = "";
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
          {/* ---------Operator dropdown-------- */}
          {/* <Dropdown data={opData} /> */}
          <div>
            <FieldDiv width={opDat.size.fieldwidth}
              onClick={() => {
                setIsOpenOP(!isOpenOP);
              }}
            >
              <div className={style.container}>
                <div className={style.field}>{fieldOP ? opDat.dropdown.AND : itemOP}</div>
                <div className={isOpenOP ? style.rotate : style.dropImage}
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
            <DropDiv width={opDat.size.dropwidth}>
              {isOpenOP &&
                itemsOp.map((item_op, i) => (
                  <div
                    className={style.item}
                    key={i}
                    onClick={(e) => {
                      setIsOpenOP(!isOpenOP);
                      setItemOP(item_op);
                      setFieldOP(false);
                      searchInputRef.current.value = "";
                    }}
                  >
                    {item_op}
                  </div>
                ))}
            </DropDiv>
          </div>
          <SearchInput
            type="text"
            placeholder="Search a field"
            width={contextData.size.inputwidth}
            ref={searchInputRef}
            onBlur={() =>
              handleInput({
                operator: itemOP,
                field: getKeyByValue(contextData.dropdown, item),
                value: searchInputRef.current.value,
                index: i
              })
            }
            onChange={() => {
              if (item == "") {
                alert("Please select a field first");
                searchInputRef.current.value = "";
              }
              else
                handleInput({
                  operator: itemOP,
                  field: getKeyByValue(contextData.dropdown, item),
                  value: searchInputRef.current.value,
                  index: i
                })

            }}
          />
        </SearchRect>

        {i === 0 || i == size - 1 ?
          (<PlusButton handleClick={handleClick} i={i} size={size} mk />) : ""}
      </ContextRow>

    </div>
  )
}

const QualitySearcher = ({ handleClick, i, size, handleInputQ }) => {

  const [isOpenQ, setIsOpenQ] = useState(false);
  const [isOpenOP, setIsOpenOP] = useState(false);
  const [itemQ, setItemQ] = useState("");
  const [itemOP, setItemOP] = useState("");
  const [fieldQ, setFieldQ] = useState(true);
  const [fieldOP, setFieldOP] = useState(true);

  const qualityInputRef = useRef()

  let itemsQuality = Object.values(metrics);
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

  const handler = useMemo(
    () => debounce((value) => handleInputQ(value), 250),
    [qualityInputRef?.current?.value]
  );

  return (
    <div>
      <ContextRow>
        <SearchRect>
          <div>
            <FieldDiv width={Qass.size.fieldwidth}
              onClick={() => {
                setIsOpenQ(!isOpenQ);
              }}
            >
              <div className={style.container}>
                <div className={style.field}>{fieldQ ? metrics.metaTitle : itemQ}</div>
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
                        setItemQ(item_.name);
                        setFieldQ(false);
                        qualityInputRef.current.value = "";
                      }}
                    >
                      {item_.name}
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
          <div>
            <FieldDiv width={opData.size.fieldwidth} onClick={() => {
              setIsOpenOP(!isOpenOP);
            }}>
              <div className={style.container}>
                <div className={style.field}  >{fieldOP ? opData.dropdown.metaTitle : itemOP}</div>
                <div

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
                      qualityInputRef.current.value = "";
                    }}
                  >
                    {item_op}
                  </div>
                ))}
            </DropDiv>
          </div>
          <SearchInput
            type="number"
            placeholder="Value"
            width={Qass.size.inputwidth}
            ref={qualityInputRef}
            onBlur={() =>
              handleInputQ({
                operator: itemOP,
                field: getKeyByVal(metrics, itemQ),
                value: qualityInputRef.current.value,
                index: i
              })
            }
            onChange={() => {
              if (itemQ == "" || itemOP == "" || itemOP == "Operator" || itemQ == "Quality metrics / attributes") {
                alert("Please select quality metric and operator first");
                qualityInputRef.current.value = "";
                return
              }
              else
                handleInputQ({
                  operator: itemOP,
                  field: getKeyByVal(metrics, itemQ),
                  value: qualityInputRef.current.value,
                  index: i
                })
            }}
          />
        </SearchRect>
        {/* <PlusButton handleClick={handleClick} i={i} /> */}
        {i === 0 || i == size - 1 ?
          (<PlusButton handleClick={handleClick} i={i} size={size} />) : ""}
      </ContextRow>
    </div>
  )
}

const OptimalTransfo = ({ getInput }) => {
  const [isOpenT, setIsOpenT] = useState(false);
  const [itemT, setItemT] = useState("");
  const [fieldT, setFieldT] = useState(true);

  const transInputRef = useRef();

  let itemsT = Object.values(possibleTransData.dropdown);
  itemsT = itemsT.filter(
    (item) =>
      item !== "Operator"
  );

  const handler = useMemo(
    () => debounce((value) => getInput(value), 500),
    [transInputRef?.current?.value]
  );

  return (
    <div className={styles.transformations}>
      <div className={styles.title}>Possible Transformation</div>
      <SearchRect>
        <FieldDiv width={10}>Metamodel</FieldDiv>
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
          ref={transInputRef}
          onChange={() => { getInput(transInputRef.current.value) }}
          onBlur={() => getInput(transInputRef.current.value)}
        />
      </SearchRect>
    </div>
  )
}

const SimpleList = ({ list, handleClick, handleInput }) => {
  const len = list.length
  return (
    <div>
      {list && list.map((Component, i) => (
        (<Component key={i} i={i} handleClick={handleClick} handleInput={handleInput} size={len} mk />)
      ))}
    </div>)
}

const SimpleListQ = ({ list, handleClick, handleInputQ }) => {
  const len = list.length
  return (
    <div>
      {list && list.map((Component, i) => (
        (<Component key={i} i={i} handleClick={handleClick} handleInputQ={handleInputQ} size={len} />)
      ))}
    </div>)
}

const dateToTimestamp = (date) => {
  return Date.parse(date);
}

const Advanced = () => {

  const router = useRouter();
  const { state, dispatch } = useAppContext();

  const [arrComp, setArrComp] = useState([ContextSearcher]);
  const [arraComp, setArraComp] = useState([QualitySearcher]);

  const [objArr, setObjArr] = useState([]);
  const [objArra, setObjArra] = useState([]);
  const [optimalMetamodel, setOptimalMetamodel] = useState("");



  // Radio buttons
  const [allDate, setAllDate] = useState(true)
  const [specificDate, setSpecificDate] = useState(true)
  const [timeFrame, setTimeFrame] = useState(true)
  const [customFrame, setCustomFrame] = useState(true)

  // Dates
  const [date, setDate] = useState(new Date())
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date())
  const [pubDate, setPubDate] = useState("all_date")

  const [value, setValue] = useState("all_date");
  const [key, setKey] = useState("all_date");

  let itemsSearch = Object.values(contextData.dropdown);
  itemsSearch = itemsSearch.filter(
    (item) =>
      item !== "All fields" &&
      item !== "Search in context"
  );

  let publication = {}

  // Constructing the object
  const advancedObject = {
    searchContext: [],
    qualityAssessment: [],
    optimalMetamodel: {
      metamodelId: "",
    },
    publication: {
      key,
      value,
    },
  }


  const handleClick = (i, mk) => {
    if (mk) {
      if (i === 0) {
        setArrComp([...arrComp, ContextSearcher]);
      } else if (arrComp.length > 0) {
        setArrComp(arrComp.filter((item, index) => index !== i));
        setObjArr(objArr.filter((item, index) => index !== i))
      }
    } else {
      if (i === 0) {
        setArraComp([...arraComp, QualitySearcher]);
      } else if (arraComp.length > 0) {
        setArraComp(arraComp.filter((item, index) => index !== i));
        setObjArra(objArra.filter((item, index) => index !== i))
      }
    }
  };

  const handleInput = (obj) => {
    replaceObject(obj)
    advancedObject.searchContext = objArr
  }

  // make a function that replace an element object with a key from an array
  const replaceObject = (obj) => {
    // Check if the object is already present in the array
    if (objArr.length === 0) {
      setObjArr([...objArr, obj])
      return
    }

    for (let i = 0; i < objArr.length; i++) {
      if (objArr[i].index === obj.index) {
        objArr[i] = obj
        let a = removeDuplicateObjects(objArr)
        setObjArr(a)
        // console.log("found----------", objArr);
        return
      } else {
        if (isDuplicate(obj, objArr)) {
          {
            let a = removeDuplicateObjects(objArr)
            setObjArr([...objArr, obj])
          }
          // console.log("not found=========", objArr);
        } else {
          let a = removeDuplicateObjects(objArr)
          setObjArr(a)
          // console.log(a);
          console.log("already in array");
        }
      }
    }
  }

  // make a function that removes duplicate objects from an array in javascript by object index
  function removeDuplicateObjects(arr) {
    // Create a new array to store the unique objects
    var uniqueArr = [];

    // Loop through the input array
    for (var i = 0; i < arr.length; i++) {
      // Get the current object
      var obj = arr[i];

      // Check if the object is already in the unique array
      var isUnique = uniqueArr.every(function (uniqueObj) {
        return uniqueObj.index !== obj.index;
      });

      // If the object is unique, add it to the unique array
      if (isUnique) {
        uniqueArr.push(obj);
      }
    }

    // Return the unique array
    return uniqueArr;
  }

  // write test for the above function


  function isDuplicate(obj, arr) {
    // Create a new array to store the unique objects
    let idx = arr.findIndex((item) => obj.index)
    return idx !== -1 ? true : false
  }

  const handleInputQ = (obj) => {
    replaceObjectQ(obj)
    advancedObject.qualityAssessment = objArra
  }

  const replaceObjectQ = (obj) => {
    // Check if the object is already present in the array
    if (objArra.length === 0) {
      setObjArra([...objArra, obj])
      return
    }

    for (let i = 0; i < objArra.length; i++) {
      if (objArra[i].index === obj.index) {
        objArra[i] = obj
        let a = removeDuplicateObjects(objArra)
        setObjArra(a)
        // console.log("found----------", objArra);
        return
      } else {
        if (isDuplicate(obj, objArra)) {
          {
            let a = removeDuplicateObjects(objArra)
            setObjArra([...objArra, obj])
          }
          // console.log("not found=========", objArra);
        } else {
          let a = removeDuplicateObjects(objArra)
          setObjArra(a)
          // console.log(a);
          console.log("already in array");
        }
      }
    }
  }

  const handleChange = (e) => {
    switch (e.target.id) {

      case 'all_date':
        setAllDate(true)
        setSpecificDate(true)
        setTimeFrame(true)
        setCustomFrame(true)

        setPubDate("all_date")
        setKey("all_date")
        setValue("all_date")

        publication.key = key
        publication.value = value
        advancedObject.publication = publication
        break

      case 'specific_date':
        setAllDate(false)
        setSpecificDate(false)
        setTimeFrame(true)
        setCustomFrame(true)

        setKey("specific_date")
        setValue(dateToTimestamp(date))

        publication.key = key
        publication.value = value
        advancedObject.publication = publication
        break

      case 'timeframe':
        setAllDate(false)
        setSpecificDate(true)
        setTimeFrame(false)
        setCustomFrame(true)

        setKey("timeframe")
        setValue("all_date")

        publication.key = key
        publication.value = value
        advancedObject.publication = publication
        break

      case 'custom_timeframe':
        setAllDate(false)
        setSpecificDate(true)
        setTimeFrame(true)
        setCustomFrame(false)

        setKey("custom_timeframe")
        setValue({
          startDate: dateToTimestamp(startDate),
          endDate: dateToTimestamp(endDate),
        })

        publication.key = key
        publication.value = value
        advancedObject.publication = publication
        break
    }
  }

  const getInput = (v) => {
    setOptimalMetamodel(v)
    advancedObject.optimalMetamodel = optimalMetamodel
  }

  const handleSubmit = async () => {

    if (dateToTimestamp(startDate) > dateToTimestamp(endDate)) {
      alert("Start date must be less than end date...")
    } else if (advancedObject.searchContext.length === 0 && advancedObject.qualityAssessment.length === 0 && advancedObject.publication.key === "all_date" && advancedObject.publication.value === "all_date") {
      alert("Please select at least one search criteria...")
    }

    else {
      // const data = await getAdvancedSearchData(advancedObject)
      // console.log(data, "data");
      // dispatch({ type: "SET_ADVANCED_SEARCH_DATA", payload: advancedObject })
      dispatch({
        type: "search-query", value: {
          query: advancedObject,
          source: "advanced"
        }
      })
      router.push("/result");
    }
  }

  useEffect(() => {
    setObjArr(objArr)
    setObjArra(objArra)
    advancedObject.searchContext = objArr
    advancedObject.qualityAssessment = objArra
    advancedObject.optimalMetamodel = optimalMetamodel
    advancedObject.publication.key = key
    advancedObject.publication.value = value
    // console.log(advancedObject, "advancedObject");
  }, [objArr, objArra, advancedObject, date, startDate, endDate, key, value])

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.title}>Advanced Search</div>
        <form className={styles.contentSearch}>
          <div className={styles.search}>
            {/* ===================== SEARCH CONTEXT ==============55========= */}

            <div className={styles.context}>
              <div className={styles.contextTitle}>{contextData.dropdown.title}</div>
              <SimpleList handleClick={handleClick} handleInput={handleInput} list={arrComp} mk />
              {arrComp.length > 1 && <hr style={{ marginTop: "1em" }} />}
            </div>
            {/* ||===================== SEARCH CONTEXT =================END======|| */}
            {/* ==================== Quality assessement ==================== */}
            <div className={styles.context}>
              <div className={styles.contextTitle}>{metrics.title}</div>
              <SimpleListQ handleClick={handleClick} handleInputQ={handleInputQ} list={arraComp} />
              {arraComp.length > 1 && <hr style={{ marginTop: "1em" }} />}
            </div>
            {/* ||==================== Quality assessement ===========END=========|| */}

            {/* ===================== Possible transformations===================== */}
            <OptimalTransfo getInput={getInput} />
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
              <input type="radio" id="all_date" name="fav_language" style={{ marginRight: ".5em" }} onChange={handleChange} checked={allDate} />
              <label htmlFor="html">All dates</label>
            </div>
            <div className={styles.titleDatePub}>
              <input type="radio" id="specific_date" name="fav_language" style={{ marginRight: ".5em" }} onChange={handleChange} />
              <label htmlFor="html">Specific date</label>
              <DatePicker
                selected={date}
                onChange={(date) => {
                  setDate(date)
                  // setPubDate(dateToTimestamp(date))

                  setKey("specific_date")
                  setValue(dateToTimestamp(date))

                  publication.key = key
                  publication.value = value
                  advancedObject.publication = publication

                }}
                timeInputLabel="Time:"
                dateFormat="MM-dd-yyyy h:mm aa"
                showTimeInput
                readOnly={specificDate}
                className={styles.boxDate}
              />
            </div>
            <div className={styles.titleDatePub}>
              <input type="radio" id="timeframe" name="fav_language" style={{ marginRight: ".5em" }} onChange={handleChange} />
              <label className={styles.recentOption} htmlFor="html">
                Last
              </label>
              <br />
              <select name="deityName" className={styles.boxDate} disabled={timeFrame} onChange={(e) => {
                setKey("timeframe")
                setValue(e.target.value)

                publication.key = key
                publication.value = value
                advancedObject.publication = publication
              }}>
                <option className={styles.option}>Select timeframe</option>
                <option className={styles.option}>7 days</option>
                <option className={styles.option}>Month</option>
                <option className={styles.option}>6 months</option>
                <option className={styles.option}>1 Year</option>
              </select>
            </div>
            <div className={styles.titleDatePub}>
              <input type="radio" id="custom_timeframe" name="fav_language" style={{ marginRight: ".5em" }} onChange={handleChange} />
              <label htmlFor="html">Custom range:</label>
              <div className={styles.from}>
                <label>From:</label>
                <DatePicker
                  selected={startDate}
                  onChange={(date) => {

                    // We can only go ahead if the start date is less than the end date
                    // or if the start date is equal to the end date
                    if (dateToTimestamp(startDate) < dateToTimestamp(endDate) || dateToTimestamp(startDate) === dateToTimestamp(endDate)) {
                      setStartDate(date)

                      setPubDate({
                        startDate: dateToTimestamp(startDate),
                        endDate: dateToTimestamp(startDate)
                      })
                      setKey("custom_timeframe")
                      setValue(pubDate)

                      publication.key = key
                      publication.value = value
                      advancedObject.publication = publication
                    }

                  }}
                  timeInputLabel="Time:"
                  dateFormat="MM-dd-yyyy h:mm aa"
                  showTimeInput
                  className={styles.fromToBox}
                  readOnly={customFrame}
                />
              </div>
              <div className={styles.to}>
                <label>To:</label>
                <DatePicker
                  selected={endDate}
                  onChange={(date) => {
                    setEndDate(date)
                    setPubDate({
                      startDate: dateToTimestamp(startDate),
                      endDate: dateToTimestamp(endDate),
                    })

                    setKey("custom_timeframe")
                    setValue(pubDate)

                    publication.key = key
                    publication.value = value
                    advancedObject.publication = publication

                  }}
                  timeInputLabel="Time:"
                  dateFormat="MM-dd-yyyy h:mm aa"
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

            <Button onClick={handleSubmit} search>
              Search
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Advanced;

