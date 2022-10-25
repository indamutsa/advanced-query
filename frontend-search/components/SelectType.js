import Image from "next/image";
import { useState } from "react";
import FieldDiv from "./common/FieldDiv";
import styles from "../styles/Dropdown.module.scss";
import DropDiv from "./common/DropDiv";
import { useAppContext } from "../context/AppContext";



const SelectType = ({ data }) => {
    // UseContext when using useReducer
    const { state, dispatch } = useAppContext();

    const [isOpen, setIsOpen] = useState(true);
    const [item, setItem] = useState("");
    const [field, setField] = useState(true);
    const [updatedItems, setUpdatedItems] = useState([])
    const { dropdown, size } = data;

    const { metaTitle } = dropdown;
    const { fieldwidth, dropwidth } = size;

    let items = Object.values(dropdown);
    // items = items.filter(
    //     (item) =>
    //         item !== "All fields" &&
    //         item !== "Search in context" &&
    //         item !== "Operator" &&
    //         item !== "Quality Assessment" &&
    //         item !== "Quality metrics / attributes" &&
    //         item !== "Choose a service..."
    // );

    return (
        <div>
            <FieldDiv width={fieldwidth}>
                <div className={styles.container}>
                    <div className={styles.field}>{field ? metaTitle : item}</div>
                    <div
                        onClick={() => {
                            setIsOpen(!isOpen);
                            items[0] = "Select All"
                            setUpdatedItems(items)
                        }}
                        className={isOpen ? styles.dropImage : styles.rotate}
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
            <DropDiv width={dropwidth}>
                {!isOpen &&
                    updatedItems.map((item, i) => (
                        <div
                            className={styles.item}
                            key={i}
                            onClick={(e) => {
                                setIsOpen(!isOpen);
                                setItem(item);
                                dispatch({ type: "type", value: item });
                                setField(false);
                            }}
                        >
                            {item}
                        </div>
                    ))}
            </DropDiv>
        </div>
    );
};

export default SelectType;
