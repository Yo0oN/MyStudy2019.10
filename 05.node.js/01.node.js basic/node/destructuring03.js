"use strict"

function total({one, two}) {
    console.log(one, two);
}
// 객체에 값을 바로 할당할 수도 있다.
total({one:1, two:2});

const obj = {
    name : "Nick",
    age : "31",
    job : "Software Engineer"
}
let {name, age, job} = obj;
console.log(name, age, job);