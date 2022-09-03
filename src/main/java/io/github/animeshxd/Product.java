package io.github.animeshxd;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity 
// single table will be used for storing this and its childs columns , 
// the type name will be stored in dtype column (DiscriminatorColumn),
// by default it will use Single Table strategy inheritance
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // without this annotation, Single Table strategy will be used by default
@DiscriminatorColumn( // not required (maybe used only with SINGLE_TABLE strategy)
    name = "product_type", // default is DTYPE
    discriminatorType = DiscriminatorType.STRING // type for DiscriminatorColumn, default is DiscriminatorType.STRING
)
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
