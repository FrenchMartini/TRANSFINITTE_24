const { 
    registerPatentOnBlockchain, 
    transferPatentOnBlockchain, 
    renewPatentOnBlockchain, 
    grantPatentOnBlockchain, 
    getPatentDetailsFromBlockchain, 
    getOwnerPatentsFromBlockchain, 
    searchPatentsOnBlockchain 
} = require('../services/blockchain');

const registerPatent = async (req, res) => {
    const { title, abstractText, description, ipfsHash, userAddress } = req.body;
    try {
        const result = await registerPatentOnBlockchain(title, abstractText, description, ipfsHash, userAddress);
        return res.status(200).json({ message: 'Patent registered successfully!', data: result });
    } catch (error) {
        return res.status(500).json({ message: 'Error registering patent', error: error.message });
    }
};

const transferPatent = async (req, res) => {
    const { patentId, toAddress, fromAddress } = req.body;
    try {
        const result = await transferPatentOnBlockchain(patentId, fromAddress, toAddress);
        return res.status(200).json({ message: 'Patent transferred successfully!', data: result });
    } catch (error) {
        return res.status(500).json({ message: 'Error transferring patent', error: error.message });
    }
};

const renewPatent = async (req, res) => {
    const { patentId, userAddress } = req.body;
    try {
        const result = await renewPatentOnBlockchain(patentId, userAddress);
        return res.status(200).json({ message: 'Patent renewed successfully!', data: result });
    } catch (error) {
        return res.status(500).json({ message: 'Error renewing patent', error: error.message });
    }
};

const grantPatent = async (req, res) => {
    const { patentId } = req.body; // Assuming the admin address is retrieved from the request context
    try {
        const result = await grantPatentOnBlockchain(patentId);
        return res.status(200).json({ message: 'Patent granted successfully!', data: result });
    } catch (error) {
        return res.status(500).json({ message: 'Error granting patent', error: error.message });
    }
};

const getPatentDetails = async (req, res) => {
    const { patentId } = req.params;
    try {
        const result = await getPatentDetailsFromBlockchain(patentId);
        return res.status(200).json({ data: result });
    } catch (error) {
        return res.status(500).json({ message: 'Error fetching patent details', error: error.message });
    }
};

const getOwnerPatents = async (req, res) => {
    const { ownerAddress } = req.params;
    try {
        const result = await getOwnerPatentsFromBlockchain(ownerAddress);
        return res.status(200).json({ data: result });
    } catch (error) {
        return res.status(500).json({ message: 'Error fetching owner patents', error: error.message });
    }
};

const searchPatents = async (req, res) => {
    const { query } = req.params;
    try {
        const result = await searchPatentsOnBlockchain(query);
        return res.status(200).json({ data: result });
    } catch (error) {
        return res.status(500).json({ message: 'Error searching patents', error: error.message });
    }
};

module.exports = { 
    registerPatent, 
    transferPatent, 
    renewPatent, 
    grantPatent, 
    getPatentDetails, 
    getOwnerPatents, 
    searchPatents 
};
