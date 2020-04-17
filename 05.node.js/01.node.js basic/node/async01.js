"use strict"

async function test() {
    let promise = new Promise(function(resolve, reject){
        setTimeout(function(){
            resolve("done");
        }, 1000)
    });
    const result = await promise;
    console.log(result);
}
console.log('start');
test();
console.log('end');
