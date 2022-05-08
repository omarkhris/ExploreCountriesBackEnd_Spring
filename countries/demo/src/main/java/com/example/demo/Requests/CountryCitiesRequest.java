package com.example.demo.Requests;

public class CountryCitiesRequest {
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
    @Override
    public String toString(){
        return "country" + country;
    }
    
}
