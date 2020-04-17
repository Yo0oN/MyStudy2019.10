"use strict";

const crypto = require('crypto');

// 양방향 암호화
const ciphers = crypto.getCiphers();
console.log(ciphers);