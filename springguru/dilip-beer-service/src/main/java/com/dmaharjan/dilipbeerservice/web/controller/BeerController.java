package com.dmaharjan.dilipbeerservice.web.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmaharjan.dilipbeerservice.repositories.BeerRepository;
import com.dmaharjan.dilipbeerservice.web.mappers.BeerMapper;
import com.dmaharjan.dilipbeerservice.web.model.BeerDto;

import lombok.RequiredArgsConstructor;

/**
 * @author dmaharjan
 */

@RequestMapping("/api/v1/beers")
@RequiredArgsConstructor
@RestController
public class BeerController
{
    private final BeerMapper beerMapper;

    private final BeerRepository beerRepository;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId)
    {
        return new ResponseEntity<BeerDto>(beerMapper.beerToBeerDto(beerRepository.findById(beerId).get()),
            HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveBeer(@Valid @RequestBody BeerDto beerDto)
    {
        beerRepository.save(beerMapper.beerDtoToBeer(beerDto));
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Object> updateBeer(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto)
    {
        beerRepository.findById(beerId).ifPresent(beer -> {
            beer.setBeerName(beerDto.getBeerName());
            beer.setBeerStyle(beerDto.getBeerStyle().name());
            beer.setPrice(beerDto.getPrice());
            beer.setUpc(beerDto.getUpc());
            beerRepository.save(beer);
        });
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
