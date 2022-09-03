package io.github.animeshxd;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
    @Id @GeneratedValue
    private int id;

    private String title;
    @Lob
    private String content;

    @ManyToOne
    private User user;

    @ManyToMany // this class is responsible for creating table post_tag
    private List<Tag> tags = new LinkedList<>();

    
    public Post(String title) {
        this.title = title;
    }
    

    public Post() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Post addTag(Tag e) {
        this.tags.add(e);
        return this;
    }
    public Post addTags(Tag... es){
        this.tags.addAll(List.of(es));
        return this;
    }

    public User getUser() {
        return user;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "Post [content=" + content + ", id=" + id + ", title=" + title + ", user=" + user + "]";
    }

    

}
