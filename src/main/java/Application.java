import dto.CityDAOImpl;
import dto.EmployeeDAOImpl;
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
        City city = new City("Moscow");
        cityDAO.create(city);
        City moscow = cityDAO.findByName("Moscow");
        Employee ivan = new Employee("Ivan", "Sidorov", "m", 42, moscow);
        employeeDAO.create(ivan);
        System.out.println(employeeDAO.readById(2));
    }
}

