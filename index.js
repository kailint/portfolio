const expressLoader = require('./express');
const passportLoader = require('./passport');
const routeLoader = require('../routes');
const swaggerLoader = require('./swagger');
const swagger = require('./swagger');

module.exports = async (app) => {
    //load express middlewares
    const expressApp = await expressLoader(app);

    //load passport middleware
    const passport = await passportLoader(expressApp);

    //load api route handlers
    await routeLoader(app, passport);

    //load swagger
    await swaggerLoader(app);

    //error handler
    app.use((err, req, res, next) => {
        const {message, status} = err;
        return res.status(status).send({message});
    });
}