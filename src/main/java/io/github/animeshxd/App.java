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

                                                        /**from Entity(name) not Table(name)*/
        Query<User> query = session.createQuery("from User", User.class);
        query.setFirstResult(5);
        query.setMaxResults(7);
        System.out.println(query.list());
        
        session.close();
    }
}
