import styled from "styled-components";
const width = 41;

const SearchRect = styled.div`
  display: flex;
  align-items: center;
  justify-content: flex-start;
  //   margin-top: 0.2em;
  min-height: 1em;
  /* margin-right: 0.1em; */
  box-shadow: 1px 1px 1px 3px #00000040;
  min-width: ${(props) => (props.width ? props.width : `${width}em`)}; //45em;
  max-width: ${(props) => (props.width ? props.width : `${width}em`)}; //45em;
`;

export default SearchRect;
