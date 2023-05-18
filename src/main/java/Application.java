import dto.CityDTOImpl;
import dto.EmployeeDTO;
import dto.EmployeeDTOImpl;
import lombok.SneakyThrows;
import model.City;
import model.Employee;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException{

        final String user = "postgres";
        final String password = "3502miii";
        final String url = "jdbc:postgresql://localhost:5432/postgres";

        Connection connection = DriverManager.getConnection(url, user, password);
        EmployeeDTOImpl employeeDTO = new EmployeeDTOImpl(connection);
        City moscow = new City(8,"Moscow");
        Employee ivan = new Employee("Ivan", "Sidorov", "m", 42, moscow.getCityId());
        employeeDTO.create(ivan);
        System.out.println(employeeDTO.readById(2));


    }
}
