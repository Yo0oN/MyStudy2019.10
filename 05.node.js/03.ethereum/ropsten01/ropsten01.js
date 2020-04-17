"use strict"

const Web3 = require('web3');

// console.log(Web3.version);

const web3 = new Web3(new Web3.providers.HttpProvider("https://ropsten.infura.io/v3/10ab428a0e934c28877faf92f54278a0"));
// console.log(web3);

// 블록 수
// CallBack구조로 가져오기
web3.eth.getBlockNumber((err, result) => {
    if (err) console.error(err);
    console.log(result);
});
// Promise구조로 가져오기
web3.eth.getBlockNumber().then(console.log);


