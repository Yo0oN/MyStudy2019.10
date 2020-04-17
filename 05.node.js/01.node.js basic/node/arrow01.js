"use strict"

function func1() {
    console.log('func 1');
}

var func2 = function() {
    console.log('func 2');
}

let func3 = () =>{
    console.log('func 3');
}
func1();
func2();
func3();
