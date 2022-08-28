package io.github.animeshxd;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

@Embeddable
public class Address {

    private String village;

    @Transient // this can also have @Transient
    private String street;

    private int pincode;

    private String state;

    
    public Address() {}

    public Address(String village, String street, int pincode, String state) {
        this.village = village;
        this.street = street;
        this.pincode = pincode;
        this.state = state;
    }
    public String getVillage() {
        return village;
    }
    public void setVillage(String village) {
        this.village = village;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public int getPincode() {
        return pincode;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return "Address [pincode=" + pincode + ", state=" + state + ", street=" + street + ", village=" + village + "]";
    }
    
}
