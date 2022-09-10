package io.github.animeshxd;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;



public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Double> query = builder.createQuery(Double.class);
        
        Root<User> root = query.from(User.class);

        // query.select(builder.count(root)); // CriteriaQuery<Long>
        //query.select(builder.max(root.get("id"))); // CriteriaQuery<Integer>
        query.select(builder.avg(root.get("id"))); // CriteriaQuery<Double>

        
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
