package com.jfjara.retail.test.application.service.price;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.jfjara.retail.test.domain.exceptions.AbstractCustomException;
import com.jfjara.retail.test.domain.utils.DateUtils;
import com.jfjara.retail.test.infraestructure.mapper.spring.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jfjara.retail.test.application.interfaces.price.IPriceService;
import com.jfjara.retail.test.application.repository.price.IPriceRepository;
import com.jfjara.retail.test.domain.model.Price;

@Service
public class PriceService implements IPriceService {

	@Autowired
	@Qualifier("priceRepository")
	private IPriceRepository repository;

	@Autowired
	private PriceMapper mapper;

	@Override
	public Optional<Price> find(String applicationDateText, long productId, long brandId) throws AbstractCustomException {
		Date applicationDate = DateUtils.formatDate(applicationDateText);
		List<com.jfjara.retail.test.infraestructure.db.springdata.entity.Price> prices = repository.find(applicationDate, productId, brandId);
		com.jfjara.retail.test.infraestructure.db.springdata.entity.Price price = null;
		if (prices != null && !prices.isEmpty()) {
			price = prices.get(0);
		}
		return mapper.toDomainModel(price);
	}

}
