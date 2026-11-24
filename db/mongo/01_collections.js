db = db.getSiblingDB("bankingapp");
db.createCollection("accountNotes", {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            title: "Account Note Object Validation",
            required: [ "bankAccountId", "authorId", "note", "timestamp", "tags" ],
            properties: {
                bankAccountId: {
                    bsonType: "long",
                    description: "unique ID for each bank account"
                },
                authorId: {
                    bsonType: "long",
                    description: "unique ID for authoring employee"
                },
                note: {
                    bsonType: "string",
                    description: "note transcribed by authoring employee"
                },
                timestamp: {
                    bsonType: "date",
                    description: "note creation timestamp including date and time"
                },
                transactionId: {
                    bsonType: ["long", "null"],
                    description: "optional value: holds the unique transaction ID or null if no transaction was related"
                },
                tags: {
                    bsonType: "array",
                    description: "array of tags attached to the note, could be empty"
                }
            }
        }
    },
    validationLevel: "strict",
    validationAction: "error"
});
db.accountNotes.createIndex({ tags: 1 }, { name: "idx_tags" });