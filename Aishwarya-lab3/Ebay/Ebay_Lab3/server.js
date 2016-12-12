var express = require('express'),
    app = express(),
    mongoose = require('mongoose'),
    bodyParser = require('body-parser'),
    config = require('./app/config/config'),
    multer  = require('multer'),
    morgan = require('morgan');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));
app.use(morgan('dev'));

app.use(express.static(__dirname + '/public'));


// Product Api
var productRouter = require('./app/routes/ProductRoutes')(connection);
app.use('/api/products', productRouter);

// Catalog Api
var catalogRouter = require('./app/routes/CatalogRoutes.js')(connection);
app.use('/api/catalog', catalogRouter);

// Orders Api
var ordersRouter = require('./app/routes/OrderRoutes')(connection);
app.use('/api/orders', ordersRouter);

//User Api
var userRouter = require('./app/routes/UserRouters')(connection);
app.use('/api/user', userRouter);

// Front end url
app.get('*', function (req, res) {
    res.sendFile(__dirname + '/public/index.html');
});

app.listen(config.PORT, function () {
    console.log('App is running on port: ' + config.PORT);
});
