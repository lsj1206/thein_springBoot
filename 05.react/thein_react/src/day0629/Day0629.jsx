import MyApp from "./MyApp";
import Garage from "./Garage";
import MyForm from "./ch08/MyForm";
import MyList from "./ch08/MyList";
import MyTable from "./ch08/MyTable";
import "./Day0629.css";

export default function Day0629() {
  return (
    <section className="day-section day0629" aria-labelledby="day0629-title">
      <h2 id="day0629-title">Day 0629</h2>
      <div className="example-grid">
        <article className="example-panel">
          <h3>Components and props</h3>
          <MyApp />
        </article>
        <article className="example-panel">
          <h3>Garage</h3>
          <Garage />
        </article>
        <article className="example-panel">
          <h3>List and table</h3>
          <MyList />
          <MyTable />
        </article>
        <article className="example-panel">
          <h3>Form</h3>
          <MyForm />
        </article>
      </div>
    </section>
  );
}