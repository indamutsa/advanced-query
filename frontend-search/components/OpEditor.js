import React, { useRef } from 'react'
import styles from '../styles/OpEditor.module.scss'
import FieldDiv from './common/FieldDiv'
import SearchInput from './common/SearchInput'
import SearchRect from './common/SearchRect'
import Dropdown from './Dropdown'
import Editor from './Editor'

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

const OpEditor = () => {
    const artifactRef = useRef();
    return (
        <div className={styles.container}>
            <div className={styles.searchRect}>
                <FieldDiv width={10}>Source model</FieldDiv>
                <Dropdown data={opData} />
                <SearchInput
                    type="text"
                    placeholder="Enter selected field..."
                    width={opData.size.inputwidth}
                    ref={artifactRef}
                />
                <button>Import</button>
            </div>


            <div className={styles.editor}>
                <Editor
                    // height={"100px"}
                    language="xml"
                // value={formatXml(artifact)}
                // onChange={setArtifact}
                />
            </div>
        </div>

    )
}

export default OpEditor
