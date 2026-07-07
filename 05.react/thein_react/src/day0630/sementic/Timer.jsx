import { useEffect, useState } from "react";

function Timer() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    const timer = setTimeout(() => {
      setCount((currentCount) => currentCount + 1);
    }, 1000);

    return () => clearTimeout(timer);
  }, [count]);

  return <h3>{count} seconds</h3>;
}

export default Timer;