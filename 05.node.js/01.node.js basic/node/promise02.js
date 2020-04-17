"use strict"

// function addTenValue(x, callback) {
//     setTimeout(function(){
//         return callback(x + 1);
//     }, 1000);
// };

// addTenValue(10, function(x){
//     console.log(x);
// });


// 콜백함수로 처리부분과 실행부분을 나누었다.
function addTenValue2(x) {
    return (new Promise(function(resolve){
        setTimeout(function(){
            resolve(x + 10);
        }, 1000);
    }));
}

// addTenValue2(10).then(function(resolveData) {
//     console.log(resolveData)
// });


console.log('start');
addTenValue2(10).then(function(resolveData){
    return addTenValue2(resolveData);
}).then(function(resolveData){
    return addTenValue2(resolveData);
}).then(function(resolveData){
    console.log(resolveData);
})
console.log('end');