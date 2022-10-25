import { useEffect, useState } from "react";
import { nextLocalStorage } from "./nextLocalStorage";
const PREFIX = `model-edit`;

// Anytime we update or refresh the browser, we save it in the localstorage
export default function useLocalStorage(key, initialValue) {
  const prefixKey = PREFIX + key;
  const [value, setValue] = useState(() => {
    const jsonValue = nextLocalStorage().getItem(prefixKey);
    if (jsonValue) return JSON.parse(jsonValue);
    if (typeof initialValue === "function") return initialValue();
    else return initialValue;
  });

  useEffect(() => {
    nextLocalStorage()?.setItem(prefixKey, JSON.stringify(value));
  }, [prefixKey, value]);
  return [value, setValue];
}
