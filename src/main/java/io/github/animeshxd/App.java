package io.github.animeshxd;


import java.util.List;

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

        var user = new User("A user");

        var t1 = new Tag("java");
        var t2 = new Tag("python");
        var t3 = new Tag("c++");
        var t4 = new Tag("dart");
        var t5 = new Tag("js");
        var t6 = new Tag("lang");


        var p1 = new Post("title 1");
        var p2 = new Post("title 2");
        var p3 = new Post("title 3");


        p1.setContent("java is a piece of").addTags(t1, t6);
        p2.setContent("dart seems like python, java, c++").addTags(t1, t2, t3, t4, t5, t6);
        p3.setContent("c++ is ...").addTags(t3, t6);

        // p1.setUser(user);
        // p2.setUser(user);
        // p3.setUser(user);
        user.addPosts(p1, p2, p3);

        // t1.addPosts(p1, p2);
        // t2.addPosts(p2);
        // t3.addPosts(p2, p3);
        // t4.addPosts(p2);
        // t5.addPosts(p2, p3);
        // t6.addPosts(p1, p2, p3);

        session.persist(user); 
        // Because of CascadeType.PERSIST all related entity objects will be automatically persisted

        // session.persist(p1);
        // session.persist(p2);
        // session.persist(p3);

        // for (Tag t : List.of(t1, t2, t3, t4, t5, t6)) {
        //     session.persist(t);
        // }

        session.getTransaction().commit();

        session.close();

        session = factory.openSession();

        var t = session.find(Tag.class, "lang");
        System.out.println(t);


        session.close();
    }
}
