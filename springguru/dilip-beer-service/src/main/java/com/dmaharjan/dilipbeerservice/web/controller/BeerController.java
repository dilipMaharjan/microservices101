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

import com.dmaharjan.dilipbeerservice.web.model.BeerDto;

/**
 * @author dmaharjan
 */

@RequestMapping("/api/v1/beers")
@RestController
public class BeerController {

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(
			@PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<BeerDto>(BeerDto.builder().build(),
				HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> saveBeer(@Valid @RequestBody BeerDto beerDto) {
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	@PutMapping("/{beerId}")
	public ResponseEntity<Object> updateBeer(
			@PathVariable("beerId") UUID beerId,
			@Valid @RequestBody BeerDto beerDto) {
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
