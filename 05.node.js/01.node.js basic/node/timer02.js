"use strict"

// 2초마다 Hello World를 출력하도록 하여라

const helloWorld = setInterval(() => {
    console.log('Hello World')
}, 2000);

setTimeout(() => {
    clearInterval(helloWorld);
    console.log('Timer End')
}, 10000);

