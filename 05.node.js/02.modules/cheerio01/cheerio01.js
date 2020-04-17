"use strict";

const cheerio = require('cheerio');

const html = `<ul id="fruits">
<li class="apple">Apple</li>
<li class="orange">Orange</li>
<li class="pear">Pear</li>
</ul>`;

// console.log(typeof html);

const $ = cheerio.load(html);
// console.log(typeof $);

// console.log($.html());
// console.log($.text());

// console.log($('ul').html());

// console.log($('li').html());

console.log($('.apple', '#fruits').text());
console.log($('ul .pear').attr('class'));
console.log($('li[class=orange]').html());

