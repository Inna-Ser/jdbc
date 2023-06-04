package utiis;

import model.City;
import org.hibernate.cfg.Configuration;
import model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactoryUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Employee.class);
                configuration.addAnnotatedClass(City.class);
                sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build());
            } catch (Exception e) {
                System.out.println("Искличение!" + e);
            }
        }
        return sessionFactory;
    }
}