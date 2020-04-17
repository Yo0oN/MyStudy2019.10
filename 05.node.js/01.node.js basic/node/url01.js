"use strict"

const url = require('url');

const strUrl = 'https://search.naver.com:8080/search.naver?sm=top_hty&fbm=0&ie=utf8&query=covid-19';
const parsedUrl = url.parse(strUrl, true);

// console.log(parsedUrl);

console.log(parsedUrl.protocol);
console.log(parsedUrl.query);

