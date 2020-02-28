package com.dmaharjan.dilipbeerservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.dmaharjan.dilipbeerservice.domain.Beer;
import com.dmaharjan.dilipbeerservice.repositories.BeerRepository;
import com.dmaharjan.dilipbeerservice.web.controller.BeerController;
import com.dmaharjan.dilipbeerservice.web.model.BeerDto;
import com.dmaharjan.dilipbeerservice.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(BeerController.class)
@ComponentScan(basePackages = "com.dmaharjan.dilipbeerservice.web.mappers")
public class BeerControllerTest
{
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerRepository beerRepository;

    @Test
    void getBeer() throws Exception
    {
        given(beerRepository.findById(any())).willReturn(Optional.of(Beer.builder().build()));
        mockMvc.perform(get("/api/v1/beers/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    void saveBeer() throws Exception
    {
        BeerDto beerDto = getValidBeerDto();
        String beerDtoToJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post("/api/v1/beers/").contentType(MediaType.APPLICATION_JSON).content(beerDtoToJson))
            .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception
    {
        BeerDto beerDto = getValidBeerDto();
        String beerDtoToJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(put("/api/v1/beers/" + UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON)
            .content(beerDtoToJson)).andExpect(status().isNoContent());
    }

    BeerDto getValidBeerDto()
    {
        return BeerDto.builder().beerName("Tuborg").beerStyle(BeerStyleEnum.ALE).price(new BigDecimal(2.99)).upc(12344L)
            .build();
    }

}
