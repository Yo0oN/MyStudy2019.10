"use strict"

const Web3 = require('web3');

const web3 = new Web3(new Web3.providers.HttpProvider("https://ropsten.infura.io/v3/10ab428a0e934c28877faf92f54278a0"));

web3.eth.getBlock(1, (err, result) => {
    console.log('Block Info :', result);
})

