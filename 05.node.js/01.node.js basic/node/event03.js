"use strict"

const util = require('util');
const EventEmitter = require('events');

const Person = function () {};
// 특정 객체에 이벤트를 상속시켜주어서
// 특정 객체도 이벤트를 발생할 수 있게 해준다.
util.inherits(Person, EventEmitter);

const person = new Person();
// person에대한 이벤트 등록
person.on('howAreYou', () => {
    console.log('Fine, Thank you and you?');
})
// 이벤트 실행
person.emit('howAreYou');




