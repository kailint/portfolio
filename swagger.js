const swaggerUi = require('swagger-ui-express');
const yaml = require('js-yaml');
const fs = require('path');

//loading via yml.safeLoad to avoid errors with special characters during processing
const swaggerDocument = yaml.safeLoad(fs.readFileSync(path.resolve(__dirname, '../swagger.yml'), 'utf8'));

module.exports = (app) => {
    //serves swagger API documentation to /docs url
    app.use('/docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));
}