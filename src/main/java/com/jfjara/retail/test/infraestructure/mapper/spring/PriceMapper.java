package com.jfjara.retail.test.infraestructure.mapper.spring;

import com.jfjara.retail.test.domain.model.Currency;
import com.jfjara.retail.test.infraestructure.db.springdata.entity.Price;
import com.jfjara.retail.test.infraestructure.mapper.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PriceMapper implements Mapper<Price, com.jfjara.retail.test.domain.model.Price> {

    @Override
    public Optional<com.jfjara.retail.test.domain.model.Price> toDomainModel(Price entityObject) {
        return Optional.ofNullable(mapEntityToDomain(entityObject));
    }

    @Override
    public Optional<Price> toEntityModel(com.jfjara.retail.test.domain.model.Price domainObject) {
        return Optional.empty();
    }

    @Override
    public Optional<List<com.jfjara.retail.test.domain.model.Price>> toDomainModel(List<Price> entitiesObject) {
        List<com.jfjara.retail.test.domain.model.Price> domainsObjects = null;
        if (entitiesObject != null) {
            domainsObjects = entitiesObject.stream().map(entityObject -> mapEntityToDomain(entityObject)).collect(Collectors.toList());
        }
        return Optional.ofNullable(domainsObjects);
    }

    @Override
    public Optional<List<Price>> toEntityModel(List<com.jfjara.retail.test.domain.model.Price> domainsObject) {
        return Optional.empty();
    }

    private com.jfjara.retail.test.domain.model.Price mapEntityToDomain(Price entityObject) {
        com.jfjara.retail.test.domain.model.Price domainObject = null;
        if (entityObject != null) {
            domainObject = new com.jfjara.retail.test.domain.model.Price();
            domainObject.setPriceList(entityObject.getPriceList());
            domainObject.setCurrency(Currency.valueOf(entityObject.getCurrency()));
            domainObject.setPriority(entityObject.getPriority());
            domainObject.setStartDate(entityObject.getStartDate());
            domainObject.setEndDate(entityObject.getEndDate());
            domainObject.setPrice(entityObject.getPrice());
            domainObject.setProductId(entityObject.getProduct().getId());
            domainObject.setBrandId(entityObject.getBrand().getId());
        }
        return domainObject;
    }
}
