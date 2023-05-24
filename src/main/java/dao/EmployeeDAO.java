package dao;

import model.City;
import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee);

    Employee readById(int id);

    List<Employee> readAll();

    void updateById(int id, String firstName, String lastName, String gender, int age, City city);

    void deleteById(int id);
}
