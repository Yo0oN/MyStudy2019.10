"use strict"

let type = 'Type';
class Sports {
    // ['get' + type] : 계산된 이름.
    // [] 안에 넣어 이름을 변경할 수 있다.
    static ['get' + type](kind) {
        return kind ? 'sports' : 'music';
    }
}
// 0은 false, 그외 숫자는 true이다.
console.log(Sports['get' + type](0));

