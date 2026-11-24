package dao.postgres;

import dao.CustomerDAO;
import model.Customer;

import java.util.List;
import java.util.Optional;

public class PostgresCustomerDAO implements CustomerDAO {
    @Override
    public Customer create(Customer customer) {
        return null;
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
