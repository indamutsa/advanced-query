import styled from "styled-components";

const Button = styled.button`
  background-color: ${(props) =>
    props.search ? `rgba(43, 90, 105, 1)` : `rgba(196, 196, 196, 1)`};
  border-radius: 18.21px;
  padding-top: 0.5em;
  padding-bottom: 0.5em;
  padding-left: 1.6em;
  padding-right: 1.6em;
  font-weight: 600;
  font-size: 1.1em;
  color: ${(props) => (props.search ? `#fff` : `#000`)};
  cursor: pointer;
  left: 0;
  outline: none;
  border: 0.5px solid rgba(0, 0, 0, 0.2);
  font-family: "Roboto Mono";
  &:hover {
    filter: brightness(1.2);
    transition: all 0.4s;
    border-radius: 8.21px;
    border: 1px solid rgba(0, 0, 0, 0.8);
  }
`;

export default Button;
