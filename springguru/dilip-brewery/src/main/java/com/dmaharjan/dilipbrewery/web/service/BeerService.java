package com.dmaharjan.dilipbrewery.web.service;

import java.util.UUID;

import com.dmaharjan.dilipbrewery.web.model.Beer;

public interface BeerService {
	public Beer getBeer(UUID beerId);

	public Beer save(Beer beer);

	public void update(UUID beerId, Beer beer);

	public void delete(UUID beerId);
}
