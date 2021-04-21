package com.jfjara.retail.test.application.repository.product;

import com.jfjara.retail.test.infraestructure.db.springdata.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IProductRepository {

    List<Product> find(Date applicationDate, long productId, long brandId);


}
