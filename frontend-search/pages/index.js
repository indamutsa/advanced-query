import Head from "next/head";
import Home from "../components/Home";
<<<<<<< HEAD
import { getData } from "../services";

export default function Index({ data }) {
=======

export default function Index() {
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
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
<<<<<<< HEAD

export const getStaticProps = async () => {
  // Call data from here
  let data = await getData();
  // console.log("hello");
  data = {
    hello: "world",
  };

  return {
    props: { data: data }, // will be passed to the page component as props
  };
};
=======
>>>>>>> 16c76e983f7dcafb1cc32e315dbdee0664a8522b
