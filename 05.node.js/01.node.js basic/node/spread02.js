"use strict"

let get = (one, two, three) => {
    console.log(one, two, three);
}

const values = [10, 20, 30];

get(...values);

// 여기서부터는 Rest 연산자
function test (a, b, ...arr) {
    console.log(arr);
}
test(1, 2, 3, 4, 5);
