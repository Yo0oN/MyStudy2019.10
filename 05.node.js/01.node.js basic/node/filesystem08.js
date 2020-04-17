"use strict"

const fs = require('fs');

const file = '../node';

fs.unlink('./test.txt', (err) => {
    if (!err) {
        console.log('success');
    } else {
        console.error('fail');
    }
})

