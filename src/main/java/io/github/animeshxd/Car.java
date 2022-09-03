package io.github.animeshxd;

import jakarta.persistence.Entity;

@Entity
public class Car extends Product {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(){}
    public Car(String name, String color) {
        super(name);
        this.color = color;
    }
}
