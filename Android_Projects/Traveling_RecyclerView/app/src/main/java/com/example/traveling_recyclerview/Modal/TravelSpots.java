package com.example.traveling_recyclerview.Modal;

public class TravelSpots {

    String spotName;
    String spotCountry;
    int spotimg;

    public TravelSpots(String spotName, String spotCountry, int spotimg){

        this.spotName = spotName;
        this.spotCountry = spotCountry;
        this.spotimg = spotimg;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSpotCountry() {
        return spotCountry;
    }

    public void setSpotCountry(String spotCountry) {
        this.spotCountry = spotCountry;
    }

    public int getSpotimg() {
        return spotimg;
    }

    public void setSpotimg(int spotimg) {
        this.spotimg = spotimg;
    }


}
