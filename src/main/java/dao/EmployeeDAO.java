package dao;

import model.City;
import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee);

    Employee readById(int Id);

    void updateById(Employee employee);

    void deleteById(int id);

    List<Employee> readAll();
}
