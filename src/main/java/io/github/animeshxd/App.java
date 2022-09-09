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
                                         
        Query<User> query = session.createQuery("from User where id > :id and name = :name", User.class);
        query.setParameter("id", 5);
        query.setParameter("name", "X");

        System.out.println(query.list());
        
        session.close();
    }
}
