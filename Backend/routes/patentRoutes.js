const express = require('express');
const router = express.Router();
const { registerPatent, transferPatent,renewPatent,getPatentDetails}= require('../controllers/patentController');


router.post('/register', patentController.registerPatent);

router.post('/transfer', patentController.transferPatent);

router.post('/renew', patentController.renewPatent);

router.get('/:patentId', patentController.getPatentDetails);

router.get('/owner/:ownerAddress', patentController.getOwnerPatents);

router.get('/search/:query', patentController.searchPatents);


// Route to renew a patent
router.post('/renew', renewPatent);

router.get('/patentDetails',getPatentDetails)

module.exports = router;

