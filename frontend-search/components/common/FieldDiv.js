import styled from "styled-components";

const FieldDiv = styled.div`
  color: rgb(0, 0, 0);
  font-family: "Roboto Mono", monospace;
  font-size: 0.8em;
  font-weight: 400;
  font-style: normal;
  min-width: ${(props) => props.width}em;
  border: 0.03em solid #ccc;
  background-color: rgba(0, 0, 0, 0.05);
  /* padding-top: 0.2em; */
  /* padding-bottom: 0.2em; */
  padding-left: 1em;
  padding-right: 0.5em;
  position: relative;
`;

export default FieldDiv;
