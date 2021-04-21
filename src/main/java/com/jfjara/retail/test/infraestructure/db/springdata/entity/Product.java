package com.jfjara.retail.test.infraestructure.db.springdata.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity(name = "products")
public class Product {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "product")
    private List<Price> prices;
}
