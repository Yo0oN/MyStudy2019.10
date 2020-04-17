"use strict"

const url = require('url');

const queryString = require('querystring');
const parsedUrl = url.parse('https://search.naver.com:8080/search.naver?sm=top_hty&fbm=0&ie=utf8&query=covid-19');

const query = queryString.parse(parsedUrl.query)

console.log(query);
console.log(query.query);

