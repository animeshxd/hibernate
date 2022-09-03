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

        var p = new Product("A"); 
        session.persist(p); // id: 1

        var car = new Car("AM","blue");
        session.persist(car); // id: 2

        var printer = new Printer("AM+", true);
        session.persist(printer); //id: 3

        session.getTransaction().commit();
        session.close();
        session = factory.openSession();

        p = session.get(Product.class, 2);
        System.out.println(p);

        printer = null;
        printer = (Printer)session.get(Product.class, 3);
        System.out.println(printer);

        printer = null;
        printer = session.get(Printer.class, 3);
        System.out.println(printer);


        session.close();
    }
}
