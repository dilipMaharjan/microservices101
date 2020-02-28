package com.dmaharjan.dilipbeerservice.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * @author dmaharjan
 *
 */
public class BeerPagedList extends PageImpl<BeerDto> {
	public BeerPagedList(List<BeerDto> beer, Pageable pageable, long total) {
		super(beer, pageable, total);
	}
	public BeerPagedList(List<BeerDto> beer) {
		super(beer);
	}

}
