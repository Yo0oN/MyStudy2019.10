"use strict";

let func1 = function(one) {
    console.log('func1 :', one);
}

func1(10);

let func2 = (one) => {
    console.log('func2 :', one);
};

func2(10);

let func3 = (one, two) => {
    console.log('func3 :', one, two);
};
func3(10, 20);

let func4 = (one, two)=> {
    return one + two;
}
console.log('func4 :', func4(20, 30));

let func5 = (one, two) => one + two;
console.log('func5 :', func5(20, 30));

let func6 = (one, two)=> console.log('func6 :', one, two);
func6(50, 40);