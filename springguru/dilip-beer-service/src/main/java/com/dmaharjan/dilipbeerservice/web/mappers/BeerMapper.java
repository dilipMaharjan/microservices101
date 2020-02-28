package com.dmaharjan.dilipbeerservice.web.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import com.dmaharjan.dilipbeerservice.domain.Beer;
import com.dmaharjan.dilipbeerservice.web.model.BeerDto;

/**
 * @author dmaharjan
 * @createdAt Feb 27, 2020
 */
@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

	BeerDto beerToBeerDto(Beer beer);

	Beer beerDtoToBeer(BeerDto dto);
}
