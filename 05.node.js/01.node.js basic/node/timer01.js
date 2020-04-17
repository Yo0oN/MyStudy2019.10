"use strict"

// setTimeout(function(){
//     console.log('1.5초 후에 실행')
// }, 1500);

// setTimeout(() => {
//     console.log('1.5초 후에 실행')
// }, 1500);

const timeout = setTimeout (() => {
    console.log('3초 후 실행')
}, 3000);
// 설정된 객체 정보를 알려준다.
console.log(timeout);

