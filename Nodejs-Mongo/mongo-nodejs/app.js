const path = require('path');
const logger = require('morgan');
const express = require('express');
const mongoose = require("mongoose");
const cookieParser = require('cookie-parser');

const mongodb = 'mongodb://localhost/gamers';
mongoose.connect(mongodb, { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log('MongoDB connected'))
    .catch(err => console.log(err));

const app = express();

app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', require('./routes/gamers'));
app.use('/games', require('./routes/gamers'));
module.exports = app;