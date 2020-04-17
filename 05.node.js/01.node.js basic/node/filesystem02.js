"use strict"

const fs = require('fs');
const stats1 = fs.statSync('filesystem01.js');
const stats2 = fs.statSync('../node');

console.log(stats1);
console.log(stats1.birthtime);

console.log(stats2);
console.log(stats2.birthtime);
console.log(stats2['birthtime']);
console.log(stats2.size);
console.log(stats2.isFile());
console.log(stats2.isDirectory());

