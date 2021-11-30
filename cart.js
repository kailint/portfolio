const db = require('../index');
const moment = require('moment');
const pgp = require('pg-promise')({capSQL: true});

module.exports = class CartModel {
    constructor(data = {}) {
        this.created = data.created || moment.utc().toISOString();
        this.modified = moment.utc().toISOString();
        this.converted = data.converted || null;
        this.isActive = data.isActive || true;
    }

    /**
     * creates a new cart for a user
     * @param   {Object}         data [User data]
     * @return  {object|null}        [created user record]
     */
    async create(userId) {
        try {
            const data = {userId, ...this}

            //generate SQL statement - using helper for dynamic parameter injection
            const statement = pgp.helpers.insert(data, null, 'carts') + 'RETURNING *';

            //execute SQL statement
            const result = await db.query(statement);

            if (result.rows?.length) {
                return result.rows[0];
            }
            return null;
        }

        catch (err) {
            throw new Error(err);
        }
    }

    /**
     * loads a cart by user id
     * @param       {numbner}       id [User ID]
     * @return      {Object|null}       [cart record]
     */
    static async findOneByUser(userId) {
        try {
            //generate SQL statement
            const statement = `SELECT *
                               FROM carts
                               WHERE "userId" = $1`;
            const values = [userId];

            //execute sql statement
            const result = await db.query(statement, values);

            if (result.rows?.length) {
                return result.rows[0];
            }
            return null;
        }

        catch (err) {
            throw new Error(err);
        }
    }

    /**
     * loads a cart by id
     * @param       {number}        id [Cart ID]
     * @return      {object|null}      [cart record]
     */
    static async findOneById(id) {
        try {
            // generate sql statement
            const statement = `SELECT *
                               FROM carts
                               WHERE id" = $1`;
            const values = [id];

            //execute sql statement
            const result = await db.query(statement, values);

            if (result.rows?.length) {
                return result.rows[0];
            }
            return null;
        }
        
        catch (err) {
            throw new Error(err);
        }
    }
}