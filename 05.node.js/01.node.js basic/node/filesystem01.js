"use strict"

const fs = require('fs');

const file = 'filesystem01.js';

fs.access(file, fs.constants.F_OK, (err) => {
    console.log(`${file} ${err ? 'dose not exist' : 'exists'}`);
});

fs.access(file, fs.constants.R_OK, (err) => {
    console.log(`${file} ${err ? 'is not useable' : 'is readable'}`);
});

fs.access(file, fs.constants.W_OK, (err) => {
    console.log(`${file} ${err ? 'is not writable' : 'is writeable'}`);
});

fs.access(file, fs.constants.F_OK | fs.constants.W_OK, (err) => {
    if (err) {
        console.error (
            `${file} ${err.code ==='ENOENT' ? 'does not exist' : 'is read-only'}`);
    } else {
        console.log(`${file} exists, and it is writable`);
    }
});

