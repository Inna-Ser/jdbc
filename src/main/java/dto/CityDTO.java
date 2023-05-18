package dto;

import model.City;
import model.Employee;

import java.util.List;

public interface CityDTO {

    void create(City city);

    City readById(int id);

    List<City> readAll();

    void updateById(int id);

    void deleteById(int id);
}
