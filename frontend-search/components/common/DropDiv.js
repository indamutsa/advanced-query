import styled from "styled-components";

const DropDiv = styled.div`
  position: absolute;
  background-color: white;
  border: 0.03em solid #ccc;
  width: ${(props) => props.width}em;
  z-index: 100;
`;

export default DropDiv;
