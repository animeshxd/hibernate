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

        // var p = new Product("A"); // can't be entity
        // session.persist(p); // id: 1

        var car = new Car("AM","blue");
        session.persist(car); // id: 1

        var printer = new Printer("AM+", true);
        session.persist(printer); //id: 1

        session.getTransaction().commit();
        session.close();
        session = factory.openSession();

        var p = session.get(Car.class, 1);
        System.out.println(p);

        printer = null;
        printer = session.get(Printer.class, 1);
        System.out.println(printer);

        printer.setName("Updated AM++");
        printer.setInk(false);
        session.merge(printer); // UPDATE

        printer = session.get(Printer.class, 1);
        System.out.println(printer);

        session.remove(printer); // REMOVE

         printer = session.get(Printer.class, 1);
        System.out.println(printer);
        

        session.close();
    }
}
