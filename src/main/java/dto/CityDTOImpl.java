package dto;

import model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CityDTOImpl implements CityDTO {
    private final Connection connection;

    public CityDTOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(City city) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO city (city_name) VALUES (?)")) {
            statement.setString(1, city.getCityName());
//            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public City readById(int id) {
        return null;
    }

    @Override
    public List<City> readAll() {
        return null;
    }

    @Override
    public void updateById(int id) {

    }

    @Override
    public void deleteById(int id) {

    }
}
