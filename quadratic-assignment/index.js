let express = require("express");
let app = express();
let path = require('path');
let mongoose = require("mongoose");
let Quad = require("./Quad")

require("./Quad");

mongoose.connect('mongodb://localhost/quad', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
}).then((result) => app.listen(4000, () => {
  console.log('Listening');
})).catch((err) => console.log(err))  

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname+'/index.html'))
})

async function solve(a,b,c){
  let root1, root2;
  let discriminant = (b * b) - (4 * a * c);
  console.log(discriminant);
  if (discriminant != 0) {
      root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
      root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
  }
  
  else if (discriminant == 0) {
      root1 = root2 = -b / (2 * a);
  }

  console.log(root1, root2);

  let quad = new Quad({
    a: a,
    b: b,
    c: c,
    root1: root1,
    root2: root2
  });

  await quad.save();
}

app.get('/calc', (req, res) => {
  solve(+req.query.a, +req.query.b, +req.query.c);
  res.redirect('/');
})

app.get('/all', (req, res) => {
  Quad.find({}, (err, data) => {
    res.send(data);
  })
})