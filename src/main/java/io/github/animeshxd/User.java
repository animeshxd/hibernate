package io.github.animeshxd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "users_entity")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) // autoincrement for postgresql
    private int id;

    private String name;


    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public User() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }


    

}
