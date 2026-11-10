package dao;

import model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {
    Customer create(Customer customer);
    Optional<Customer> findById(long id);
    List<Customer> findAll();
    void update(Customer customer);
    void delete(Customer customer);
}
