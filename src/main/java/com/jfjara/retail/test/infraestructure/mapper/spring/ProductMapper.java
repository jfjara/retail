package com.jfjara.retail.test.infraestructure.mapper.spring;

import com.jfjara.retail.test.domain.model.Price;
import com.jfjara.retail.test.infraestructure.db.springdata.entity.Product;
import com.jfjara.retail.test.infraestructure.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductMapper implements Mapper<Product, com.jfjara.retail.test.domain.model.Product> {

    @Autowired
    private PriceMapper priceMapper;

    @Override
    public Optional<com.jfjara.retail.test.domain.model.Product> toDomainModel(Product entityObject) {
        return Optional.ofNullable(mapEntityToDomain(entityObject));
    }

    @Override
    public Optional<Product> toEntityModel(com.jfjara.retail.test.domain.model.Product domainObject) {
        return Optional.empty();
    }

    @Override
    public Optional<List<com.jfjara.retail.test.domain.model.Product>> toDomainModel(List<Product> entitiesObject) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> toEntityModel(List<com.jfjara.retail.test.domain.model.Product> domainsObject) {
        return Optional.empty();
    }

    private com.jfjara.retail.test.domain.model.Product mapEntityToDomain(Product entityObject) {
        com.jfjara.retail.test.domain.model.Product domainObject = null;
        if (entityObject != null) {
            domainObject = new com.jfjara.retail.test.domain.model.Product();
            domainObject.setName(entityObject.getName());
            Optional<List<Price>> prices = priceMapper.toDomainModel(entityObject.getPrices());
            if (prices.isPresent()) {
                domainObject.setPrices(prices.get());
            }
        }
        return domainObject;
    }
}
