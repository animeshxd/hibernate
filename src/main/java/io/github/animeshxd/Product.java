package io.github.animeshxd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity 
// single table will be used for storing this and its childs columns , 
// the type name will be stored in dtype column (DiscriminatorColumn),
// by default it will use Single Table strategy inheritance
public class Product {
    @Id @GeneratedValue
    private int id;
    private String name;

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
    public Product() {}
    public Product(String name) {
        this.name = name;
    }
    

    
}
