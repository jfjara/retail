package com.jfjara.retail.test.infraestructure.db.springdata.h2.repository;

import com.jfjara.retail.test.application.repository.product.IProductRepository;
import com.jfjara.retail.test.infraestructure.db.springdata.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository(value = "productRepository")
public interface ProductRepository extends CrudRepository<Product, Long>, IProductRepository {

    @Override
    @Query(nativeQuery = true, value = "select distintct p.* FROM products p, prices c " +
            " WHERE p.id = :productId and p.id = c.product_id and  c.brand_id = :brandId and c.start_date >= :applicationDate and" +
            " c.end_date <= :applicationDate")
    List<Product> find(@Param("applicationDate") Date applicationDate,
                       @Param("productId") long productId,
                       @Param("brandId") long brandId);

}
