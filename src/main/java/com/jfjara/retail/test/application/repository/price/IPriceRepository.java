package com.jfjara.retail.test.application.repository.price;

import com.jfjara.retail.test.infraestructure.db.springdata.entity.Price;

import java.util.Date;
import java.util.List;

public interface IPriceRepository {

    List<Price> find(Date applicationDate, long productId, long brandId);
}
