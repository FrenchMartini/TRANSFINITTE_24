// patentController.js
const { registerPatentOnBlockchain, transferPatentOnBlockchain } = require('../services/blockchain');

const registerPatent = async (req, res) => {
    const { title, description } = req.body;
    try {
        // Call your blockchain function here
        const result = await registerPatentOnBlockchain(title, description, req.body.userAddress);
        return res.status(200).json({ message: 'Patent registered successfully!', data: result });
    } catch (error) {
        return res.status(500).json({ message: 'Error registering patent', error: error.message });
    }
};

const transferPatent = async (req, res) => {
    const { patentId, toAddress } = req.body;
    try {
        // Call your blockchain function here
        const result = await transferPatentOnBlockchain(patentId, req.body.fromAddress, toAddress);
        return res.status(200).json({ message: 'Patent transferred successfully!', data: result });
    } catch (error) {
        return res.status(500).json({ message: 'Error transferring patent', error: error.message });
    }
};

module.exports = { registerPatent, transferPatent };

