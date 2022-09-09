package io.github.animeshxd;

import java.util.HashMap;


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
        System.out.println(query.list());
        

        Query<String> query_str = session.createQuery("select name from User", String.class);
        System.out.println(query_str.list());
        
        
        var query_map = session.createQuery("select new Map(id, name) from User", HashMap.class);
        System.out.println(query_map.list().get(0));

        query = session.createQuery("from User where name = 'A'", User.class);
        System.out.println(query.list());
        
        var sum = session.createQuery("select count(id) from User", Integer.class);
        System.out.println(sum.list());
        session.close();
    }
}
