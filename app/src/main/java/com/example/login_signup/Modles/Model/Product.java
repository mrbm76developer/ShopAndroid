package com.example.login_signup.Modles.Model;

import java.util.Date;

public class Product {
    private String name;
    private int price;
    public int seen;
    private byte off;
    private Kala kala;
    private Date date;
    private String imageAddress;

    public Product() {
    }

    public Product(String name, int price, int seen, byte off, Kala kala, Date date, String imageAddress) {
        this.name = name;
        this.price = price;
        this.seen = seen;
        this.off = off;
        this.kala = kala;
        this.date = date;
        this.imageAddress = imageAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte getOff() {
        return off;
    }

    public void setOff(byte off) {
        this.off = off;
    }

    public Kala getKala() {
        return kala;
    }

    public void setKala(Kala kala) {
        this.kala = kala;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public int getSeen() {
        return seen;
    }

    public void setSeen(int seen) {
        this.seen = seen;
    }
}
