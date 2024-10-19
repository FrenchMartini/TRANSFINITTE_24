require('dotenv').config();  // Load environment variables from .env file
const { Web3 } = require('web3');
const { abi } = require('../Contracts/PatentRegistry.json'); // Adjust the path as needed

const web3 = new Web3(process.env.INFURA_API_URL);
const contract = new web3.eth.Contract(abi, process.env.CONTRACT_ADDRESS);

// Register a new patent on the blockchain
async function registerPatentOnBlockchain(title, description, userAddress) {
    try {
        // Create the transaction object
        const tx = contract.methods.registerPatent(title, description);
        
        // Estimate gas
        const gas = await tx.estimateGas({ from: userAddress });
        const gasPrice = await web3.eth.getGasPrice();

        // Encode ABI
        const data = tx.encodeABI();

        // Sign the transaction
        const signedTx = await web3.eth.accounts.signTransaction(
            {
                to: process.env.CONTRACT_ADDRESS,
                data,
                gas,
                gasPrice,
                from: userAddress
            },
            process.env.PRIVATE_KEY
        );

        // Send the signed transaction
        const receipt = await web3.eth.sendSignedTransaction(signedTx.rawTransaction);
        return receipt;  // Return transaction receipt on success
    } catch (error) {
        console.error("Error registering patent:", error);
        throw error;
    }
}
// Transfer patent ownership on the blockchain
async function transferPatentOnBlockchain(patentId, fromAddress, toAddress) {
    try {
        const tx = contract.methods.transferPatent(patentId, toAddress);
        const gas = await tx.estimateGas({ from: fromAddress });
        const gasPrice = await web3.eth.getGasPrice();
        const data = tx.encodeABI();

        const signedTx = await web3.eth.accounts.signTransaction(
            { to: process.env.CONTRACT_ADDRESS, data, gas, gasPrice, from: fromAddress },
            process.env.PRIVATE_KEY
        );

        const receipt = await web3.eth.sendSignedTransaction(signedTx.rawTransaction);
        return receipt;  // Return transaction receipt on success
    } catch (error) {
        console.error("Error transferring patent:", error);
        throw error;
    }
}
module.exports = {
    registerPatentOnBlockchain,
    transferPatentOnBlockchain,

};