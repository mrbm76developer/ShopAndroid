package com.example.login_signup.Modles.Model;

public class Kala {
    private String addressImage;
    private String title;

    public Kala() {
    }

    public Kala(String addressImage, String title) {
        this.addressImage = addressImage;
        this.title = title;
    }

    public String getAddressImage() {
        return addressImage;
    }

    public void setAddressImage(String addressImage) {
        this.addressImage = addressImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
