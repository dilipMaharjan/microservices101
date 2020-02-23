package com.dmaharjan.dilipbrewery.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.awt.PageAttributes.MediaType;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.dmaharjan.dilipbrewery.web.model.Beer;
import com.dmaharjan.dilipbrewery.web.service.BeerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {

	@MockBean
	BeerService beerService;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	Beer validBeer;

	@BeforeEach
	public void setUp() {
		validBeer = Beer.builder().id(UUID.randomUUID()).beerName("Beer1")
				.beerType("Vibrant Ale").upc(12345678L).build();
	}

	@Test
	public void getBeer() throws Exception {
		
	}

}
