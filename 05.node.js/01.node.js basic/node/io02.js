"use strict"

const fs = require('fs');
var msg = `text
text
text`;
fs.writeFile('./test.txt', '글자 입력\n글자입력' + msg, (err) => {
    if (!err) {
        console.log('success');
    } else {
        console.log('fail');
    }
})
