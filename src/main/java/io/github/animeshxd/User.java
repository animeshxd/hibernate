package io.github.animeshxd;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

@Entity(name = "users_entity")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) // autoincrement for postgresql
    private int id;

    private String name;

    @ElementCollection // store collection of objects ( but it will be stored inside another table )
    @JoinTable(
        name = "USER_ADDRESS", // table name
        joinColumns = @JoinColumn(name="USER_ID") // foraign key column name
    )
    private List<Address> addresses = new LinkedList<>();

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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void appendAddresses(Address addresse) {
        this.addresses.add(addresse);
    }

    

}
