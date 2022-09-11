package io.github.animeshxd;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;


public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        session.beginTransaction();

        CriteriaUpdate<User> updateQuery = builder.createCriteriaUpdate(User.class);
        Root<User> root = updateQuery.from(User.class);
        updateQuery.set(root.get("name"), "A++").where(builder.equal(root.get("id"), 1));

        session.createQuery(updateQuery).executeUpdate(); 
    //  session.createMutationQuery(updateQuery).executeUpdate(); // [hibernate 6]

        session.getTransaction().commit();

        session.beginTransaction();
        CriteriaDelete<User> deleteQuery = builder.createCriteriaDelete(User.class);
        root = deleteQuery.from(User.class);
        deleteQuery.where(builder.equal(root.get("id"), 1));

        session.createQuery(deleteQuery).executeUpdate();
    //  session.createMutationQuery(deleteQuery).executeUpdate(); // [hibernate 6]

        session.getTransaction().commit();

        session.close();
        factory.close();
    }

    static void print(Object ... p){
        for(Object o: p){
            System.out.println(o);
        }
    }
}
