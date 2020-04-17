"use strict"

const EventEmitter = require('events');

const myEmitter = new EventEmitter();

// 일회성 이벤트 등록
myEmitter.once('event1', () => {
    console.log('event1 emit')
});

// 이벤트를 실행시킨다.
myEmitter.emit('event1');
myEmitter.emit('event1');

