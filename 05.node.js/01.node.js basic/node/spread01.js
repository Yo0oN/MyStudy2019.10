"use strict";

let spreadObj1 = ['music', 'sport'];
console.log(spreadObj1);
console.log(spreadObj1.length);

let spreadObj2 = [...'music', 'sport'];
console.log(spreadObj2);
console.log(spreadObj2.length);

let one = [11, 12];
let spreadObj3 = [...one];
console.log(spreadObj3);
console.log(spreadObj3.length);

function test(a, b) {
    return a + b;
}
const data = [1, 2];
// ...을 이용하여 배열의 내용을 분리시켰기 때문에,
// test의 매개변수로 하나씩 들어갈 수 있었다.
const result = test(...data);
console.log(result);

const data1 = [1, 2];
const data2 = [3, 4];
// 이전에는 배열을 하나씩 풀어서 반복문을 이용하여 여러 배열을 합쳐야 했지만,
// 이제는 spread기능으로 간단하게 합칠 수 있다.
const result2 = [0, ...data1, ...data2, 5];
console.log(result2);
console.log(result2.length);

