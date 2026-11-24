package dao.postgres;

import dao.BankAccountDAO;
import dao.CustomerDAO;
import database.DatabaseConnection;
import model.BankAccount;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostgresBankAccountDAO implements BankAccountDAO {
    private final CustomerDAO customerDAO = new PostgresCustomerDAO();
    @Override
    public BankAccount create(BankAccount bankAccount) {

        BankAccount ba = null;
        String sql = "INSERT INTO bank_account (customer_id, account_type) VALUES (?, ?) RETURNING *";
        DatabaseConnection dbConnection = new DatabaseConnection();
        try(Connection connection = dbConnection.getConnection()){

            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setLong(1, bankAccount.getCustomer().getId());
                statement.setString(2, bankAccount.type.name());
                try(ResultSet rs = statement.executeQuery()){
                    if(rs.next()){
                        Customer customer = customerDAO.findById(rs.getLong("customer_id")).orElseThrow(()
                                -> new RuntimeException("Customer not found."));
                        ba = new BankAccount(
                                customer,
                                rs.getLong("id"),
                                rs.getString("account_type")
                        );
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("Unable to create a new Bank Account.", e);
        }
        return ba;
    }

    @Override
    public Optional<BankAccount> findById(long id) {
        Optional<BankAccount> ba = Optional.empty();
        String sql = "SELECT * FROM bank_account WHERE id = ?";

        DatabaseConnection dbConnection = new DatabaseConnection();
        try(Connection connection = dbConnection.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setLong(1, id);
                try(ResultSet rs = statement.executeQuery()){
                    if(rs.next()) {
                        Customer customer = customerDAO.findById(rs.getLong("customer_id")).orElseThrow(()
                                -> new RuntimeException("Customer not found."));
                        ba = Optional.of(new BankAccount(
                                customer,
                                rs.getLong("id"),
                                rs.getString("account_type")
                        ));
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("Unable to find Bank Account.", e);
        }
        return ba;
    }

    @Override
    public List<BankAccount> findByCustomerId(long id) {
        List<BankAccount> list = new ArrayList<>();
        BankAccount ba = null;
        String sql = "SELECT * FROM bank_account WHERE customer_id = ?";

        DatabaseConnection dbConnection = new DatabaseConnection();
        try(Connection connection = dbConnection.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setLong(1, id);
                try(ResultSet rs = statement.executeQuery()){
                    while(rs.next()) {
                        Customer customer = customerDAO.findById(rs.getLong("customer_id")).orElseThrow(()
                                -> new RuntimeException("Customer not found."));
                        ba = new BankAccount(
                                customer,
                                rs.getLong("id"),
                                rs.getString("account_type")
                        );
                        list.add(ba);
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("Unable to find Bank Account.", e);
        }
        return list;
    }

    @Override
    public List<BankAccount> findAll() {
        List<BankAccount> list = new ArrayList<>();
        BankAccount ba = null;
        String sql = "SELECT * FROM bank_account";
        DatabaseConnection dbConnection = new DatabaseConnection();
        try(Connection connection = dbConnection.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                try(ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        Customer customer = customerDAO.findById(rs.getLong("customer_id")).orElseThrow(()
                                -> new RuntimeException("Customer not found."));
                        ba = new BankAccount(
                                customer,
                                rs.getLong("id"),
                                rs.getString("account_type")
                        );
                        list.add(ba);
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("Unable to find Bank Account.", e);
        }
        return list;
    }

    @Override
    public void update(BankAccount bankAccount) {
        String sql = "UPDATE bank_account SET balance = ?, status = ? WHERE id = ?";
        DatabaseConnection dbConnection = new DatabaseConnection();
        try(Connection connection = dbConnection.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setDouble(1, bankAccount.getBalance());
                statement.setString(2, bankAccount.status.name());
                statement.setLong(3, bankAccount.getId());
                if(statement.executeUpdate() == 0){
                    throw new RuntimeException("ID not found.");
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("Unable to update bank account.", e);
        }
    }

    @Override
    public void delete(BankAccount bankAccount) {
        String sql = "DELETE FROM bank_account WHERE id = ?";
        DatabaseConnection dbConnection = new DatabaseConnection();
        try(Connection connection = dbConnection.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setLong(1, bankAccount.getId());
                if(statement.executeUpdate() == 0){
                    throw new RuntimeException("ID not found.");
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("Unable to delete bank account.", e);
        }
    }
}
