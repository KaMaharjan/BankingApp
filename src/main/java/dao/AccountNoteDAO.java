package dao;

import model.AccountNote;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AccountNoteDAO {
    AccountNote create(AccountNote accountNote);
    Optional<AccountNote> retrieve(AccountNote accountNote);
    List<AccountNote> filter(long id);
    List<AccountNote> filter(String tag);
    List<AccountNote> filter(long id, String tag);
    List<AccountNote> filter(Date date);
    void update(AccountNote accountNote);
    void delete(AccountNote accountNote);
}
