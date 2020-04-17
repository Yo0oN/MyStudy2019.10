"use strict"

function addTenValue1(x) {
    return (new Promise(function(resolve, resect){
        setTimeout(function(){
            if (typeof x != 'number'){
                reject('유효한 타입이 아닙니다.');
            } else{
                resolve(x + 10);                
            }
        }, 1000);
    }));
}


addTenValue1(10).then(function(resolveData){
    // then 은 성공했을 경우 일어나는일이다.
    console.log(resolveData);
}).catch(function(message){
    // catch는 실패했을 경우 일어나는 일이다.
    console.log(message);
}).finally(function(){
    console.log('항상 처리');
});

const promise1 = new Promise(function(resolve, reject){
    setTimeout(resolve, 200, 'a');
});
const promise2 = new Promise(function(resolve, reject){
    setTimeout(resolve, 100, 'b');
});

Promise.race([promise1, promise2]).then(function(value) {
    console.log(value);
}).catch(function(value){
    console.log(value);
});

// new Promise(function(resolve, reject){
//     // 해야하는 작업
// }).then(function(resolve){
//     // 작업 성공시 일어나는 일
// }).catch(function(reject){
//     // 작업 실패시 일어나는 일
// }).finally(function(){
//     // 항상 일어나는 일
// });

const promise3 = new Promise(function(resolve, reject){
    setTimeout(resolve, 200, 'a');
});
const promise4 = new Promise(function(resolve, reject){
    setTimeout(resolve, 100, 'b');
});

Promise.all([promise1, promise2]).then(function(value) {
    console.log(value);
}).catch(function(value){
    console.log(value);
})

