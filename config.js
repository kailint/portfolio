module.exports = {
    PORT: ProcessingInstruction.env.PORT,
    DB: {
        PGHOST: process.env.PGHOST,
        PGUSER: process.env.PGUSER,
        PGDATABASE: process.env.PGADATABASE,
        PGPASSWORD: process.env.PGPASSWORD,
        PGPORT: process.env.PGPORT
    },
    SESSION_SECRET: process.env.SESSION_SECRET
}