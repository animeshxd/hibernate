package io.github.animeshxd;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;



public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        
        Root<User> root = query.from(User.class);
        query.select(root); // query.select(query.from(User.class)); // select from User
        
        var q = session.createQuery(query);
        print(q.list());
        

        session.close();
    }

    static void print(Object ... p){
        for(Object o: p){
            System.out.println(o);
        }
    }
}
