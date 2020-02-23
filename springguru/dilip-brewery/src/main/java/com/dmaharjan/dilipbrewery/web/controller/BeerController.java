package com.dmaharjan.dilipbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dmaharjan.dilipbrewery.web.model.Beer;
import com.dmaharjan.dilipbrewery.web.service.BeerService;

@RequestMapping("/api/v1/beers")
@RestController
public class BeerController {

	private BeerService beerService;

	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	@GetMapping("/{beerId}")
	public ResponseEntity<Beer> getBeer(@PathVariable UUID beerId) {
		return new ResponseEntity<>(beerService.getBeer(beerId), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<HttpHeaders> createBeer(@RequestBody Beer beer) {
		Beer newBeer = beerService.save(beer);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beers/" + newBeer.getId().toString());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	@PutMapping("/{beerId}")
	public ResponseEntity<Object> updateBeer(@PathVariable UUID beerId,
			Beer beer) {
		beerService.update(beerId, beer);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@DeleteMapping("/{beerId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		beerService.delete(beerId);
	}

}
