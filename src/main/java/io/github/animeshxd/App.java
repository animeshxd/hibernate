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

        try {
            Session session = factory.openSession();
            
            var query = session.createQuery("from User where id = 1", User.class)
                                // .setHint("org.hibernate.cacheable", true);
                                .setCacheable(true);

            
            print(query.list());

            session.close();

            session = factory.openSession();

            query = session.createQuery("from User where id = 1", User.class)
                            // .setHint("org.hibernate.cacheable", true)
                            .setCacheable(true);
            
            print(query.list());

            session.close();
        }
        finally {
            print("terminating...");
            factory.close(); // Required for cache termination, program
        }
    }

    static void print(Object ... p){
        for(Object o: p){
            System.out.println(o);
        }
    }
}
