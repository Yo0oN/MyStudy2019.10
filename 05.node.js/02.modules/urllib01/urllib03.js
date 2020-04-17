"use strict"

const urllib = require('urllib');
const striptags = require('striptags');

urllib.request('https://www.naver.com', {
    method : 'get',
    data : {

    }
}).then(result => {
    const datas = result.data.toString().trim().split('\n');
    console.log('-', striptags(datas[525]).trim());
    console.log('-', striptags(datas[526]).trim());
    console.log('-', striptags(datas[527]).trim());
    console.log('-', striptags(datas[528]).trim());
    console.log('-', striptags(datas[529]).trim());
    console.log('-', striptags(datas[530]).trim());
}).catch(err => {
    console.log('error', err);
})

