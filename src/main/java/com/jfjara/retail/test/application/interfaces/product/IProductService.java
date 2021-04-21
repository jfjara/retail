package com.jfjara.retail.test.application.interfaces.product;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.jfjara.retail.test.domain.model.Product;

public interface IProductService {

	Optional<List<Product>> find(Date applicationDate, long productId, long brandId);
	
}
