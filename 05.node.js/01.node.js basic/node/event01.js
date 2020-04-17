"use strict"

const EventEmitter = require('events');

const myEmitter = new EventEmitter();
// addListener('이벤트', function) == on('이벤트', function)
// 이벤트를 등록해준다.
// 기본적으로 on의경우 대부분의 모듈에 각각의 이벤트가 등록되어있다.
// 그래서 readline이나 process 등등.. 찾아보면
// on을 이용하여 특정 이벤트발생시 할 수 있는 일을 설정정해 줄 수 있을것이다.
// 기존에 사용하던 방식
myEmitter.addListener('event1', () => {
    console.log('event1 emit')
});
// jQueyr에서 따온 방식
myEmitter.on('event2', () => {
    console.log('event2 - 1 emit')
});
// 같은 이름의 이벤트가 여러개라면 동시에 발생한다.
myEmitter.on('event2', () => {
    console.log('event2 - 2 emit')
});

console.log('event count :', myEmitter.listenerCount('event2'));

// emit으로 이벤트를 실행시킨다.
myEmitter.emit('event1');
myEmitter.emit('event2');

