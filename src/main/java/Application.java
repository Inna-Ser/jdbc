import dao.CityDAOImpl;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "3502miii";
        final String url = "jdbc:postgresql://localhost:5432/postgres";

        Connection connection = DriverManager.getConnection(url, user, password);
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(connection);
        CityDAOImpl cityDAO = new CityDAOImpl(connection);
        City moscow = cityDAO.findByName("Moscow");
        if (moscow == null) {
            cityDAO.create(new City("Moscow"));
            moscow = cityDAO.findByName("Moscow");
        }
        Employee ivan = new Employee("Ivan", "Sidorov", "m", 42, moscow);
        employeeDAO.create(ivan);
        employeeDAO.updateById(1, "Artur", "Petrov", "m", 25);
            System.out.println(employeeDAO.readAll());

        }
    }




