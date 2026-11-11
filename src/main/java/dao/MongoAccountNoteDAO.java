package dao;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.AccountNote;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class MongoAccountNoteDAO implements AccountNoteDAO {

    private final String uri;
    private final MongoDatabase db;

    public MongoAccountNoteDAO(String uri) {
        this.uri = uri;
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            this.db = mongoClient.getDatabase("bankingapp");
        }
    }

    @Override
    public AccountNote create(AccountNote accountNote) {
        return null;
    }

    @Override
    public List<AccountNote> findByTag(String tag) {
        return List.of();
    }

    @Override
    public Optional<AccountNote> retrieve(AccountNote accountNote) {
        return Optional.empty();
    }

    @Override
    public List<AccountNote> filter(AccountNote.Category category) {
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
