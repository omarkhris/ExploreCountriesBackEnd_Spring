package com.example.demo.Service;

import java.io.IOException;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountriesService {

   
    private RestTemplate restTemplate;


    public static final String COUNTRIES= "https://countriesnow.space/api/v0.1/countries/";
    public static final String COUNTRIES_CAPITAL = "https://countriesnow.space/api/v0.1/countries/capital";
    public static final String COUNTRIES_ISO = "https://countriesnow.space/api/v0.1/countries/iso";
    public static final String COUNTRIES_CURRENCY = "https://countriesnow.space/api/v0.1/countries/currency";
    public static final String COUNTRIES_CITIES="https://countriesnow.space/api/v0.1/countries/cities";
    public static final String COUNTRIES_POSITIONS="https://countriesnow.space/api/v0.1/countries/positions";
    public static final String COUNTRIES_FLAG_IMAGE="https://countriesnow.space/api/v0.1/countries/flag/images";


    @Autowired

     public CountriesService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    
    public Object getCountriesAndTheirCapitals(){
        ResponseEntity<Object> responseEntity=restTemplate.getForEntity(COUNTRIES_CAPITAL, Object.class);
        Object countries = responseEntity.getBody();
        return countries;
    }

    public Object getAllCountriesAndTheirCurrencies(){
        ResponseEntity<Object> responseEntity=restTemplate.getForEntity(COUNTRIES_CURRENCY, Object.class);
        Object currencies = responseEntity.getBody();
        return (currencies);
    }


    public Object getAllCountriesAndThierRespectiveCities(){
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(COUNTRIES, Object.class);
        Object countries = responseEntity.getBody();
        return countries;
    }

    public Object getAllCountriesWithISOs(){
        ResponseEntity<Object> responseEntity=restTemplate.getForEntity(COUNTRIES_ISO, Object.class);
        Object dailcode = responseEntity.getBody();
        return dailcode;
    }

    public Object getCurrenciesOfASingleCountry(String countryName) throws IOException {

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<Object> entity = new HttpEntity<Object>(Object.class, headers);
      
            return restTemplate.postForEntity(COUNTRIES_CURRENCY , entity, String.class).getBody();
    }
   
    public Object getASpecificCountryAndItsCapital(Object country){
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(COUNTRIES_CAPITAL, country, Object.class);
        Object caps = responseEntity.getBody();
        
        return caps;
    }
    

    public Object getSingleCountryWithFlagImage(){
        ResponseEntity <Object> responseEntity= restTemplate.getForEntity(COUNTRIES_FLAG_IMAGE, Object.class);
        Object flag=responseEntity.getBody();
        return flag;
    }

    
    public Object getAllCitiesInASpecifiedCountry(Object country){
    //    HttpHeaders headers= new HttpHeaders();
    //    headers.setContentType(MediaType.APPLICATION_JSON);
    //    JSONObject countryJsonObject = new JSONObject();
    //    countryJsonObject.put("country", countryName);
    //    HttpEntity<Object> entity = new HttpEntity<Object>(countryName);
    //       ResponseEntity<String> resultResponse = restTemplate.postForEntity(COUNTRIES_CITIES, entity,String.class);
       RestTemplate restTemplate = new RestTemplate(); 
       ResponseEntity<Object> responseEntity = restTemplate.postForEntity(COUNTRIES_CITIES, country, Object.class);
       Object countriesAndCities = responseEntity.getBody();
       return countriesAndCities;
    }

    public Object getSingleCountryAndItsPosition(Object country){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(COUNTRIES_POSITIONS,Object.class, country);
        Object countryPositions = responseEntity.getBody();
        return countryPositions;
    }
}
