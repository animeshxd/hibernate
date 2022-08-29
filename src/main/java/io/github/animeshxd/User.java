package io.github.animeshxd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "users_entity")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) // autoincrement for postgresql
    private int id;

    private String name;

    @OneToOne
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public User setAddress(Address address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "User [address=" + address + ", id=" + id + ", name=" + name + "]";
    }

    

}
