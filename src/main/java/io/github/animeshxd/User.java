package io.github.animeshxd;

import java.util.Collection;
import java.util.LinkedList;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "USERS")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) // autoincrement for postgresql
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name = "addr_no")
    private Address address;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY) // mappedBy = "user" Post.user will do the mapping instead of creating new table
    private Collection<Post> posts = new LinkedList<>();

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

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User [address=" + address + ", id=" + id + ", name=" + name + "]";
    }

    

    

}
