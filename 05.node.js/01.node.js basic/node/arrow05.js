"use strict"
// 책 5쪽
var calculateVolume = function(a, b, c) {
    var volume = a * b * c;
    return volume;
}

var result = calculateVolume(1, 2, 3);
console.log(result);

// 위의 식을 람다식으로 바꾼것
let calculateVolume2 = (a, b, c) => a* b* c;

console.log(calculateVolume2(1, 2, 3));

// 책6쪽
// 파라미터가 하나만 있으면 괄호를 생략할수도 있다.
let calculate = value => value + 10;
let calculate2 = function(value) {
    return value + 10;
}
console.log(calculate(10) + " / " + calculate2(10));

