require('dotenv').config();
const Web3 = require('web3');
const { abi } = require('../contracts/PatentRegistry.json'); // Adjust the path as needed

const web3 = new Web3(process.env.INFURA_API_URL);
const contract = new web3.eth.Contract(abi, process.env.CONTRACT_ADDRESS);

async function registerPatentOnBlockchain(title, description, userAddress) {
    const tx = contract.methods.registerPatent(title, description);
    const gas = await tx.estimateGas({ from: userAddress });
    const data = tx.encodeABI();

    const signedTx = await web3.eth.accounts.signTransaction(
        { to: process.env.CONTRACT_ADDRESS, data, gas, from: userAddress },
        process.env.PRIVATE_KEY
    );

    return web3.eth.sendSignedTransaction(signedTx.rawTransaction);
}


async function transferPatentOnBlockchain(patentId, fromAddress, toAddress) {
    const tx = contract.methods.transferPatent(patentId, toAddress);
    const gas = await tx.estimateGas({ from: fromAddress });
    const data = tx.encodeABI();

    const signedTx = await web3.eth.accounts.signTransaction(
        { to: process.env.CONTRACT_ADDRESS, data, gas, from: fromAddress },
        process.env.PRIVATE_KEY
    );

    return web3.eth.sendSignedTransaction(signedTx.rawTransaction);
}

module.exports = {
    registerPatentOnBlockchain,
    transferPatentOnBlockchain,
};
