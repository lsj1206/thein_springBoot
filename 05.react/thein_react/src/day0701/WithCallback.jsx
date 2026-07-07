// using useCallback example
import React, { useCallback, useState } from "react";

const Button = React.memo(({ onClick, text }) => {
  console.log(`${text} 렌더, useCallback`);
  return <button onClick={onClick}>{text}</button>;
});

function WithCallback() {
  const [count1, setCount1] = useState(0);
  const [count2, setCount2] = useState(0);

  const handleClick1 = useCallback(() => {
    setCount1(count1 + 1);
  }, [count1]);

  const handleClick2 = useCallback(() => {
    setCount2(count2 + 1);
  }, [count2]);

  console.log("parent 렌더, useCallback");
  return (
    <div>
      <h2>With useCallback: </h2>
      <p>브라우저 콘솔 확인.</p>
      <p>Count 1: {count1}</p>
      <p>Count 2: {count2}</p>
      <Button text="Button 1" onClick={handleClick1} />
      <Button text="Button 2" onClick={handleClick2} />
    </div>
  );
}

export default WithCallback;
