package dao;

import model.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionDAO {
    Transaction create(Transaction transaction);
    Optional<Transaction> findById(long id);
    List<Transaction> findByCustomerId(long id);
    List<Transaction> filter(Date date); // single day
    List<Transaction> filter(Date startDate, Date endDate); // date range
    List<Transaction> filter(Transaction.Type type); // withdraw or deposit
}
