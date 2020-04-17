"use strict";

const util = require('util');
// 상속 구조 - 상속을 하려면 클래스가 있어야한다.

// 함수 이름을 대문자로 사용하면 클래스처럼 사용할 수 있다.
function Parent() {
    console.log('Parent 생성자');
}

Parent.prototype.sayHello = function() {
    console.log('Hello, from Parenrt Class')
}

const parent = new Parent();
console.log(typeof parent); // prent의 타입은 객체임 함수가아니다.
parent.sayHello();

function Child() {
    console.log('Child 생성자');
}
// Parent클래스를 Child클래스가 상속받았음
util.inherits(Child, Parent);
const child = new Child();
child.sayHello();

