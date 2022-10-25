export const isBrowser = () => {
  return typeof window !== "undefined";
};

export const nextLocalStorage = () => {
  if (isBrowser()) {
    return window.localStorage;
  }
};
