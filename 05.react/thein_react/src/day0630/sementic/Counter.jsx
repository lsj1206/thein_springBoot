import { useState } from "react";

function Counter() {
  const [count, setCount] = useState(0);
  const calculation = count * 2;

  return (
    <>
      <p>Count: {count}</p>
      <button onClick={() => setCount((currentCount) => currentCount + 1)}>+</button>
      <p>Calculation: {calculation}</p>
    </>
  );
}

export default Counter;