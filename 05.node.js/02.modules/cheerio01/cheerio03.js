"use strict"

const axios = require('axios');
const cheerio = require('cheerio');
const sanitizeHtml = require('sanitize-html');

async function getHtml(url) {
    try {
        return await axios.get(url);
    } catch(err) {
        console.error('error :', err);
    }
}

getHtml('https://www.naver.com')
.then( response => {
    // snitize-html을 이용하여 한글이 깨지지 않게 해주자.
    const $ = cheerio.load(response.data, {decodeEntities :true});
    // ca_l클래스를 가진 ol태그의 후손인 a태그 선택
    const $hrefs = $('ol.ca_l a');

    const encodeeHrefs = sanitizeHtml($hrefs, {
        parser : {
            decodeEntities : true
        }
    });

    console.log(encodeeHrefs);
}).catch(err => {
    console.error('error :', err);
});

