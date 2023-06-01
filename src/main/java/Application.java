import dao.CityDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;
import org.apache.log4j.BasicConfigurator;

import java.sql.*;

public class Application {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = new Employee();
        employee.setFirstName("Koly");
        employee.setLastName("Ivanov");
        employee.setGender("m");
        employee.setAge(34);
        employee.setCity(1);
        employeeDAO.create(employee);
        System.out.println(employee);
    }
}




