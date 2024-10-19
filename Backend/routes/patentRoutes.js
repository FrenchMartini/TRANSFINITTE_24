const express = require('express');
const router = express.Router();

const { registerPatent, transferPatent } = require('../controllers/patentController');
router.post('/register', registerPatent);
router.post('/transfer', transferPatent);
module.exports = router;
