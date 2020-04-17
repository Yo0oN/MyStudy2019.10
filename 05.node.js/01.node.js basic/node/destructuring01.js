"use strict";

let one, two, three;
const value = [1, 2, 3];

// one = value[0];
// two = value[1];
// three = value[2];

//[one, two, three] = value;

//console.log(one, two, three);

let four;
// 배열에 들어있는만큼만 할당하고,
// 더 할당한다고 해도에러는 발생하지 않는다.
// [one, two, three, four] = value;
// console.log(one, two, three, four);

// [one, two, three, four] = [1, 2, [73, 74]];
// console.log(one, two, three, four);

// [one, two, [three, four]] = [1, 2, [73, 74]];
// console.log(one, two, three, four);

[one, , , four] = [1, 2, 3, 4];
console.log(one, two, three, four);

