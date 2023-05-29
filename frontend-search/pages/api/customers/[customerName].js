import data from "../MOCK_DATA";

export default async function handler(req, res) {
    const customerName = req.query.customerName;
    console.log(customerName);
    const customer = data.filter(customer => customer.first_name === customerName);

    const method = req.method;

    let result;
    switch (method) {
        case 'GET':
            result = data.filter(customer => customer.first_name === customerName);

            res.json(result);
            break;

        case 'DELETE':
            // Call respective functions here
            break;

        case 'POST':
            // Call respective functions here
            break;

        default:
            res.status(405).end(`Method ${method} Not Allowed`);
    }
}