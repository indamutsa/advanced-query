import Head from "next/head";
import Home from "../components/Home";

// This is the main entry but wrapped in the Layout container
export default function Index() {
  return (
    <div>
      <Head>
        <title>MDEForge Search Facility</title>
        <meta name="description" content="Search MDEForge artifacts" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <Home />
    </div>
  );
}
