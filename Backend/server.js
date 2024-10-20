const express = require('express');
const bodyParser = require('body-parser');
const patentRoutes = require('./routes/patentRoutes'); // Adjust the path as needed
require('dotenv').config();

const app = express();
const PORT = process.env.PORT || 3000;

// Middleware to parse JSON bodies
app.use(bodyParser.json());

// Use the patent routes
app.use('/', patentRoutes);

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
