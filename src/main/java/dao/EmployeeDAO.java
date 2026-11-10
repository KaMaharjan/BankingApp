package dao;

import model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    Employee create(Employee e); // unsure how it's being handled atm
    Optional<Employee> findById(long id);
    List<Employee> findAll();
    void update(Employee employee);
    void delete(Employee employee);
}
