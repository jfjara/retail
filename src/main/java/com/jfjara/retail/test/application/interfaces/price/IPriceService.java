package com.jfjara.retail.test.application.interfaces.price;

import java.util.List;
import java.util.Optional;

import com.jfjara.retail.test.domain.exceptions.AbstractCustomException;
import com.jfjara.retail.test.domain.model.Price;


public interface IPriceService {
	
	Optional<List<Price>> find(String applicationDateText, long productId, long brandId) throws AbstractCustomException;

}
