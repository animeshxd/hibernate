package io.github.animeshxd;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;


public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("main");
        EntityManager session = entityManagerFactory.createEntityManager();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        session.getTransaction().begin();

        CriteriaUpdate<User> updateQuery = builder.createCriteriaUpdate(User.class);
        Root<User> root = updateQuery.from(User.class);
        updateQuery.set(root.get("name"), "A++").where(builder.equal(root.get("id"), 1));

        session.createQuery(updateQuery).executeUpdate(); 
    //  session.createMutationQuery(updateQuery).executeUpdate(); // [hibernate 6]

        session.getTransaction().commit();

        session.getTransaction().begin();
        CriteriaDelete<User> deleteQuery = builder.createCriteriaDelete(User.class);
        root = deleteQuery.from(User.class);
        deleteQuery.where(builder.equal(root.get("id"), 1));

        session.createQuery(deleteQuery).executeUpdate();
    //  session.createMutationQuery(deleteQuery).executeUpdate(); // [hibernate 6]

        session.getTransaction().commit();

        session.close();
        entityManagerFactory.close();
    }

    static void print(Object ... p){
        for(Object o: p){
            System.out.println(o);
        }
    }
}
