package com.dmaharjan.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmaharjan.currencyexchangeservice.bean.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);
}
