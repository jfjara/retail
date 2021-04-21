package com.jfjara.retail.test.infraestructure.mapper;

import java.util.List;
import java.util.Optional;

public interface Mapper <R, S> {

    Optional<S> toDomainModel(R entityObject);
    Optional<R> toEntityModel(S domainObject);

    Optional<List<S>> toDomainModel(List<R> entitiesObject);
    Optional<List<R>> toEntityModel(List<S> domainsObject);

}
