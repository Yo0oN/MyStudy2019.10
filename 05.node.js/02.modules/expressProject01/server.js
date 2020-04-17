"use strict"

const express = require('express');

const app = express();

// router 설정
const router = require('./router/main.js')(app);
// ejs template 설정
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.engine('html', require('ejs').renderFile);

// static 파일(디자인관련파일)을 아래의 폴더에서 읽어오도록 한다.
app.use(express.static('public'));

app.listen(3000, () => {
    console.log('3000번 포트에서 서버가 대기중입니다.');
});

