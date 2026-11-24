package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConnection {

    private static MongoClient mongoClient;

    public static MongoClient connect() throws IllegalStateException {
        if (mongoClient == null) {
            String uri = loadURIFromDotEnvFile();

            if (uri == null || uri.isEmpty()) {
                throw new IllegalStateException();
            }

            mongoClient = MongoClients.create(uri);
        }

        mongoClient.getDatabase("mongodb").listCollections();

        return mongoClient;
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }

    private static String loadURIFromDotEnvFile() {
        return ""; // TODO
    }
}
