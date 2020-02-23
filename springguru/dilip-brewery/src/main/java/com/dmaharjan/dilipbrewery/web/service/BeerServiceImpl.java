package com.dmaharjan.dilipbrewery.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dmaharjan.dilipbrewery.web.model.Beer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {

	@Override
	public Beer getBeer(UUID beerId) {

		return Beer.builder().id(UUID.randomUUID()).beerName("Galxy dog")
				.beerType("Vibrant Ale").build();
	}

	@Override
	public Beer save(Beer beer) {
		return Beer.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void update(UUID beerId, Beer beer) {
		// TODO implement later
		log.debug("Updating beer .." + beerId);

	}

	@Override
	public void delete(UUID beerId) {
		// TODO Auto-generated method stub
		log.debug(" Deleting beer .." + beerId);
	}
}
