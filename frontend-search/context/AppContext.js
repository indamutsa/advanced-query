import {
  createContext,
  useContext,
  useMemo,
  useReducer,
  useEffect,
  useState,
} from "react";
import { appReducer, initialState } from "./AppReducer";

// Using both the Contextapi and the reducer
// =========================================
const AppContext = createContext();

export function AppProvider({ children }) {
  // We replace the useState with useReducer
  const [state, dispatch] = useReducer(appReducer, initialState);

  const contextValue = useMemo(() => {
    return { state, dispatch };
  }, [state, dispatch]);

  return (
    <AppContext.Provider value={contextValue}>{children}</AppContext.Provider>
  );
}

export function useAppContext() {
  return useContext(AppContext);
}

// When using the localstorage
// *******************************************
// export function AppProvider({ children }) {
//   // We replace the useState with useReducer
//   const [state, dispatch] = useReducer(appReducer, initialState);

//   // Updating the value with the one in localstorage
//   useEffect(() => {
//     if (JSON.parse(localStorage.getItem("state"))) {
//       //checking if there already is a state in localstorage
//       dispatch({
//         type: "init_stored",
//         value: JSON.parse(localStorage.getItem("state")),
//         //if yes, update the current state with the stored one
//       });
//     }
//   }, []);

//   //Setting the new value with the upcoming one
//   useEffect(() => {
//     if (state !== initialState) {
//       localStorage.setItem("state", JSON.stringify(state));
//       //create and/or set a new localstorage variable called "state"
//     }
//   }, [state]);

//   const contextValue = useMemo(() => {
//     return { state, dispatch };
//   }, [state, dispatch]);

//   return (
//     <AppContext.Provider value={contextValue}>{children}</AppContext.Provider>
//   );
// }

// Using a single reducer
// ==========================
// export function AppWrapper({ children }) {
//   const [appState, setAppState] = useState({});
//   const contextValue = useMemo(() => {
//     return [appState, setAppState];
//   }, [appState, setAppState]);

//   return (
//     <AppContext.Provider value={contextValue}>{children}</AppContext.Provider>
//   );
// }

// export function useAppContext() {
//   return useContext(AppContext);
// }

// For multiple state with the context value
// ==========================================
// export function AppWrapper({ children }) {
//   const [appState, setAppState] = useState({});
//   const [app, setApp] = useState({});
//   const contextValue = useMemo(() => {
//     return [appState, setAppState];
//   }, [appState, setAppState]);

//   const contentValue = useMemo(() => {
//     return [app, setApp];
//   }, [app, setApp]);

//   return (
//     <AppContext.Provider value={{ appState, setAppState, app, setApp }}>
//       {children}
//     </AppContext.Provider>
//   );
// }

// export function useAppContext() {
//   return useContext(AppContext);
// }

// Calling them in the app context
//*********************************** */
// For multiple state with the context
// const { appState, setAppState, app, setApp } = useAppContext();

// For single state with contextApi
// const [appState, setAppState] = useAppContext();

// console.log(appState, "App state is not absolute");
