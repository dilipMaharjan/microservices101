package com.dmaharjan.dilipbeerservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.dmaharjan.dilipbeerservice.web.controller.BeerController;
import com.dmaharjan.dilipbeerservice.web.model.BeerDto;
import com.dmaharjan.dilipbeerservice.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebMvcTest(BeerController.class)
class DilipBeerServiceApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void getBeer() throws Exception {
		mockMvc.perform(get("/api/v1/beers/" + UUID.randomUUID().toString())
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void saveBeer() throws Exception {
		BeerDto beerDto = getValidBeerDto();
		String beerDtoToJson = objectMapper.writeValueAsString(beerDto);
		mockMvc.perform(post("/api/v1/beers/")
				.contentType(MediaType.APPLICATION_JSON).content(beerDtoToJson))
				.andExpect(status().isCreated());
	}
	@Test
	void update() throws Exception {
		BeerDto beerDto = getValidBeerDto();
		String beerDtoToJson = objectMapper.writeValueAsString(beerDto);
		mockMvc.perform(put("/api/v1/beers/" + UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON).content(beerDtoToJson))
				.andExpect(status().isNoContent());
	}
	BeerDto getValidBeerDto() {
		return BeerDto.builder().beerName("Tuborg").beerStyle(BeerStyleEnum.ALE)
				.price(new BigDecimal(2.99)).upc(12344L).build();
	}
}
