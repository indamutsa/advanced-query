export const initialState = {
  number: 0,
  str: "",
  searchQuery: "",
  dataType: "SELECT ALL",
  letter: "All",
  item: {},
  content: "",
  refreshed: 1,
  data: {},
  service: "",
  operationResult: "",
  advancedSearch: {

  },
  source_m: "",
  source_mm: "",
  target_mm: "",
  script: "",

};

export const appReducer = (state, action) => {
  switch (action.type) {
    case "init_stored": {
      return action.value;
    }

    case "search-query": {
      // state.str = action.value;
      return {
        ...state,
        searchQuery: action.value,
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

    case "service": {
      return {
        ...state,
        service: action.value
      }
    }

    case "source_m": {
      console.log(action.value);
      return {
        ...state,
        source_m: action.value
      }
    }

    case "source_mm": {
      return {
        ...state,
        source_mm: action.value
      }
    }

    case "target_mm": {
      return {
        ...state,
        target_mm: action.value
      }
    }

    case "script": {
      return {
        ...state,
        script: action.value
      }
    }

    case "operationResult": {
      return {
        ...state,
        operationResult: action.value
      }
    }
  }
};
