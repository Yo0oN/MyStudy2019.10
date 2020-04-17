"use strict"

const axios = require('axios');

// console.log(axios);

// axios.get : get방식, axios.post : post방식
// axios.get('https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=star+treck&oquery=startreck&tqi=UopIUdprvh8ssvPBXdhssssstpZ-443806')
// .then( response => {
//     console.log('success')
//     console.log(response.status);
//     console.log(response.header);
//     console.log(response.data);
// }).catch(err =>{
//     console.error('fail');
// });

axios.get('https://search.naver.com/search.naver', {
    params: {
        sm : 'tab_hty.top',
        where : 'nexearch',
        query : 'star+treck',
        oquery : 'startreck',
        tqi : 'UopIUdprvh8ssvPBXdhssssstpZ-443806'
    }
})
.then( response => {
    console.log('success')
    console.log(response.status);
    console.log(response.header);
    console.log(response.data);
}).catch(err =>{
    console.error('fail');
});