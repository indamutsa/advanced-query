// Next.js API route support: https://nextjs.org/docs/api-routes/introduction
var download = require('file-download')

export default function handler(req, res) {
  res.status(200).json({ name: 'John Doe' })
}




var url = "http://i.imgur.com/G9bDaPH.jpg"

var options = {
  directory: "./images/cats/",
  filename: "cat.gif"
}

download(url, options, function (err) {
  if (err) throw err
  console.log("meow")
})



