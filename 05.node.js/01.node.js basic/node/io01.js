"use strict"

const fs = require('fs');
// 파일 읽기
fs.readFile('./filesystem01.js', 'utf-8', (err, data)=> {
    if (!err) {
        console.log('success');
        console.log(data);
        // Byte단위로 나오기 때문에 문자열 처리를 해주자.
        // 하지만 인코딩방식도 적어주면 data도 문자열로 나온다.
        console.log(data.toString());
    } else {
        console.log('fail');
    }
});

