"use strict"

const Web3 = require('web3');

const web3 = new Web3(
    new Web3.providers.HttpProvider("https://ropsten.infura.io/v3/10ab428a0e934c28877faf92f54278a0")
);

const transactionHash = '0x744a23819371c66c7c99438546d6440d56b9eeaa0addcd26c44cb299a8063218';

web3.eth.getTransactionReceipt(transactionHash, (err, receipt) => {
    console.log(receipt);
});

