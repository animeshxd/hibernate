package io.github.animeshxd;

import java.util.Date;

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
        user.setId(10).setName("abc").setAge(20).setDate(new Date()).setEmail("asdf@ghj.kl");
        user.setDescription("hello".repeat(25));
        var addr = new Address();
        addr.setPincode(123456);
        addr.setStreet("street");
        addr.setState("state");
        addr.setVillage("village");
        user.setAddress(addr);


        session.persist(user);

        session.getTransaction().commit();

        user = session.get(User.class, "10");
        System.out.println(user);
        session.close();
    }
}
