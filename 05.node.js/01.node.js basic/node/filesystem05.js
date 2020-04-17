"use strict"

const fs = require('fs');
// 비동기적
console.log('start');
fs.rmdir('./dir1', (err) => {
    if (!err) {
        console.log('success!');
    } else {
        console.log('fail!');
    }
});
console.log('end');

