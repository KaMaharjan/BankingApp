package dao.postgres;

import dao.TransactionDAO;
import model.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PostgresTransactionDAO implements TransactionDAO {
    @Override
    public Transaction create(Transaction transaction) {
        return null;
    }

    @Override
    public Optional<Transaction> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Transaction> findByCustomerId(long id) {
        return List.of();
    }

    @Override
    public List<Transaction> filter(Date date) {
        return List.of();
    }

    @Override
    public List<Transaction> filter(Date startDate, Date endDate) {
        return List.of();
    }

    @Override
    public List<Transaction> filter(Transaction.Type type) {
        return List.of();
    }
}
