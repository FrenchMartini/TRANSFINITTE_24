// patentController.js
const { registerPatentOnBlockchain, transferPatentOnBlockchain,renewPatentOnBlockchain } = require('../services/blockchain');



// Example of calling a function
// const renewPatent = async (req, res) => {
//     const { patentId, userAddress } = req.body;
//     try {
//         const result = await contract.methods.renewPatent(patentId).send({ from: userAddress });
//         return res.status(200).json({ message: 'Patent renewed successfully!', data: result });
//     } catch (error) {
//         return res.status(500).json({ message: 'Error renewing patent', error: error.message });
//     }
// };
const registerPatent = async (req, res) => {
    const { title, abstractText, description, ipfsHash, userAddress } = req.body;
    try {
        const result = await registerPatentOnBlockchain(title, abstractText, description, ipfsHash, userAddress);
        return res.status(200).json({ message: 'Patent registered successfully!', data: result });
    } catch (error) {
        return res.status(500).json({ message: 'Error registering patent', error: error.message });
    }
};
//  const registerPatent = async (req, res) => {
//     const { title, abstractText, description, ipfsHash } = req.body;
//     try {
//         const result = await registerPatentOnBlockchain(title, abstractText, description, ipfsHash, req.body.userAddress);
//         return res.status(200).json({ message: 'Patent registered successfully!', data: result });
//     } catch (error) {
//         return res.status(500).json({ message: 'Error registering patent', error: error.message });
//     }
// };

const transferPatent = async (req, res) => {
    const { patentId, toAddress, fromAddress } = req.body;
    try {
        if (!patentId || !toAddress) {
            return res.status(400).json({ message: 'patentId and toAddress are required.' });
        }
        // Simulating blockchain call
        const result = await transferPatentOnBlockchain(patentId, toAddress); // Modify this function as per your logic

        return res.status(200).json({ message: 'Patent transferred successfully!', data: result });
    } catch (error) {
        console.error('Error in transferPatent:', error); // More detailed logging
        return res.status(500).json({ message: 'Error transferring patent', error: error.message });
    }
};


const renewPatent = async (req, res) => {
    console.log(req.body); // Log the request body

    const { patentId, userAddress } = req.body;
    try {
        const result = await renewPatentOnBlockchain(patentId, userAddress);
        return res.status(200).json({ message: 'Patent renewed successfully!', data: result });
    } catch (error) {
        console.error(error); // Log the error
        return res.status(500).json({ message: 'Error renewing patent', error: error.message });
    }
};

const getPatentDetails = async (req,res) => {
    try {
        const patentId = req.query;
        const patentDetails = await contract.methods.getPatentDetails(patentId).call();
        // return patentDetails;
        return res.status(200).json({message:'Patent Details :',data:patentDetails})
    } catch (error) {
        throw new Error("Error fetching patent details from blockchain: " + error.message);
    }
};
// router.get('/searchPatents', async (req, res) => {
//     const { query } = req.query;  // Retrieve the search query from the URL

//     try {
//         // Call the smart contract function to search for patents
//         const matchingPatentIds = await searchPatents(query);
//         if (matchingPatentIds.length > 0) {
//             return res.status(200).json({ results: matchingPatentIds });
//         } else {
//             return res.status(404).json({ message: "No patents found matching the query" });
//         }
//     } catch (error) {
//         return res.status(500).json({ message: "Error searching patents", error: error.message });
//     }
// });



module.exports = { registerPatent, transferPatent ,renewPatent,getPatentDetails};


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
