import { useEffect, useRef, useState } from "react";

function RenderCheck(props) {
  // 훅 use
  // useState : 상태 저장.
  // useRef : 값 기억 (렌더링 X)
  // useEffect : 렌더링 후 실행.
  const [inputValue, setInputValue] = useState("");
  const count = useRef(0);

  useEffect(() => {
    count.current = count.current + 1;
  });

  return (
    <>
      <p>입력 필드:</p>
      <input type="text" value={inputValue} onChange={(e) => setInputValue(e.target.value)} />
      <h1>렌더링 횟수: {count.current}</h1>
    </>
  );
}

export default RenderCheck;
