package dao;

import model.City;
import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee);

    Employee readById(int CityId);

    List<Employee> readAll();

    void updateById(int CityId, String firstName, String lastName, String gender, int age);

    void deleteById(int id);
}
