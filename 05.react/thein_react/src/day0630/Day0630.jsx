import MyApp from "./MyApp";
import Tictactoe from "./Tictactoe";
import "./Day0630.css";

export default function Day0630() {
  return (
    <section className="day-section day0630" aria-labelledby="day0630-title">
      <h2 id="day0630-title">Day 0630</h2>
      <div className="example-grid">
        <article className="example-panel">
          <h3>State and effects</h3>
          <MyApp />
        </article>
        <article className="example-panel example-panel-wide">
          <h3>Tic-tac-toe</h3>
          <Tictactoe />
        </article>
      </div>
    </section>
  );
}