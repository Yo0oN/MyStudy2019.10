"use strict"

const fs = require('fs');

const path = '../node';
fs.readdir(path, (err, files) => {
    if (!err) {
        // 해당 폴더 내부에 있는 것들(폴더, 파일)을 배열로 반환한다.
        // console.log(files.length);
        // console.log(files[0]);
        // console.log(files);
        // var result = '';
        for (let value of files) {
            var valuepath = './' + value;
            var stats = fs.statSync(valuepath);
            if (stats.isFile()) {
                console.log(value);
                // result += value + '\t'
            } else {
                console.log('[' + value + ']');
                // result += '[' + value + ']\t'
            }
        }
        // console.log(result);
    } else {
        console.error('fail!');
    }
})

