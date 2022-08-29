package io.github.animeshxd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int no;

    private String city;
    private int pincode;
    
    public Address(String city, int pincode) {
        this.city = city;
        this.pincode = pincode;
    }
    
    public Address() {}

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getPincode() {
        return pincode;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", no=" + no + ", pincode=" + pincode + "]";
    }
    
}
