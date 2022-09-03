package io.github.animeshxd;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "`user`")
public class User {
    @Id @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "user")
    private Collection<Post> posts = new LinkedList<>();

    public User(String name) {
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

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void addPosts(Post... post) {
        this.posts.addAll(List.of(post));
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

    
    
}
