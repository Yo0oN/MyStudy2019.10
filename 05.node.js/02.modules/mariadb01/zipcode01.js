"use strict"

// 윈도우의 우편번호데이터를 리눅스로 가져와
// 검색 프로그램 작성

const mariadb = require('mariadb');

mariadb.createConnection({
    host:'localhost',
    user:'root',
    password:'123456',
    database:'project'
}).then(conn => {
    console.log('connected!');
    let dong = process.argv.slice(2);
    // 들어온 값이 1이 아니면 경고창 뜨고 종료
    if (dong.length != 1) {
        conn.close();
        return console.log('동을 제대로 입력해주세요.');
    }

    dong = dong.toString();
    // console.log(dong);

    conn.query('select * from zipcode where dong like(?)', [`%${dong}%`])
    .then(rows => {
        if (rows.length == 0) {
            conn.close();
            return console.log('검색 결과가 없습니다.');
        }
        
        console.log('검색 결과 :', rows.length, '개.');

        rows.forEach(element => {
            console.log(`${element.zipcode}, ${element.sido}, ${element.gugun}, ${element.dong}, ${element.ri}, ${element.bunji}, ${element.seq}`);
        });

        conn.close();

    }).catch(err => {
        console.log(err);
        conn.close();
    })

}).catch(err => {
    console.error(err);
})