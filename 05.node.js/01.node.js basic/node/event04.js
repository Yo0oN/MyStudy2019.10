"use strict"
const EventEmitter = require('events');

class Person extends EventEmitter{}

const person = new Person();
person.on('howAreYou', () => {
    console.log('Fine, Thank you and you?');
});

person.emit('howAreYou');

