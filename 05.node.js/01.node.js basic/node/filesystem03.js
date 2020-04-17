"use strict"

const fs = require('fs');
// 동기적
// fs.mkdir('./dir1', (err) => {
//     if (!err) {
//         console.log('success!');
//     } else {
//         console.log('fail.');
//         console.error('fail');
//     }
// })
console.log('start');
// system -> 함수(콜백함수)를 호출(이벤트의 느낌이 더 강하다.)
fs.mkdir('./dir1', (err) => {
    if (!err) {
        console.log('success');
    } else {
        console.error('fail');
    }
});
console.log('end');

