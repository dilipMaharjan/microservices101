package com.dmaharjan.dilipbeerservice.bootstrap;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.dmaharjan.dilipbeerservice.domain.Beer;
import com.dmaharjan.dilipbeerservice.repositories.BeerRepository;
import com.dmaharjan.dilipbeerservice.web.model.BeerStyleEnum;

/**
 * @author dmaharjan
 * @createdAt Feb 28, 2020
 */
@Component

public class BeerLoader
{

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository)
    {
        this.beerRepository = beerRepository;
    }

    public void run(String... args) throws Exception
    {
        seedBeers();
    }

    private void seedBeers()
    {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder().beerName("Mango bobs").beerStyle("IPA").quantityToBrew(200).minOnHand(12)
                .upc(32000L).price(new BigDecimal(12.95)).build());
            beerRepository.save(Beer.builder().beerName("Galaxy cat").beerStyle("ALE").quantityToBrew(200).minOnHand(22)
                .upc(32100L).price(new BigDecimal(2.85)).build());
        }
    }

}
