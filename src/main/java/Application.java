import dao.CityDAO;
import dao.CityDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

public class Application {

    public static void main(String[] args) {
        CityDAO cityDAO = new CityDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        City city = new City("Orel");


        Employee danil = new Employee();
        danil.setFirstName("Toly");
        danil.setLastName("Glebov");
        danil.setGender("m");
        danil.setAge(19);
        danil.setCity(city);

        employeeDAO.create(danil);
//
//        Employee employee = employeeDAO.readById(3);
//        employee.setFirstName("Natasha");
//        employeeDAO.updateById(employee);

//        Employee employee = employeeDAO.readById(65);
//        employeeDAO.deleteEmployee(employee);
//        City city = cityDAO.readById(4);
//        cityDAO.deleteCity(city);
//        City city12 = cityDAO.readById(12);
//        cityDAO.deleteCity(city12);
        System.out.println(employeeDAO.readAll());
        System.out.println(cityDAO.readAll());
    }
}




