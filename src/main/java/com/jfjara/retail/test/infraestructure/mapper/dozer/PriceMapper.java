package com.jfjara.retail.test.infraestructure.mapper.dozer;

import com.jfjara.retail.test.infraestructure.db.springdata.entity.Price;
import com.jfjara.retail.test.infraestructure.mapper.Mapper;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Qualifier("dozerPriceMapper")
public class PriceMapper implements Mapper<Price, com.jfjara.retail.test.domain.model.Price>{

    @Autowired
    private DozerBeanMapper dozerBeanMapper;


    @Override
    public Optional<com.jfjara.retail.test.domain.model.Price> toDomainModel(Price entityObject) {
        return Optional.of(internalMapToDomainModel(entityObject));
    }

    @Override
    public Optional<Price> toEntityModel(com.jfjara.retail.test.domain.model.Price domainObject) {
        return Optional.of(internalMapToEntityModel(domainObject));
    }

    @Override
    public Optional<List<com.jfjara.retail.test.domain.model.Price>> toDomainModel(List<Price> entitiesObject) {
        List<com.jfjara.retail.test.domain.model.Price> result = new ArrayList<>();
        for (Price price : entitiesObject) {
            result.add(internalMapToDomainModel(price));
        }
        return Optional.of(result);
    }

    @Override
    public Optional<List<Price>> toEntityModel(List<com.jfjara.retail.test.domain.model.Price> domainsObject) {
        List<Price> result = new ArrayList<>();
        for (com.jfjara.retail.test.domain.model.Price price : domainsObject) {
            result.add(internalMapToEntityModel(price));
        }
        return Optional.of(result);
    }

    private com.jfjara.retail.test.domain.model.Price internalMapToDomainModel(Price entityObject) {
        return dozerBeanMapper.map(entityObject, com.jfjara.retail.test.domain.model.Price.class);
    }

    private Price internalMapToEntityModel(com.jfjara.retail.test.domain.model.Price modelObject) {
        return dozerBeanMapper.map(modelObject, Price.class);
    }


}
