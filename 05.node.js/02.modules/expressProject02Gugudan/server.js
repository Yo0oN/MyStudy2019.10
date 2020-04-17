"use strict"

const express = require('express');

const app = express();

const router = require('./router/main.js')(app);

app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.engine('html', require('ejs').renderFile);

app.use(express.static('public'));

app.listen(3000, () => {
    console.log('3000 port');
})