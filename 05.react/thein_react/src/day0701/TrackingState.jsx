import React, { useEffect } from "react";

function TrackingState(props) {
  const [inputValue, setInputValue] = React.useState("");
  const previousInputValue = React.useRef("");

  useEffect(() => {
    previousInputValue.current = inputValue;
  }, [inputValue]);

  return (
    <>
      <input type="text" value={inputValue} onChange={(e) => setInputValue(e.target.value)} />
      <p>Current Value: {inputValue}</p>
      <p>Previous Value: {previousInputValue.current}</p>
    </>
  );
}

export default TrackingState;
