import Head from "next/head";
import Home from "../components/Home";
import { getData } from "../services";

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

// export const getStaticProps = async () => {
//   // Call data from here
//   let data = await getData();
//   // console.log("hello");
//   data = {
//     hello: "world",
//   };

//   return {
//     props: { data: data }, // will be passed to the page component as props
//   };
// };
