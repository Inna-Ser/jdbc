package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private int cityId;
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
