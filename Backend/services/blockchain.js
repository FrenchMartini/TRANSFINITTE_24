require('dotenv').config();  // Load environment variables from .env file
const { Web3 } = require('web3');
const { abi } = require('../Contracts/PatentRegistry.json'); // Adjust the path as needed

const web3 = new Web3(process.env.INFURA_API_URL);
const contract = new web3.eth.Contract(abi, process.env.CONTRACT_ADDRESS);
// Log the ABI
console.log('Contract ABI:', contract.options.jsonInterface);

// Register a new patent on the blockchain
async function registerPatentOnBlockchain(title, abstractText, description, ipfsHash, userAddress) {
    try {
        // Create the transaction object
        const tx = contract.methods.registerPatent(title, abstractText, description, ipfsHash);
        
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
        
        // Convert BigInt values to strings
        const processedReceipt = JSON.parse(JSON.stringify(receipt, (key, value) =>
            typeof value === 'bigint' ? value.toString() : value
        ));

        return processedReceipt;
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


// Renew a patent on the blockchain
async function renewPatentOnBlockchain(patentId, userAddress) {
    try {
        const tx = contract.methods.renewPatent(patentId);
        const gas = await tx.estimateGas({ from: userAddress });
        const gasPrice = await web3.eth.getGasPrice();
        const data = tx.encodeABI();

        const signedTx = await web3.eth.accounts.signTransaction(
            { to: process.env.CONTRACT_ADDRESS, data, gas, gasPrice, from: userAddress },
            process.env.PRIVATE_KEY
        );

        const receipt = await web3.eth.sendSignedTransaction(signedTx.rawTransaction);
        return receipt;
    } catch (error) {
        console.error("Error renewing patent:", error);
        throw error;
    }
}

// Grant a patent on the blockchain (admin only)
async function grantPatentOnBlockchain(patentId) {
    try {
        const tx = contract.methods.grantPatent(patentId);
        const gas = await tx.estimateGas({ from: process.env.ADMIN_ADDRESS }); // Assuming ADMIN_ADDRESS is set in .env
        const gasPrice = await web3.eth.getGasPrice();
        const data = tx.encodeABI();

        const signedTx = await web3.eth.accounts.signTransaction(
            { to: process.env.CONTRACT_ADDRESS, data, gas, gasPrice, from: process.env.ADMIN_ADDRESS },
            process.env.PRIVATE_KEY
        );

        const receipt = await web3.eth.sendSignedTransaction(signedTx.rawTransaction);
        return receipt;
    } catch (error) {
        console.error("Error granting patent:", error);
        throw error;
    }
}

// Get patent details from the blockchain
async function getPatentDetailsFromBlockchain(patentId) {
    try {
        const result = await contract.methods.getPatentDetails(patentId).call();
        return result;
    } catch (error) {
        console.error("Error fetching patent details:", error);
        throw error;
    }
}

// Get all patents owned by a specific address
async function getOwnerPatentsFromBlockchain(ownerAddress) {
    try {
        const result = await contract.methods.getOwnerPatents(ownerAddress).call();
        return result;
    } catch (error) {
        console.error("Error fetching owner patents:", error);
        throw error;
    }
}

// Search for patents by title or abstract
async function searchPatentsOnBlockchain(query) {
    try {
        const result = await contract.methods.searchPatents(query).call();
        return result;
    } catch (error) {
        console.error("Error searching patents:", error);
        throw error;
    }
}

module.exports = {
    registerPatentOnBlockchain,
    transferPatentOnBlockchain,
    renewPatentOnBlockchain,
    grantPatentOnBlockchain,
    getPatentDetailsFromBlockchain,
    getOwnerPatentsFromBlockchain,
    searchPatentsOnBlockchain
};
