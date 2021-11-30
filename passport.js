const passport = require('passport');
const LocalStrategy = require('passport-local');

const AuthService = require('../services/AuthService');
const AuthServiceInstance = new AuthService();

module.exports = (app) => {
    //initialize passport
    app.use(passport.initialize());
    app.use(passport.session());

    //set method to serialize data to store in cookie
    passport.serializeUser((user, done) => {
        done(null, user.id);
    });

    //set method to deserialize data stored in cookie and attach to req.user 
    passport.deserializeUser((id, done) => {
        done(null, {id});
    });

    //configure local strategy to be use for local login
    passport.use(new LocalStrategy(
        async (username, password, done) => {
            try {
                const user = await AuthServiceInstance.login({email: username, password});
                return done(null, user);
            }

            catch (err) {
                return done(err);
            }
        }
    ));

    return passport;
}