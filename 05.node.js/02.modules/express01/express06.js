"use strict"

const express = require('express');

const app = express();

app.use(express.urlencoded({extended : true}));

app.listen(3000, () => {
    console.log('3000번 포트에서 서버 대기 중 입니다.')
});

//localhost:3000/
app.get('/', (req, res) => {
    console.log(req.headers);
    console.log(req.ip);
    res.send('Hello Express');
});

app.get('/form', (req, res) => {
    res.sendFile(__dirname + '/form.html');
});

app.get('/form_ok', (req, res) => {
    console.log(req.query);
    console.log(req.query.data);
    res.send('응답 완료');
})

app.post('/form_ok', (req, res) => {
    console.log(req.body);
    console.log(req.body.data);
    res.send('POST 응답 완료');
})

