package io.github.animeshxd;

import jakarta.persistence.Entity;

@Entity
public class Printer extends Product {

    private boolean ink;

    public boolean isInk() {
        return ink;
    }
    public void setInk(boolean ink) {
        this.ink = ink;
    }
    public Printer() {}
    public Printer(String name, boolean ink) {
        super(name);
        this.ink = ink;
    }
       
    @Override
    public String toString() {
        return "Printer [id=" + getId() + ", name=" + getName() + ", ink=" + ink +"]";
    }
}
