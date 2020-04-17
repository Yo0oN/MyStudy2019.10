"use strict"

const Web3 = require('web3');

const web3 = new Web3(new Web3.providers.HttpProvider("https://ropsten.infura.io/v3/10ab428a0e934c28877faf92f54278a0"));

// 내 지갑 조회하기
// callback
web3.eth.getBalance('0x3689060fccFA8D9475B1820f4E18Bb26F7979D3b', (err, result) => {
    // getBalance로 조회하면 wei 단위로 나온다.
    console.log('Balance :', result);
    // fromWei를 이용하여 ether 단위로 보자.
    console.log('Balance :', web3.utils.fromWei(result));
});
// promise
web3.eth.getBalance('0x3689060fccFA8D9475B1820f4E18Bb26F7979D3b')
.then(result => {
    console.log(result);
    console.log(web3.utils.fromWei(result));
});

web3.eth.getBalance('0x3689060fccFA8D9475B1820f4E18Bb26F7979D3b')
.then(web3.utils.fromWei)
.then(result => {
    console.log(result);
});

