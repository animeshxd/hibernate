package io.github.animeshxd;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
                                         
        Query<User> query = session.createNamedQuery("User.byId", User.class);
        query.setParameter("id", 125);
        System.out.println(query.list());

        query = session.createNamedQuery("User.byName", User.class);
        query.setParameter("name", "C");
        System.out.println(query.list());

        session.close();
    }
}
