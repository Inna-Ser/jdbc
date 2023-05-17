import dto.EmployeeDTO;
import dto.EmployeeDTOImpl;
import lombok.SneakyThrows;

import java.sql.*;

public class Application {
    @SneakyThrows
    public static void main(String[] args) {

        final String user = "postgres";
        final String password = "3502miii";
        final String url = "jdbc:postgresql://localhost:5432/postgres";

        Connection connection = DriverManager.getConnection(url, user, password);
        EmployeeDTOImpl employeeDTO = new EmployeeDTOImpl(connection);
        System.out.println(employeeDTO.readById(4));


    }
}
