package com.example.demo.Requests;

public class CountryFlagRequest {
    public String iso;

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @Override
    public String toString(){
        return "iso:" + iso;
    }
    
}
