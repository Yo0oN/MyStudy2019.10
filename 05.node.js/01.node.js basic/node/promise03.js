"use strict";

function addTenValue1 (x, callback) {
    setTimeout(function(){
        return callback(x + 10);
    }, 1000);
}

// 콜백지옥
// 1초마다 10씩 더해준다.
console.log('start');
addTenValue1(10, function(x1){
    addTenValue1(x1, function(x2){
        addTenValue1(x2, function(x3){
            console.log(x3);
        });
    });
});

console.log('end');