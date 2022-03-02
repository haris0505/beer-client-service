package com.example.msscbreweryclient.web.client;

import com.example.msscbreweryclient.web.model.BeerDto;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(value = "sfi.brewery",ignoreUnknownFields = false)
@Component
public class BreweryClient {

    public final String BEER_Path="/api/v1/beer/";
    private String apihost;

    private  final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost+BEER_Path+uuid.toString(),BeerDto.class);
    }

    public URI saveBeerDto(BeerDto beerDto){
        return restTemplate.postForLocation(apihost+BEER_Path,beerDto);
    }


    public  void updateBeer(UUID uuid,BeerDto beerDto){
        restTemplate.put(apihost+BEER_Path+uuid.toString(),beerDto);
    }

    public void DeleteBeer(UUID uuid){
        restTemplate.delete(apihost+BEER_Path+uuid.toString());
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
