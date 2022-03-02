package com.example.msscbreweryclient.web.client;

import com.example.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto =breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveBeerDto() {
        BeerDto beerDto=BeerDto.builder().beerName("Test").build();
        URI uri=breweryClient.saveBeerDto(beerDto);
        assertNotNull(beerDto);

        System.out.println(uri.toString());

    }

    @Test
    void updateBeerDto() {
        BeerDto beerDto=BeerDto.builder().beerName("Test").build();
        breweryClient.updateBeer(UUID.randomUUID(),beerDto);
//        assertNotNull(beerDto);
    }

    @Test
    void deleteBeer() {
        breweryClient.DeleteBeer(UUID.randomUUID());
    }
}
