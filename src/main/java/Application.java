import dto.EmployeeDTO;
import dto.EmployeeDTOImpl;
import lombok.SneakyThrows;
import model.City;
import model.Employee;
import sun.jvm.hotspot.types.CIntegerType;
import java.*;

import java.sql.*;

public class Application {
    @SneakyThrows
    public static void main(String[] args) {

        final String user = "postgres";
        final String password = "3502miii";
        final String url = "jdbc:postgresql://localhost:5432/postgres";

        Connection connection = DriverManager.getConnection(url, user, password);
        EmployeeDTOImpl employeeDTO = new EmployeeDTOImpl(connection);
//        City kursk = new City(6, "Kursk");
//        Employee ivan = new Employee(6, "Ivan", "Sidorov", "m", 42, kursk);
//        employeeDTO.create(ivan);
        System.out.println(employeeDTO.readById(4));


    }
}
