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

        var user = new User();
        user.appendAddresses(new Address("city A", 1));
        user.appendAddresses(new Address("city B", 2));
        user.appendAddresses(new Address("city C", 3));
    
        session.persist(user);
        session.getTransaction().commit();

        session.close();
    }
}
