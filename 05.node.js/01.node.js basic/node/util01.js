"use strict";

const util = require('util');
// 경고메세지 deprecate 메세지를 만들어준다.
const dontuseme = util.deprecate((x, y)=> {
    console.log(x+y);
}, '2020년 12월 까지만 지원');

dontuseme(2, 3);

