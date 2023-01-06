import axios from 'axios'
import React, { useEffect, useMemo, useRef, useState } from 'react'
import styles from '../styles/OpEditor.module.scss'
import FieldDiv from './common/FieldDiv'
import SearchInput from './common/SearchInput'
import Dropdown from './Dropdown'
import { formatXml } from "../adhoc/formatXml";
import { debounce } from "lodash";
// ----------------------------------------------------------------
import dynamic from "next/dynamic";
import { useAppContext } from '../context/AppContext'



const CodeMirror = dynamic(
    async () => {
        await import("codemirror/lib/codemirror.css");
        await import("codemirror/mode/xml/xml");
        await import("codemirror/theme/material.css");
        //await import("codemirror/theme/cobalt.css");
        await import("codemirror/addon/search/match-highlighter");
        await import("codemirror/mode/javascript/javascript");
        await import("codemirror/mode/css/css");
        return import("react-codemirror");
    },
    { ssr: false }
);


const opData = {
    dropdown: {
        title: "Operator",
        metaTitle: "Input type",
        id: "ID",
        unique_name: "Artifact unique_name",
    },
    size: {
        fieldwidth: 10,
        dropwidth: 10,
        inputwidth: 25,
    },
};

const OpEditor = ({ artifact, onChangeSourceM }) => {

    const { state, dispatch } = useAppContext();
    const artifactRef = useRef();
    const [content, setContent] = useState("");
    const [name, setName] = useState("");
    const [input, setInput] = useState("")

    const language = artifact?.includes("script") ? "" : "xml"


    const handler = useMemo(
        () => debounce((value) => setContent(value), 1000),
        [content]
    );

    const handleInput = (value) => {
        setInput(value)
        // console.log(value, "clicked....");
        // setInput(value)
    }

    const c = "code-mirror-wrapper"

    const getUrl = () => {
        switch (artifact) {

            case "Source model":
                return {
                    url: "http://178.238.238.209:3200/store/artifact/model/",
                    type: "source_m",
                    extension: ".xmi"
                };

            case "Source metamodel":
                return {
                    url: "http://178.238.238.209:3200/store/artifact/metamodel/",
                    type: "source_mm",
                    extension: ".ecore"
                };

            case "Target metamodel":
                return {
                    url: "http://178.238.238.209:3200/store/artifact/metamodel/",
                    type: "target_mm",
                    extension: ".ecore"
                };

            case "ETL Script":
                return {
                    url: "http://178.238.238.209:3200/store/artifact/script/",
                    type: "script",
                    extension: ".etl"
                };

            case "EVL Script":
                return {
                    url: "http://178.238.238.209:3200/store/artifact/script/",
                    type: "script",
                    extension: ".evl"
                };

            case "EOL Script":
                return {
                    url: "http://178.238.238.209:3200/store/artifact/script/",
                    type: "script",
                    extension: ".eol"
                };

            default:
                return "";
        }
    }

    useEffect(() => {
        // console.log(content);
        let { type, extension } = getUrl(artifactRef.current.value)
        dispatch({
            type, value: {
                name:
                    name ? name : `UserInput${extension}`, content
            }
        });
    }, [content])
    //


    // A function that makes a request to the backend to get the artifact with axios and await the artifact
    const getArtifact = async () => {
        try {
            setContent(null)
            const inputVal = artifactRef.current.value;
            if (!inputVal | !input) {
                alert("Please Select Input Type")
                return;
            }

            const { url } = getUrl(artifact);
            let returnedData = {}
            if (input == "ID") {
                // console.log(inputVal);
                returnedData = await axios.get(`${url}${inputVal}`);
            }
            else if (input == "Artifact unique_name")
                returnedData = await axios.get(`${url}${"unique_name"}`, { params: { unique_name: inputVal } });
            else if (input === 'Input type') {
                alert("Please select input type")
                return
            }

            const data_ = returnedData.data

            setContent(data_.returnedData.content);
            setName(data_.returnedData.name);

            return data_.returnedData;
        } catch (error) {
            console.log(error);
            alert("Failed to fetch the artifact, \nPlease check input type and try again!");

        }

    }



    return (
        <div className={styles.container}>
            <div className={styles.searchRect}>
                <FieldDiv width={10}>{artifact}</FieldDiv>
                <Dropdown data={opData} handleInput={handleInput} />
                <SearchInput
                    type="text"
                    placeholder="Enter selected field..."
                    width={opData.size.inputwidth}
                    ref={artifactRef}
                />
                <button onClick={getArtifact}>Import</button>
            </div>


            <div className={styles.editor}>
                {content ? <CodeMirror
                    className={`${c}`}
                    onBeforeChange={(editor, data, value) => {

                    }}

                    onChange={(editor, data, value) => {
                        handler(editor);
                    }}

                    value={artifact.includes("script") ? content : formatXml(content)}
                    options={{
                        lineWrapping: true,
                        lint: true,
                        mode: language,
                        // theme: "cobalt",
                        lineNumbers: true,
                        autoRefresh: true
                    }}
                /> : <div>
                    <CodeMirror
                        className={`${c}`}
                        onBeforeChange={(editor, data, value) => {
                        }}

                        onChange={(editor, data, value) => {
                            // setContent(editor)
                            handler(editor);
                        }}

                        value={""}
                        options={{
                            lineWrapping: true,
                            lint: true,
                            mode: language,
                            // theme: "cobalt",
                            lineNumbers: true,
                            autoRefresh: true
                        }}
                    /></div>}
            </div>
        </div>
    )
}

export default OpEditor
