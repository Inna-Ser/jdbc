package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String gender;
    private Integer age;
    @Column(name = "citi_id")
    private Integer city;

    public Employee(String firstName, String lastName, String gender, Integer age, Integer city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

//        public static Employee create(ResultSet resultSet) throws SQLException {
//        Employee employee = new Employee();
//        employee.setId(resultSet.getInt("id"));
//        employee.setFirstName(resultSet.getString("first_name"));
//        employee.setLastName(resultSet.getString("last_name"));
//        employee.setGender(resultSet.getString("gender"));
//        employee.setAge(resultSet.getInt("age"));
//        employee.setCity(new City(resultSet.getString("city_name")));
//        return employee;
//    }
}
