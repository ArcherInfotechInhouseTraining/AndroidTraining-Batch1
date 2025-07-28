package com.example.countryslist.Modal;

public class CountryList {

    String name;
    int img;

    public CountryList(String name, int img){
        this.name = name;
        this.img = img;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }
}
