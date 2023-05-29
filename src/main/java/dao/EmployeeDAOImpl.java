package dao;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utiis.HibernateSessionFactoryUtils;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void create(Employee employee) {
        try(Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee readById(int id) {
        return HibernateSessionFactoryUtils.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public void updateById(Employee employee) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete("id");
            transaction.commit();
        }
    }

    @Override
    public List<Employee> readAll() {
        return HibernateSessionFactoryUtils.getSessionFactory().openSession().createQuery("FROM Employee ").list();
    }
}
