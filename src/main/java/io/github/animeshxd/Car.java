package io.github.animeshxd;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bike") // not required (maybe used only with SINGLE_TABLE strategy) | default DiscriminatorColumn's value (DiscriminatorValue) will be class name : Car 
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
