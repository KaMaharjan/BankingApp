package dao.mongo;

import dao.AccountNoteDAO;
import model.AccountNote;

import java.util.Date;
import java.util.List;

public class MongoAccountNoteDAO implements AccountNoteDAO {
    @Override
    public AccountNote create(AccountNote accountNote) {
        return null;
    }

    @Override
    public List<AccountNote> findByIdAndTag(long id, String tag) {
        return List.of();
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
