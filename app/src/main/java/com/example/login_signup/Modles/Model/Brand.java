package com.example.login_signup.Modles.Model;

public class Brand {
    private String nameBrand;
    private String imageAddress;

    public Brand() {
    }

    public Brand(String nameBrand, String imageAddress) {
        this.nameBrand = nameBrand;
        this.imageAddress = imageAddress;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }
}
