"use strict";

// 양방향 암호화
const crypto = require('crypto');

const cipher = crypto.createCipher('aes-256-cbc', '1234');

let result = cipher.update('123456', 'utf-8', 'base64');
result += cipher.final('base64');

console.log('result :', result);

const deciper = crypto.createDecipher('aes-256-cbc','1234');
let result2 = deciper.update(result, 'base64', 'utf8');
result2 += deciper.final('utf-8');

console.log('result2:', result2);

