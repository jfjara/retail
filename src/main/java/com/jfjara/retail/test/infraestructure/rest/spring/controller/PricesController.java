package com.jfjara.retail.test.infraestructure.rest.spring.controller;

import com.jfjara.retail.test.application.interfaces.price.IPriceService;
import com.jfjara.retail.test.domain.exceptions.AbstractCustomException;
import com.jfjara.retail.test.domain.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/prices")
public class PricesController {
	
	@Autowired
	@Qualifier("priceService")
	private IPriceService service;
	
	@RequestMapping(value = "/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Price> get(@RequestParam(name = "applicationDate", required = true) String applicationDateTxt,
									@RequestParam(name = "productId", required = true) long productId,
									@RequestParam(name = "brandId", required = true) long brandId) throws AbstractCustomException {
		Optional<Price> prices = service.find(applicationDateTxt, productId, brandId);
		return new ResponseEntity<Price>(prices.get(), HttpStatus.OK);
	}

}
