"use strict"

// 우편번호 검색기
const fs = require('fs');
const file = './data/zipcode_seoul_utf8_type2.csv';

const strDong = process.argv.slice(2).toString();

if (strDong.length == 0) {
    console.log('동 이름을 입력하세요');
    process.exit();
}

// 우편번호 읽어온다.
fs.readFile(file, 'utf-8', (err, data) => {
    if (!err) {
        // 무사히 읽어왔다면, 한줄씩 분리한다.
        var zipcode = data.toString().trim().split('\r\n');
       
        // filter메서드 : 특정 조건을 만족하는 요소를 추출해 새로운 배열을 만들어준다.
        // 아래에서는 zipcode배열에 filter메소드를 사용하여,
        // zipcode의 요소들을 search로 받아 넣은 후 다시 안에서 ,를 기준으로 나눠
        // 검색한 동이 있는지 true, false로 확인하고있다.
        // 만약 있다면 true로 arrFilterData에 들어가서 새로운 배열이 될것이고,
        // 아래에서 출력을 할 수 있다.
        let arrFilterData = zipcode.filter((search) => {
            let arrData = search.split(',');
            return arrData[3].indexOf(strDong) != -1;
        })

        console.log(arrFilterData)
    } else {
        console.error('에러 발생');
        process.exit(0);
    }
})

