import { useSelector, useDispatch } from "react-redux";
import { increase, decrease } from "./counterSlice";
import { useState } from "react";
import { addTodo, deleteTodo } from "./todoSlice";

function MyRedux() {
  // -------- 카운터---상태 읽기
  const count = useSelector((state) => state.counter.value);
  // -------- 카운터---상태 변경 요청
  const dispatch = useDispatch();

  // --- 할일 목록 --- 상태 관리
  const [text, setText] = useState("");
  // --- 할일 목록 --- 상태 읽기
  const todos = useSelector((state) => state.todo.list);
  // --- 할일 목록 --- store 변경 요청
  const todoDispatch = useDispatch();
  // --- 할일 목록 --- 목록추가 함수
  const handleAdd = () => {
    if (text === "") return;
    todoDispatch(addTodo(text));
    setText("");
  };

  return (
    <>
      <h1>{count}</h1>
      <button onClick={() => dispatch(increase())}>더하기</button>
      <button onClick={() => dispatch(decrease())}>빼기</button>
      <hr />

      <h1>할 일 목록</h1>
      <p>
        목록입력: <input value={text} onChange={(e) => setText(e.target.value)} autoFocus />
      </p>
      <br />
      <button type="text" onClick={handleAdd}>
        추가
      </button>
      {todos.map((todo) => (
        <div key={todo.id}>
          {todo.text}
          <button onClick={() => todoDispatch(deleteTodo(todo.id))}>삭제</button>
        </div>
      ))}
    </>
  );
}

export default MyRedux;
