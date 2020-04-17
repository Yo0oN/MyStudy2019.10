"use strict"

const express = require('express');

const app = express();

// 내부에 무한루프가 들어있어 종료명령을 내리기 전까지는 계속 서버를 켜둔다.
// 서버 시작
app.listen(3000, () => {
    console.log('3000번 포트에서 서버 대기 중 입니다.')
});

//localhost:3000/html
app.get('/html', (req, res) => {
    res.sendFile(__dirname + '/index.html');
});

