"use strict";

// 대기상태 : Promise객체 생성, 생성자 호출까지만 한 상태
// new Promise()

// resolve는 성공, reject는 실패상태이다.
// new Promise(function(resolve, reject){
//      처리 내용.
//      resolve();  처리할 것을 이행
// })
// .then
let getData1 = function(callBack) {
    let data = 100;
    return callBack(data);
};
getData1(function(x){
    console.log(x);
});

let getData2 = function(){
    // Promise 내부의 function은 콜백함수
    return new Promise(function(resolve, reject){
        let data = 100;
        resolve(data);
    })
}
getData2().then(function(resolveData) {
    console.log(resolveData);
});