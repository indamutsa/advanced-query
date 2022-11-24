import axios from "axios";

export default async function handler(req, res) {
    let dataArr = []
    let id1 = 0;

    let data = await fetcher({ idx1: 1, idx2: 119 })


    let total = 0

    if (data.total_hits % 119 == 0)
        total = Math.floor(data.total_hits / 119)
    else total = Math.floor(data.total_hits / 119) + 1

    let i = 1
    while (i < total) {
        // console.log("r ==> " + i);
        let idx1 = ((i * 119) - 119) + 1;
        let idx2 =
            i + 1 == total && total % 119 == 0 ?
                (i * 119) + (total % 119) : (i * 119)

        let data = await fetcher({ idx1, idx2 })
        let newData = processData(data.data)
        dataArr = [dataArr, ...newData]

        await delay(1000);

        i++
    }

    // console.log(total, data.total_hits, dataArr.length);



    res.json({ hello: "heloow wole" })
}



const fetcher = async (data) => {
    try {
        let res = await axios.post(`http://localhost:3300/search-all`, data);
        return res.data;

    } catch (error) {
        console.log(error);
    }

}


const delay = async (ms = 1000) =>
    new Promise(resolve => setTimeout(resolve, ms))

const processData = (data) => {
    return data.map(element => {
        let newData = {};
        newData.id = element.id;
        newData.name = element.data.name
        newData.storageUrl = element.data.storageUrl
        return newData;

    })
};