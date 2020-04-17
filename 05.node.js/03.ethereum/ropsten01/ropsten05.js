"use strict"

const Web3 = require('web3');

const web3 = new Web3(
    new Web3.providers.HttpProvider("https://ropsten.infura.io/v3/10ab428a0e934c28877faf92f54278a0")
);

const transactionCount = '0x1e6347b5441E52031fEF0d9f8786E31F37D45Cd1';

web3.eth.getTransactionCount(transactionCount, (err, txCount) => {
    console.log(txCount);

    // 필요한 가스량 산출하기(Hex값으로 산출된다.)
    console.log(web3.utils.toHex(21000));
    console.log(web3.utils.toHex(web3.utils.toWei('5', 'gwei')));
    console.log(web3.utils.toHex(web3.utils.toWei('1', 'ether')));
    // nounce(거래에 대한 고유값)
    console.log('nonce :', web3.utils.toHex(txCount));
});

