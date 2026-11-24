package dao.postgres;

import dao.BankAccountDAO;
import database.DatabaseConnection;
import model.BankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PostgresBankAccountDAO implements BankAccountDAO {
    @Override
    public BankAccount create(BankAccount bankAccount) {
        String sql = "INSERT INTO bank_account (customer, balance, account_types) VALUES (?, ?, ?)";
        DatabaseConnection dbConnection = new DatabaseConnection();
        try(
            Connection connection = dbConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setLong(1, bankAccount.getCustomer().getId());
                statement.setDouble(2, bankAccount.getBalance());
                statement.setString(3, bankAccount.type.toString());

                statement.executeUpdate();
            } catch (SQLException e){
            throw new RuntimeException("Unable to create a new Bank Account.");
        }
        return bankAccount;
    }

    @Override
    public Optional<BankAccount> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<BankAccount> findByCustomerId(long id) {
        return List.of();
    }

    @Override
    public List<BankAccount> findAll() {
        return List.of();
    }

    @Override
    public void update(BankAccount bankAccount) {

    }

    @Override
    public void delete(BankAccount bankAccount) {

    }
}
