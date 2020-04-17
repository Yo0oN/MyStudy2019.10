"use strict"

const axios = require('axios');

// async(비동기), await => 비동기 구조지만, 동기처럼 처리

console.log('start');

async function getHtml(url) {
    try {
        // axios.get을 하는 시간동안 잠시 기다림(awiat)
        // const response = await axios.get(url);
        // console.log(response);
        // console.log(response.data);
        return await axios.get(url);
    } catch(err) {
        console.error('error :', err);
    }
}

getHtml('https://www.naver.com')
.then( response => {
    console.log(response.data);
}).catch(err => {
    console.error('error :', err);
});

console.log('end');

