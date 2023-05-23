package dao;

import model.City;

import java.util.List;

public interface CityDAO {

    void create(City city);

    City findByName(String city_name);

    City readById(int id);

    List<City> readAll();

    void updateById(int id);

    void deleteById(int id);
}
