package dao;

import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utiis.HibernateSessionFactoryUtils;

import java.util.List;

public class CityDAOImpl implements CityDAO {

    @Override
    public City create(City city) {
        City city1 = new City();
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            if (!city1.equals(session.get(City.class, city.getCityName()))) {
                session.save(city1);
                transaction.commit();
            }
            return city;
        }
    }


    @Override
    public City findByName(String cityName) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            return session.get(City.class, cityName);
        }
    }

    @Override
    public City readById(int id) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> readAll() {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM City").list();
        }
    }

    @Override
    public void updateCity(City city) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove("id");
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(city);
            transaction.commit();
        }
    }
}
