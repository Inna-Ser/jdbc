package dao;

import model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    private final Connection connection;

    public CityDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(City city) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO city (city_name) VALUES (?)")) {
            statement.setString(1, city.getCityName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public City findByName(String cityName) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM city WHERE city_name=(?)")) {
            statement.setString(1, cityName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                City city = new City();
                city.setCityId(resultSet.getInt("city_id"));
                city.setCityName(resultSet.getString("city_name"));
                return city;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
