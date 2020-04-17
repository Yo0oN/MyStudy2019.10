"use strict"

const express = require('express');

const app = express();

app.listen(3000, () => {
    console.log('3000번 포트에서 서버 대기 중 입니다.')
});

app.get('/', (req, res) => {
    res.redirect('https://www.daum.net');
});

