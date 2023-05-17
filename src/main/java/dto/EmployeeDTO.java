package dto;

import model.City;
import model.Employee;

import java.util.List;

public interface EmployeeDTO {

    void create(Employee employee);

    Employee readById(int id);

    List<Employee> readAll();

    void updateById(int id);

    void deleteById(int id);
}
