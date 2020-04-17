"use strict"

const fs = require('fs');

console.log('start');
try {
    fs.mkdirSync('./dir2');
    console.log('success');
} catch(exception) {
    console.log('fail');
}

console.log('end');

