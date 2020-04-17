"use strict";

// in은 인덱스를 추출한다.
for (let value in [10, 20, 30]) {
    console.log(value);
}
// for은 값을 추출한다.
for (let value of [10, 20, 30]) {
    console.log(value);
}

for (let value of 'ABC') {
    console.log(value);
}

// json
let values = [
    {item : '선물1', amount : 20},
    {item : '선물2', amount : 30}
]

for (let {item : one, amount : two} of values) {
    console.log(one, two );
}

let values2 = [
    {item : '선물1', amount : {apple :10, candy : 20}},
    {item : '선물2', amount : {apple :30, candy : 40}}
]

for (let {item : one, amount : {apple : two, candy : three}} of values2) {
    console.log(one, two, three);
}

