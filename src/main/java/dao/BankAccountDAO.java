package dao;

import model.BankAccount;

import java.util.List;
import java.util.Optional;

public interface BankAccountDAO {
    BankAccount create(BankAccount bankAccount); // unsure how it's being handled atm
    Optional<BankAccount> findById(long id);
    List<BankAccount> findByCustomerId(long id);
    List<BankAccount> findAll();
    void update(BankAccount bankAccount);
    void delete(BankAccount bankAccount);
}
