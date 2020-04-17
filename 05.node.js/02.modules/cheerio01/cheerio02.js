"use strict"

const axios = require('axios');
const cheerio = require('cheerio');

async function getHtml(url) {
    try {
        return await axios.get(url);
    } catch(err) {
        console.error('error :', err);
    }
}

getHtml('https://www.naver.com')
.then( response => {
    // console.log(response.data);

    const $ = cheerio.load(response.data);
    const $hrefs = $('ol.ca_l a');
    console.log($hrefs.html());
    console.log($hrefs.text());
}).catch(err => {
    console.error('error :', err);
});

