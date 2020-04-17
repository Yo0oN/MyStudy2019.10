"use strict"
// 단어의 첫 글자는 대문자로 변경하는 프로그램 만들기
var upper = (word) => {
    var word = word; // var word = new String(word);
    word = word.replace(word[0], word[0].toUpperCase());
    console.log(word);
}
if (process.argv.length > 2){
    for (var i = 2; i < process.argv.length; i++) {
        upper(process.argv[i]); 
    }
}

// const initcap = (sentence) => {
//     let words = sentence.split(' ');
//     for (let i in words) {
//         words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
//     }
//     return words.join(' ');
// };

// console.log('original : ', process.argv[2]);
// console.log('change : ', initcap(process.argv[2]));