import dao.CityDAO;
import dao.CityDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;
import org.apache.log4j.BasicConfigurator;

import java.sql.*;

public class Application {

    public static void main(String[] args) {
        CityDAO cityDAO = new CityDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

//        Employee danil = new Employee();
//        danil.setFirstName("Danil");
//        danil.setLastName("Volkov");
//        danil.setGender("m");
//        danil.setAge(19);
//        City riazan = new City();
//        riazan.setCityName("Riazan");
//
//        cityDAO.create(riazan);
//        employeeDAO.deleteById(64);
//        employeeDAO.deleteById(65);
//        employeeDAO.updateById(2, "Oleg", "dsa", "m", 17, );
        City city6 = cityDAO.readById(6);
        cityDAO.deleteCity(city6);
        System.out.println(city6);
        System.out.println(employeeDAO.readAll());
        System.out.println(cityDAO.readAll());
    }
}




