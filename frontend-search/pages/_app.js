import "@fortawesome/fontawesome-svg-core/styles.css"; // import Font Awesome CSS
import { config } from "@fortawesome/fontawesome-svg-core";
import "codemirror/lib/codemirror.css";

config.autoAddCss = false;

import Layout from "../components/Layout";
import "../styles/globals.scss";

// import store from "../redux/store";
// import { Provider } from "react-redux";

function MyApp({ Component, pageProps }) {
  return (
    // <Provider store={store}>
    <Layout>
      <Component {...pageProps} />
    </Layout>
    // </Provider>
  );
}

export default MyApp;
