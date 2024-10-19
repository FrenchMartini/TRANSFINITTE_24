const { registerPatentOnBlockchain, transferPatentOnBlockchain}= require('../services/blockchain').default.default;
exports.registerPatent = async (req, res) => {
    const { title, description, userAddress } = req.body;
    try {
        const receipt = await registerPatentOnBlockchain(title, description, userAddress);
        res.status(200).json({ message: 'Patent registered successfully', receipt });
    } catch (error) {
        res.status(500).json({ message: 'Error registering patent', error });
    }
};
exports.transferParent = async (req, res) => {
    const { title, description, userAddress } = req.body;
    try {
        const receipt = await transferPatentOnBlockchain(title, description, userAddress);
        res.status(200).json({ message: 'Patent transfered successfully', receipt });
    } catch (error) {
        res.status(500).json({ message: 'Error transfering patent', error });
    }
};

