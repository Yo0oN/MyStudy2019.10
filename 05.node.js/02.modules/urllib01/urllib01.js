"use strict"

const urllib = require('urllib');

urllib.request('https://www.naver.com', (err, data, res) => {
    if(!err) {
        // 상태정보 확인
        // console.log(res.statusCode);
        // console.log(res.headers);
        // console.log(data);
        console.log(data.toString());
    }
});

