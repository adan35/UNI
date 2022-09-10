const mongoose = require('mongoose');
const Schema = mongoose.Schema

const QuadSchema = new Schema({
    a: Number,
    b:Number,
    c:Number,
    root1:Number,
    root2:Number
})

const Quad = mongoose.model('Quad', QuadSchema)
module.exports = Quad