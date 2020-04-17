"use strict"

const express = require('express');

const app = express();

// 내부에 무한루프가 들어있어 종료명령을 내리기 전까지는 계속 서버를 켜둔다.
// 서버 시작
app.listen(3000, () => {
    console.log('3000번 포트에서 서버 대기 중 입니다.')
});

// node.js에서는 MVC의 controller역할을 하던것을
// router(요청에 따라 반응해주는것)라 한다.
// 이제 이파일이 router가 된다.
// localhost:3000/
app.get('/', (req, res) => {
    res.end('Hello Express');
});
// localhost:3000/user
app.get('/user', (req, res) => {
    res.end('user get');
});
//localhost:3000/item
app.get('/item', (req, res) => {
    res.end('item get');
});

