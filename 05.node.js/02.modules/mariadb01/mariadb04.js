"use strict"

const mariadb = require('mariadb');
console.log('start');
mariadb.createConnection({
	host:'localhost',
	user:'root',
	password:'123456',
	database:'project'
}).then(conn => {
    console.log('success');

    conn.query('insert into testtbl values(?)',['ddd']
    ).then(res => {
        console.log(res);
        conn.close();
    }).catch(err => {
        console.log(err);
    });
	
}).catch(err => {
    console.log('error');
    console.log(err);
});
console.log('end');
