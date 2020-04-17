"use strict";

const readline = require('readline');

// 표준 입력 stdin(standard input) : 키보드
// 표준 출력 stdout(standard output): 모니터
// createInterface로 입출력 모드를 설정한다.
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// setPrompt(문자열) 메서드는 터미널 창에 어떤 문자열을 보여줄지 정한다.
// 어떤 문자열을 보여줄지 설정하면 prompt(boolean)로 실제로 보여줘야한다.
rl.setPrompt('> ');
// true 안쓰고 그냥 prompt()만 적어도 된다.
rl.prompt(true);
// process 내에 있는 이벤트
process.on('exit', () => {
    console.log('system exit');
});

// on메서드는 on(이벤트문자열, function)으로 사용하는데,
// 이벤트  메서드이다.
// line은 무언가 입력된 이벤트를, close는 입력이 끝난 이벤트를 뜻한다.
rl.on('line', line => {
    console.log('Hello!', line);
    rl.close();
}).on('close', () => {
    process.exit();
});

