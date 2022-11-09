import styled from "styled-components";

const DropDiv = styled.div`
  position: absolute;
  background-color: #c6c6c6;
  border: 0.03em solid #ccc;
  width: ${(props) => props.width}em;
  z-index: 100;
  cursor: pointer;
`;

export default DropDiv;
