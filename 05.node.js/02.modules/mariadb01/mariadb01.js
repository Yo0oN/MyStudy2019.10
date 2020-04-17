"use strict"

const mariadb = require('mariadb');

mariadb.createConnection({
    host: 'localhost',
    user: 'root',
    password: '123456',
}).then(conn => {
    console.log('connected!', conn.threadId);
    // 연결 종료
    conn.close();
    console.log('연결 종료');
}).catch(err => {
    console.log('error!', conn.threadId);
});

