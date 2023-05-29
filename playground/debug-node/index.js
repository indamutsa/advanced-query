const express = require('express')
const app = express()


app.use('/hello', (req, res) => {
    res.send("world")
})

app.listen(process.env.port || 3000)
console.log('Running on port 3000');