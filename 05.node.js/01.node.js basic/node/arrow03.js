"use strict"

setTimeout(function () {
    console.log('Hello ECMAScript');
}, 2000);

setTimeout(() => {
    console.log('Hello ECMAScript');
}, 2000);
