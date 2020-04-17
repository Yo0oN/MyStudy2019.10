"use strict"

const os = require('os');

// 운영체제 정보
//console.log(os);
console.log(os.arch());
console.log(os.platform());
console.log(os.type());
console.log(os.hostname());
console.log(os.release());
// 경로 정보
console.log(os.homedir());
console.log(os.tmpdir());
// cpu 정보
console.log(os.cpus());

// memory
console.log(os.totalmem());
console.log(os.freemem());

