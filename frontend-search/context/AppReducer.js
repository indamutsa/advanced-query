export const initialState = {
  number: 0,
  str: "",
  dataType: "SELECT ALL",
  letter: "All",
  item: {}
};

export const appReducer = (state, action) => {
  switch (action.type) {
    case "init_stored": {
      return action.value;
    }

    case "add_number": {
      state.str = action.value;
      return {
        ...state,
        // number: action.value + state.number,
      };
    }

    case "type": {
      return {
        ...state,
        dataType: action.value
      }
    }

    case "letter": {
      return {
        ...state,
        letter: action.value
      }
    }

    case "item": {
      console.log(action.value);


      return {
        ...state,
        item: action.value
      }
    }
  }
};
