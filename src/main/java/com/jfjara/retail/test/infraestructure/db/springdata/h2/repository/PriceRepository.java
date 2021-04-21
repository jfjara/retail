package com.jfjara.retail.test.infraestructure.db.springdata.h2.repository;

import com.jfjara.retail.test.application.repository.price.IPriceRepository;
import com.jfjara.retail.test.infraestructure.db.springdata.entity.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository(value = "priceRepository")
public interface PriceRepository extends CrudRepository<Price, Long>, IPriceRepository {

    @Override
    @Query(nativeQuery = true, value = "select * FROM prices p " +
            " WHERE p.product_id = :productId and p.brand_id = :brandId and start_date <= :applicationDate and" +
            " end_date >= :applicationDate order by p.priority desc")
    List<Price> find(@Param("applicationDate") Date applicationDate,
                     @Param("productId") long productId,
                     @Param("brandId") long brandId);

}
