"use strict";

const crypto = require('crypto');

// 단방향 암호화 - 복호화 해서 비교하면 안된다. 암호화된 상태를 비교해야한다.
console.log(crypto.createHash('sha512').update('123456').digest('base64'));
// 해시함수를 사용하여 만들 수 있는 값(암호화 된 값)들을 저장한 표를 레인보우 테이블이라 한다.


