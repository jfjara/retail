package com.jfjara.retail.test.application.repository.price;

import com.jfjara.retail.test.infraestructure.db.springdata.entity.Price;
import com.jfjara.retail.test.infraestructure.db.springdata.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IPriceRepository {

    List<Price> find(Date applicationDate, long productId, long brandId);
}
