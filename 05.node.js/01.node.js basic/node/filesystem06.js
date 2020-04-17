"use strict"

const fs = require('fs');
// 동기방식
console.log('start');
try {
    fs.rmdirSync('./dir2');
    console.log('success!');
} catch (err) {
    console.log('fail!');
}

console.log('end');

