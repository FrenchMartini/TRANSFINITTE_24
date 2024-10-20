const express = require('express');
const router = express.Router();
const { registerPatent, transferPatent,renewPatent,getPatentDetails}= require('../controllers/patentController');

// Route to register a patent
router.post('/register', registerPatent);

// Route to transfer a patent
router.post('/transfer', transferPatent);

// Route to renew a patent
router.post('/renew', renewPatent);

router.get('/patentDetails',getPatentDetails)

module.exports = router;

