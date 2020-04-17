"use strict";

// 전역객체 globla에 있는 __dirname과 __filename
console.log(__dirname);
console.log(__filename);

const imgname = __dirname + '/image.png';
console.log(imgname);

// path 모듈
const path = require('path');
// sep : separator 구분자
// delimiter : 드라이버이름을 알려줌(리눅스에서는 안씀)
console.log('path.sep :', path.sep);
console.log('path.delimiter :', path.delimiter);

console.log(path.dirname(__filename));
console.log(path.extname(__filename));
console.log(path.basename(__filename));

