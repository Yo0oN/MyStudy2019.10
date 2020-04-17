"use strict"

const urllib = require('urllib');

// urllib.request('https://search.naver.com/search.naver?sm=top_sug.pre&fbm=1&acr=1&acq=starwa&qdt=0&ie=utf8&query=star+wars')
// .then(result => {
//     console.log(result.data.toString());
// }).catch(err => {
//     console.error('error :', err);
// });

urllib.request('https://search.naver.com/search.naver', {
    method:'get',
    data: {
        'sm' :'top_sug.pre',
        'fbm' : '1', 
        'acr' : '1',
        'acq' : 'covid',
        'qdt': '0',
        'ie' : 'utf8',
        'query' : 'covid-19',
    }
}).then(result => {
    console.log(result.data.toString());
}).catch(err => {
    console.error('error :', err);
});

