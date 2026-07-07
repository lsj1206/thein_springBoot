import Header from "./components/Header";
import Footer from "./components/Footer";
import Day0701 from "./day0701/Day0701";

export default function App() {
  return (
    <div className="app-shell">
      <Header />
      <main className="day-list">
        {/* <Day0629 /> */}
        {/* <Day0630 /> */}
        <Day0701 />
      </main>
      <Footer />
    </div>
  );
}
