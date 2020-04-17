"use strict"

const Web3 = require('web3');
// ether전송을 위한 모듈
const EthereumTX = require('ethereumjs-tx').Transaction;

const web3 = new Web3(
    new Web3.providers.HttpProvider("https://ropsten.infura.io/v3/10ab428a0e934c28877faf92f54278a0")
);

// 보내는 사람
const send_account = '0x1e6347b5441E52031fEF0d9f8786E31F37D45Cd1';
// 받는사람
const receive_account = '0x3689060fccFA8D9475B1820f4E18Bb26F7979D3b';
// 보내는 사람의 개인키 - 16진수로 바꿔줘야함
const privateKey = Buffer.from('cf882f4901cc1c9364b36bb564a80b065b2c94b31c7061e945b5cbd068b1296f', 'hex');

web3.eth.getTransactionCount(send_account, (err, txCount) => {
    // 전송을 위한 객체
    const rawTx = {
        to : receive_account,
        nonce : web3.utils.toHex(txCount),
        // gas * gasPrice = fee수수료
        gas : web3.utils.toHex(2100000),
        // gas 단가
        gasPrice : web3.utils.toHex(web3.utils.toWei('5', 'gwei')),
        value : web3.utils.toHex(web3.utils.toWei('1', 'ether'))
    }
    const ethereumTX = new EthereumTX(rawTx, {'chain' : 'ropsten'});
    ethereumTX.sign(privateKey);
    const serializedTX = ethereumTX.serialize();
    const raw = '0x' + serializedTX.toString('hex');

    // 실제로 전송하는 부분
    web3.eth.sendSignedTransaction(raw, (err, transactionHash) => {
        if (!err) {
            // 0x8dbcad4243de42906dcef7c635c20d7243e76ee68c0f085b1c2d9cc56a7f4050
            console.log(transactionHash);
        } else {
            console.error(err);
        }
    })
});

