package io.github.animeshxd;

import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity(name = "users_entity")
public class User {

    @Id
    private int id;

    @Column(name = "full_name")
    private String name;

    @Transient
    private int age;

    private String email;

    @Basic(optional = false)
    private Date date;

    public User(int id, String name, int age, String email, Date date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.date = date;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
        
    public Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date2) {
        this.date = date2;
    }
    
}
