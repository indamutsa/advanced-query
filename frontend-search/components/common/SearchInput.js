import styled from "styled-components";

const SearchInput = styled.input`
  width: ${(props) => props.width}em; //22em;
  border: 0;
  padding-left: 0.8em;
  padding-right: 0.8em;
  color: rgba(0, 0, 0, 0.671);
  font-size: 0.8rem;
  font-family: "Roboto Mono", monospace;

  :focus {
    outline: none;
  }

  ::placeholder {
    color: #00000068;
  }
`;

export default SearchInput;
