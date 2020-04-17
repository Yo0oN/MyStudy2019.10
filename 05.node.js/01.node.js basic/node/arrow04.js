"use strict"

let sports = () => ({kind1: 'soccor'});

let result = sports();
console.log(result);

let sports2 = function() {
    return {kind1 : 'soccor', kind2: 'baseball'};
}

let result2 = sports2();
console.log(result2);
console.log(result2.kind1);
console.log(result2.kind2);
