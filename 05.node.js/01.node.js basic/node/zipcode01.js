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
        zipcode.forEach((item) => {
            // 해당 줄에서 동 상관없이 검색하고싶다면 13~15
            // if (item.indexOf(process.argv[2]) >= 0) {
            //     console.log(item);
            // }
            
            // 동만 검색하고 싶다면 다시 한 줄을 ,로 구분하여 나눈 후
            var zip = item.split(',');
            // 동부분에 해당 동이 있는지 확인하고 출력해준다.
            if (zip[3].indexOf(strDong) >= 0) {
                console.log(item);
            }
        })
    } else {
        console.error('에러 발생');
        process.exit(0);
    }
})

