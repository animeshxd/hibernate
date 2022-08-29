package io.github.animeshxd;

import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity(name = "post")
public class Post {

    @Id @GeneratedValue
    private UUID id;

    @Basic(optional = false)
    private String title;

    @Lob @Basic(fetch = FetchType.LAZY)
    private String content;

    @ManyToOne
    private User user;
 

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post [content=" + content + ", id=" + id + ", title=" + title + ", user=" + user + "]";
    }
    
}
