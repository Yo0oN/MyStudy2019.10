// 문법적으로 검사를 한다. = 문법이 맞아야한다.
"use strict"

// var를 변수마다 사용하면 이름은 같지만 서로 다른 변수가 된다.
// 그렇기 때문에 let과 const라는 키워드가 생겼다.
var one = 100;
function get() {
    var one = 300;
    console.log('function get() :', one);
}
get();
console.log('global :', one);
