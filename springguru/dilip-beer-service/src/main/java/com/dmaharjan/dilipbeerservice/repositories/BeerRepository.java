package com.dmaharjan.dilipbeerservice.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dmaharjan.dilipbeerservice.domain.Beer;
import com.dmaharjan.dilipbeerservice.web.model.BeerStyleEnum;

/**
 * @author dmaharjan
 * @createdAt Feb 27, 2020
 */
public interface BeerRepository extends JpaRepository<Beer, UUID> {
	Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

	Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);

	Page<Beer> findAllByBeerNameAndBeerStyle(String beerName,
			BeerStyleEnum beerStyle, Pageable pageable);

	Beer findByUpc(String upc);
}
