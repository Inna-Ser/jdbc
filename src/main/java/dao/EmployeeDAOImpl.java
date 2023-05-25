package dao;

import model.City;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.setInt(5, employee.getCity().getCityId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee readById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT * FROM employee e INNER JOIN city c ON e.city_id=c.city_id AND id = (?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setMaxRows(1);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Employee.create(resultSet);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employeeList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                Integer age = Integer.parseInt(resultSet.getString("age"));
                City city = new City(resultSet.getInt("city_id"), resultSet.getString("city_id"));
                employeeList.add(new Employee(id, firstName, lastName, gender, age, city));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void updateById(int id, String firstName, String lastName, String gender, int age) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("UPDATE employee SET first_name = (?), last_name = (?), gender = (?), age = (?) WHERE id = (?)")) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, gender);
            preparedStatement.setInt(4, age);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id = (?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
