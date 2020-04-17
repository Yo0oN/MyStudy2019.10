"use strict"

const mariadb = require('mariadb');

const pool = mariadb.createPool({
    host:'localhost',
    user:'root',
    password:'123456',
    database:'project',
    connectionLimit:5
});
pool.getConnection()
.then(conn => {
    console.log('connected!', conn.threadId);
    conn.query('insert into testtbl values (?)', ['bbb'])
    .then(rows => {
        console.log('rows : ');
        console.log(rows);
    }).then(res => {
        console.log('res :' );
        console.log(res);
        conn.release();
    }).catch(err => {
        conn.release();
    })
    // 커넥션풀에 다시 반환
    conn.release();
    pool.end();
}).catch(err => {
    console.log('error', conn.threadId);
});

