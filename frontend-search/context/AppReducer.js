export const initialState = {
  number: 0,
  str: "",
  dataType: "SELECT ALL",
  letter: "All",
  item: {},
  content: "",
  refreshed: 1,
  data: {}
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
      return {
        ...state,
        item: action.value
      }
    }

    case "content": {
      return {
        ...state,
        content: action.value.content,
        data: action.value
      }
    }

    case "refreshed": {
      return {
        ...state,
        refreshed: state.refreshed + 1
      }
    }

  }
};
