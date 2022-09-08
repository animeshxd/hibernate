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

        User user = new User(); //Transient: it is in Transient state untill it got persisted
        user.setId(1);
        System.out.println("is user persist: "+session.contains(user)); // false
        
        session.remove(user); //Persistent: user will be called persisted object untill it got detached, session.detach(), session.close(), session.clear()
                               //with session.persist() any update in user object will be updated when it get commited
                               //session.remove() will detach object and will be removed on commit() and will do nothing if not available
        
        System.out.println("is user persist: "+session.contains(user)); // false
        
        session.getTransaction().commit();
        System.out.println("is user persist: "+session.contains(user)); // false

        session.clear(); // Detached: User object will be detached
        System.out.println("is user persist: "+session.contains(user)); // false

        session.close();         
        System.out.println("is user persist: "+session.contains(user)); // java.lang.IllegalStateException: Session/EntityManager is closed
    }
}
