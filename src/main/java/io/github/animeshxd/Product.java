package io.github.animeshxd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity 
// multiple table will be used for storing this and its children , 
// common parent field will be stored in a table, subclasses field will be mapped to seperate tables > FOREIGN KEY (id) REFERENCES product(id)
@Inheritance(strategy = InheritanceType.JOINED) // without this annotation, Single Table strategy will be used by default
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

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + "]";
    }
        
}
