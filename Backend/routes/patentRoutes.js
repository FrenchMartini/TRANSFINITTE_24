const express = require('express');
const router = express.Router();
const { registerPatent, transferPatent}= require('../controllers/patentController');

// Route to register a patent
router.post('/register', registerPatent);

// Route to transfer a patent
router.post('/transfer', transferPatent);

module.exports = router;

