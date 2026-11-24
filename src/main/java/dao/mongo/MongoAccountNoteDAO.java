package dao.mongo;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import dao.AccountNoteDAO;
import model.AccountNote;
import org.bson.Document;

import java.util.*;

public class MongoAccountNoteDAO implements AccountNoteDAO {

    private final String uri;
    private final MongoDatabase db;

    public MongoAccountNoteDAO(String uri) {
        this.uri = uri;
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            this.db = mongoClient.getDatabase("bankingapp");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid database name supplied");
        }
    }

    @Override
    public void create(AccountNote note) {
        try {
            MongoCollection<Document> accountNotes = db.getCollection("account_notes");

            InsertOneResult result = accountNotes.insertOne(
                    new Document("bankAccountId", note.bankAccountId())
                            .append("authorId", note.authorId())
                            .append("note", note.note())
                            .append("timestamp", note.timestamp())
                            .append("transactionId", note.transactionId())
                            .append("tags", Collections.singletonList(note.tags()))
            );

            assert result.wasAcknowledged();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid database name supplied");
        } catch (MongoException e) {
            throw new MongoException("Mongo - failed to insert Account Note");
        } catch (AssertionError e) {
            throw new MongoException("Mongo - insert was not acknowledged.");
        }
    }

    @Override
    public Optional<AccountNote> retrieve(AccountNote accountNote) {
        return Optional.empty();
    }

    @Override
    public List<AccountNote> filter(String tag) {
        return List.of();
    }

    @Override
    public List<AccountNote> filter(long id, String tag) {
        return List.of();
    }

    @Override
    public List<AccountNote> filter(long id) {
        return List.of();
    }

    @Override
    public List<AccountNote> filter(Date date) {
        return List.of();
    }

    @Override
    public void update(AccountNote accountNote) {

    }

    @Override
    public void delete(AccountNote accountNote) {

    }
}
