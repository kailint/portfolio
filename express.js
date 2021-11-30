const bodyParser = require('body-parser');
const cors = require('cors');
const session = require('express-session');
const {SESSION_SECRET} = require('../config');

module.exports = (app) => {
    //enable cross origin resource sharing to all origins by default
    app.use(cors());

    //transforms raw string of reg.body into JSON
    app.use(bodyParser.json());

    //parses urlencoded bodies
    app.use(bodyParser.urlencoded({extended: true}));

    //
    app.set('trust proxy', 1);

    //creates a session
    app.use(
        session({
            secret: SESSION_SECRET,
            resave: false,
            saveUninitialized: false,
            cookie: {
                secure: false,
                maxAge: 24 * 60 * 60 * 1000
            }
        })
    );

    return app;
}