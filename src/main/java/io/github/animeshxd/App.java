package io.github.animeshxd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();

        var car = new Car("AM","blue");
        session.persist(car);

        var printer = new Printer("AM+", true);
        session.persist(printer);

        session.getTransaction().commit();
        session.close();
    }
}
