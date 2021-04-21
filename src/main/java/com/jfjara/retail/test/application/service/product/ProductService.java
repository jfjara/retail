package com.jfjara.retail.test.application.service.product;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.jfjara.retail.test.application.repository.product.IProductRepository;
import com.jfjara.retail.test.infraestructure.mapper.spring.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.jfjara.retail.test.application.interfaces.product.IProductService;
import com.jfjara.retail.test.domain.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

	@Qualifier("productRepository")
	@Autowired
	private IProductRepository repository;

	@Autowired
	private ProductMapper mapper;

	@Override
	public Optional<List<Product>> find(Date applicationDate, long productId, long brandId) {
		return mapper.toDomainModel(repository.find(applicationDate, productId, brandId));
	}
	
}
