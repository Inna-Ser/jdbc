package dao;

import model.City;

import java.util.List;

public interface CityDAO {

    City create(City city);

    City findByName(String city_name);

    City readById(int id);

    List<City> readAll();

    void updateCity(City city);

    void deleteById(int id);

    void deleteCity(City city);
}
