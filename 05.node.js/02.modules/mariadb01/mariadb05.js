"use strict"

const mariadb = require('mariadb');

// console.log('start');

mariadb.createConnection({
	host:'localhost',
	user:'root',
	password:'123456',
	database:'project'
}).then(conn => {
    console.log('success');

    conn.query('select * from testtbl'
    ).then(rows => {
        console.log(rows.length);
        

        rows.forEach(element => {
            console.log(element);
            console.log(element.col1);
        });

        conn.close();

    }).catch(err => {
        console.log(err);
    });
	
}).catch(err => {
    console.log('error');
    console.log(err);
});

// console.log('end');
