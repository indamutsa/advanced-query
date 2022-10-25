export const initialState = {
  number: 0,
<<<<<<< HEAD
  str: "",
  dataType: "SELECT ALL",
  letter: "All"
=======
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
};

export const appReducer = (state, action) => {
  switch (action.type) {
    case "init_stored": {
      return action.value;
    }

    case "add_number": {
<<<<<<< HEAD
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
=======
      return {
        ...state,
        number: action.value + state.number,
      };
    }
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
  }
};
