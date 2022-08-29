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
        user.setName("a user")
            .setAddress(new Address("ABC", 12345));

        session.persist(user);
        session.persist(user.getAddress());
        session.getTransaction().commit();

        session.close();
    }
}
