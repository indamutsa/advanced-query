export const initialState = {
  number: 0,
  str: "",
  dataType: "all"
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
      console.log(action.value);
    }
  }
};
