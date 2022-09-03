package io.github.animeshxd;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Tag {


    @Id @Column(length = 50)
    private String name;

    @ManyToMany(mappedBy = "tags") // Post.tags will be responsible for creating table post_tag
    private List<Post> posts = new LinkedList<>();
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag(String name) {
        this.name = name;
    }
    
    public Tag() {}

    public List<Post> getPost() {
        return posts;
    }

    public void addPosts(Post ...posts) {
        this.posts.addAll(List.of(posts));
    }

    @Override
    public String toString() {
        return "Tag [name=" + name + ", posts=" + posts + "]";
    }
    
    
}
