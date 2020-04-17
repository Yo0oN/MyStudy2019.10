"use strict"

// 데이터를 읽어오는 axios
const axios = require('axios');
// DOM에 접근해주는 cheerio
const cheerio = require('cheerio');
// html을 깨짐없이 보여주는 sanitize-html
const sanitizeHtml = require('sanitize-html');

axios.get('https://www.bithumb.com')
.then(response => {
    // 데이터 읽어옴
    const $ = cheerio.load(response.data);
    // 데이터에서 클래스가 sise_list인것 중 tr을 선택하여 배열에넣음.
    const $trs = $('#sise_list').find('tr');
    // 배열에서 내용물의 것들 중 td태그를 가진것을 다시 $tds배열에 넣음
    $trs.each((index1, element1) => {
        const $tds = $(element1).children('td');
        // $tds배열을 다시 반복문을 돌리며 내용을 보여준다.
        // 이렇게하면 여기서는 테이블에서 한 줄(tr)에서
        // 각 칸(td)의 내용을 출력하고, 다시 겉의 반복문을 돌며
        // 여기서 한 줄의 내용을 다시 출력한다.
        $tds.each((index2, element2) => {
            let data = $(element2).text().trim();
            if (data != "") {
                console.log(index2, data);
            }
        });
    });

    // const $ = cheerio.load(response.data, {decodeEntities : true});
    // const $hrefs = $('tbody.coin_list').html();

    // const encodedHrefs = sanitizeHtml($hrefs, {
    //     parser : {
    //         decodeEntities : true
    //     }
    // });

    // var array = encodedHrefs.trim().split('<tr>');
    // array.forEach((value, index) =>{
    //     const $td = value('td').text();
    //     console.log($td);
    // })
}). catch(err => {
    console.error('error :', err);
})