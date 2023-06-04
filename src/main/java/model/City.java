package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Entity
@Table(name="city")
@Data
@ToString(of = {"cityId", "cityName"})
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city", fetch = FetchType.EAGER)
    private List<Employee> employees;

    public City(String cityName) {
        this.cityName = cityName;
    }
}
