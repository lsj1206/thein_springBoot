import { createRoot } from "react-dom/client";
import App from "./App.jsx";
import { Provider } from "react-redux";
import { store } from "./store.js";
import { BrowserRouter } from "react-router-dom";
import Nav from "./Nav.jsx";

createRoot(document.getElementById("root")).render(
  // 전체 앱에서 Redux 사용 가능하게 설정
  <Provider store={store}>
    <BrowserRouter>
      <Nav />
      <App />
    </BrowserRouter>
  </Provider>,
);
