"use stric"

// 이름은 클래스인데 데이터 타입은 function이다.
class Animal{
    constructor(name) {
        // 멤버필드에 대한 동적 생성
        this.name = name;
        this.type = 'animal';
    }

    static getName() {
        return this.name;
    }
}

class Lion extends Animal {
    constructor(name) {
        // 부모 생성자를 호출
        super(name);
        // 부모의 생성자에 name을 전달하고,
        // type은 lion으로 변경한다.
        this.type = 'lion';
    }
}

//let animal = new Animal('lion');
//console.log(animal.getName());
// console.log(typeof Animal);

let lion = new Lion('king');
console.log(lion instanceof Animal);
console.log(lion.getName());

