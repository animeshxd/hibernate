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

        var user = new User();
        user.setName("a user")
            .setAddress(new Address("ABC", 12345));
    
        Post post = new Post();
        post.setTitle("post title 1");
        post.setContent("big description 1");
        post.setUser(user);

        Post post1 = new Post();
        post1.setTitle("post title 2");
        post1.setContent("big description 2");
        post1.setUser(user);

        user.setPosts(List.of(post, post1));

        session.persist(post);
        session.persist(post1);

        session.persist(user);
        session.persist(user.getAddress());

        session.getTransaction().commit();

        session.close();

        session = factory.openSession();
        var usr = session.get(User.class, 1);
        System.out.println(((Post)usr.getPosts().toArray()[1]).getUser());

        session.close();
    }
}
