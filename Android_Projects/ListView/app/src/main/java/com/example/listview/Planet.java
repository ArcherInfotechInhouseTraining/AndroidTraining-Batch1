package com.example.listview;

public class Planet {

    private String planetName;
    private String moonCount;
    private int img;

    public Planet(String planetName, String moonCount, int img){

        this.planetName = planetName;
        this.moonCount = moonCount;
        this.img = img;

    }

    public String getPlanetName(){
        return planetName;
    }

    public void setPlanetName(String planetName){
        this.planetName = planetName;
    }

    public String getMoonCount(){
        return moonCount;
    }

    public void setMoonCount(String moonCount){
        this.moonCount = moonCount;
    }

    public int getImg(){
        return img;
    }

    public void setImg( int img){
        this.img = img;
    }
}
