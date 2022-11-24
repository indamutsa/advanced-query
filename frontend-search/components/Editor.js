import dynamic from "next/dynamic";
import React from "react";

const CodeMirror = dynamic(
  async () => {
    await import("codemirror/lib/codemirror.css");
    await import("codemirror/mode/xml/xml");
    await import("codemirror/theme/material.css");
    //await import("codemirror/theme/cobalt.css");
    await import("codemirror/addon/search/match-highlighter");
    await import("codemirror/mode/javascript/javascript");
    await import("codemirror/mode/css/css");
    return import("react-codemirror");
  },
  { ssr: false }
);

const Editor = (props) => {
  const { language, value, onChange, style } = props;
  const c = "code-mirror-wrapper"

  // console.log(value);

  const handleChange = (e) => {
    onChange(value);
  };

  return (
    <CodeMirror
      className={`${style ? style : c}`}
      onBeforeChange={handleChange}
      onChange={(editor, metadata, value) => {
        onChange(value);
      }}
      value={value}
      options={{
        lineWrapping: true,
        lint: true,
        mode: language,
        // theme: "cobalt",
        lineNumbers: true,
      }}
    />
  );
};

export default Editor;
