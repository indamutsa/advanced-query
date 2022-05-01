import React, { useState } from "react";
import PageTitle from "../components/common/PageTitle";
import styles from "../styles/ModelEdit.module.scss";
import dynamic from "next/dynamic";
import Button from "../components/common/Button";
const Editor = dynamic(import("../components/Editor"), { ssr: false });
import { formatXml } from "../adhoc/formatXml";

const ModelEdit = () => {
  const initialValue =
    '<?xml version="1.0" encoding="ISO-8859-1"?> <xmi:XMI xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore"> <ecore:EPackage name="Automatoon"> <eClassifiers xsi:type="ecore:EClass" name="FiniteAutomaton"> <eStructuralFeatures xsi:type="ecore:EAttribute" name="alphabet" ordered="false" unique="false" upperBound="-1" eType="/1/String"/> <eStructuralFeatures xsi:type="ecore:EReference" name="transitionSet" ordered="false" upperBound="-1" eType="/0/Transition"/> <eStructuralFeatures xsi:type="ecore:EReference" name="initialState" ordered="false" lowerBound="1" eType="/0/State"/> <eStructuralFeatures xsi:type="ecore:EReference" name="finalStateSet" ordered="false" lowerBound="1" upperBound="-1" eType="/0/State"/> <eStructuralFeatures xsi:type="ecore:EReference" name="StateSet" ordered="false" upperBound="-1" eType="/0/State"/> </eClassifiers> <eClassifiers xsi:type="ecore:EClass" name="Transition"> <eStructuralFeatures xsi:type="ecore:EAttribute" name="letter" ordered="false" unique="false" lowerBound="1" eType="/1/String"/> <eStructuralFeatures xsi:type="ecore:EReference" name="source" ordered="false" lowerBound="1" eType="/0/State"/> <eStructuralFeatures xsi:type="ecore:EReference" name="target" ordered="false" lowerBound="1" eType="/0/State"/> </eClassifiers> <eClassifiers xsi:type="ecore:EClass" name="State"> <eStructuralFeatures xsi:type="ecore:EAttribute" name="name" ordered="false" unique="false" lowerBound="1" eType="/1/String"/> <eStructuralFeatures xsi:type="ecore:EReference" name="combination" ordered="false" lowerBound="1" eType="/0/State"/> </eClassifiers> </ecore:EPackage> <ecore:EPackage name="PrimitiveTypes"> <eClassifiers xsi:type="ecore:EDataType" name="String"/> <eClassifiers xsi:type="ecore:EDataType" name="Integer"/> </ecore:EPackage> </xmi:XMI>';
  const [artifact, setArtifact] = useState(initialValue);
  formatXml(artifact);
  return (
    <div className={styles.container}>
      <PageTitle>
        Name: <span>SimpleOOP.ecore</span>
      </PageTitle>
      <div className={styles.editor}>
        <Editor
          language="xml"
          value={formatXml(artifact)}
          onChange={setArtifact}
        />
      </div>
      <div className={styles.buttons}>
        <Button style={{ marginRight: "20px", padding: "5px 25px" }}>
          Reset
        </Button>
        <Button style={{ padding: "5px 25px" }} search>
          Update
        </Button>
      </div>
    </div>
  );
};

export default ModelEdit;
