package com.example.demo.Controller;

import java.io.IOException;
import com.example.demo.Service.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController     
@RequestMapping
public class CountriesController {

    // @Autowired
    // RestTemplate restTemplate;

    // @Autowired
    // private RestTemplate restTemplate=new RestTemplate();

    @Autowired
    private CountriesService countriesService;

   
    public static final String Url = "https://countriesnow.space/api/v0.1/countries/capital";

    
    //Countries Endpoint Resource
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/countries/cities")
    public Object getAllCountriesAndThierRespectiveCities() {
        return countriesService.getAllCountriesAndThierRespectiveCities();
    }
    
    //Currencies Endpoint Resource
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/countries/currencies")
    public Object getAllCountriesAndTheirCurrencies() {
        return countriesService.getAllCountriesAndTheirCurrencies();
    }

    
    //Dailcode Endpoint Resource
    @GetMapping(value="/iso")
    public Object getAllCountriesWithISOs() {
       return countriesService.getAllCountriesWithISOs();
    } 

    //Get Method for countries and their Capital
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/countries/capitals")
    public Object getCountriesAndTheirCapitals(){
        return countriesService.getCountriesAndTheirCapitals();
    }

    //Get Method for countries and their flags
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/countries/flags",method=RequestMethod.GET)
    public Object getSingleCountryWithFlagImage(){
        return countriesService.getSingleCountryWithFlagImage();
    }

    //Post Method for countries and their Cities
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/countries/cities",method = RequestMethod.POST)
    public Object getAllCitiesInASpecifiedCountry(@RequestBody Object country){
        return countriesService.getAllCitiesInASpecifiedCountry(country);
    }

     //Post Method for countries and their Currencies
    @PostMapping(value = "/country/currency", consumes = "application/json", produces = "application/json")
    public Object getCurrenciesOfASingleCountry(@RequestBody String countryName) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("country", countryName);
        // HttpEntity<Object> entity = new HttpEntity<Object>(countryName, headers);
        return restTemplate.postForEntity("https://countriesnow.space/api/v0.1/countries/currency", headers, Object.class);

    }

     //Post Method for countries and their Capital
    @RequestMapping(value="/country/capital",method=RequestMethod.POST)
    public Object  getASpecificCountryAndItsCapital(@RequestBody Object count){
        return countriesService.getASpecificCountryAndItsCapital(count);
    }
    

     //Post Method for countries and their Position
    @RequestMapping(value = "/country/position",method = RequestMethod.POST)
    public Object getSingleCountryAndItsPosition(@RequestBody Object country){
        
       return countriesService.getSingleCountryAndItsPosition(country);

    }
  
}