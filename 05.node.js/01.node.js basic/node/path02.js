"use strict"

const path = require('path');

const pathinfo = path.parse(__filename);
console.log(pathinfo);

console.log(pathinfo.ext);

const pathobj = {
    root: '/',
    dir: '/home/master/node',
    base: 'path02.js',
    ext: '.js',
    name: 'path02'
};

const filename = path.format(pathobj);
console.log(filename);

// 책
console.log(path.normalize('/user/tmp/..local///bin/'));

console.log(path.normalize('./path02.js'));

console.log(path.join(__dirname, '..', '..', '/home', '/master'));

