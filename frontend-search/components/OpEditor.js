import axios from 'axios'
import React, { useEffect, useMemo, useRef, useState } from 'react'
import styles from '../styles/OpEditor.module.scss'
import FieldDiv from './common/FieldDiv'
import SearchInput from './common/SearchInput'
import Dropdown from './Dropdown'
import Editor from './Editor'
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
        name: "Artifact name",
        unique_name: "Artifact unique_name",
        file: "Upload a file",
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
    const [content, setContent] = useState(artifact.content);
    const language = "xml"

    const handler = useMemo(
        () => debounce((value) => setContent(value), 1000),
        [content]
    );



    const c = "code-mirror-wrapper"

    const getUrl = () => {
        switch (artifact) {
            case "Source model":
                return {
                    url: "http://178.238.238.209:3200/store/artifact/model/",
                    type: "source_m"
                };
            case "Source metamodel":
                return {
                    url: "http://178.238.238.209:3200/store/artifact/metamodel/",
                    type: "source_mm"
                };
            case "Target metamodel":
                return {
                    url: "http://178.238.238.209:3200/store/artifact/metamodel/",
                    type: "target_mm"
                };
            case "Script":
                return {
                    url: "http://178.238.238.209:3200/store/artifact/script/",
                    type: "script"
                };
            default:
                return "";
        }
    }

    useEffect(() => {
        // console.log(content);
        let { type } = getUrl(artifactRef.current.value)
        dispatch({ type, value: content });
    }, [content])


    // A function that makes a request to the backend to get the artifact with axios and await the artifact
    const getArtifact = async () => {
        content = null;
        const id = artifactRef.current.value;
        if (id === "") return;
        const { url } = getUrl(artifact);

        const { data } = await axios.get(`${url}${id}`);
        setContent(data.returnedData.content);

        return data.returnedData;
    }

    const containerEditor = `<div>ksdjdksf</div>`

    return (
        <div className={styles.container}>
            <div className={styles.searchRect}>
                <FieldDiv width={10}>{artifact}</FieldDiv>
                <Dropdown data={opData} />
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

                    value={formatXml(content)}
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
                            setContent(editor)
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
