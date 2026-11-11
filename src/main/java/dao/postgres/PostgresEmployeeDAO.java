package dao.postgres;

import dao.EmployeeDAO;
import model.Employee;

import java.util.List;
import java.util.Optional;

public class PostgresEmployeeDAO implements EmployeeDAO {
    @Override
    public Employee create(Employee e) {
        return null;
    }

    @Override
    public Optional<Employee> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }
}
