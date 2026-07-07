import "./day0701.css";
import AccessDom from "./AccessDom";
import RenderCheck from "./RenderCheck";
import TrackingState from "./TrackingState";
import MyUseReduser from "./MyUseReduser";
import WithoutCallback from "./WithoutCallback";
import WithCallback from "./WithCallback";
import MyUseMemo from "./MyUseMemo";
import useMyHook from "./useMyHook";

const Day0701 = () => {
  const [data] = useMyHook("https://jsonplaceholder.typicode.com/todos");
  return (
    <>
      <RenderCheck />
      <hr />
      <AccessDom />
      <hr />
      <TrackingState />
      <hr />
      <MyUseReduser />
      <hr />
      <WithoutCallback />
      <hr />
      <WithCallback />
      <hr />
      <MyUseMemo />
      <hr />
      {data &&
        data.map((item) => {
          return (
            <p key={item.id}>
              {item.id} : {item.title}
            </p>
          );
        })}
    </>
  );
};

export default Day0701;
