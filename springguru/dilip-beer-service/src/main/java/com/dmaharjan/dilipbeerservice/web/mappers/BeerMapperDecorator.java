package com.dmaharjan.dilipbeerservice.web.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import com.dmaharjan.dilipbeerservice.domain.Beer;
import com.dmaharjan.dilipbeerservice.web.model.BeerDto;

/**
 * @author dmaharjan
 * @createdAt Feb 27, 2020
 */
public abstract class BeerMapperDecorator implements BeerMapper {
	private BeerMapper mapper;

	@Autowired
	public void setMapper(BeerMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public BeerDto beerToBeerDto(Beer beer) {
		return mapper.beerToBeerDto(beer);
	}

	@Override
	public Beer beerDtoToBeer(BeerDto beerDto) {
		return mapper.beerDtoToBeer(beerDto);
	}
}
