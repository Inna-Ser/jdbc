package dao;

import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utiis.HibernateSessionFactoryUtils;

import java.util.List;

public class CityDAOImpl implements CityDAO {

    @Override
    public void create(City city) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City findByName(String cityName) {
        return HibernateSessionFactoryUtils.getSessionFactory().openSession().get(City.class, cityName);
    }

    @Override
    public City readById(int id) {
        return HibernateSessionFactoryUtils.getSessionFactory().openSession().get(City.class, id);
    }

    @Override
    public List<City> readAll() {
        return HibernateSessionFactoryUtils.getSessionFactory().openSession().createQuery("FROM City").list();
    }

    @Override
    public void updateById(int id) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update("id");
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
