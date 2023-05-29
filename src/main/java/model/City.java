package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
@Entity
@Table(name="city")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city_name")
    private String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public static City create(ResultSet resultSet) throws SQLException {
        City city = new City();
        city.setCityId(resultSet.getInt("city_id"));
        city.setCityName(resultSet.getNString("city_name"));
        return city;
    }
}
