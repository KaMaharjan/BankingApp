package dao.postgres;

import dao.CustomerDAO;
import database.DatabaseConnection;
import model.Customer;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class PostgresCustomerDAO implements CustomerDAO {
    @Override
    public Customer create(Customer customer) {
        String sql = "INSERT INTO users (first_name, last_name, username, password) VALUES (?, ?, ?, ?)";
        String sql2 = "INSERT INTO customer (id) VALUES (?)";
        long id = 0;
        DatabaseConnection dbConnection = new DatabaseConnection();
        // nested try statements to autoclose statements
        try(
                Connection connection = dbConnection.getConnection();
                PreparedStatement userStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);)
        {
            userStatement.setString(1, customer.getName().firstName());
            userStatement.setString(2, customer.getName().lastName());
            userStatement.setString(3, customer.getCredentials().username());
            userStatement.setString(4, customer.getCredentials().password());
            userStatement.executeUpdate();
            try(ResultSet rs = userStatement.getGeneratedKeys();
                PreparedStatement customerStatement = connection.prepareStatement(sql2);){
                if(rs.next()){
                    id = rs.getLong(1);
                }else{
                    throw new IllegalStateException("Unable to insert customer record.");
                }
                customerStatement.setLong(1, id);
                customerStatement.executeUpdate();
            }
            return new Customer(id, customer.getName(), customer.getCredentials());
        } catch (SQLException e){
            throw new RuntimeException("Unable to create a Customer.", e);
        }
    }

    @Override
    public Optional<Customer> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
