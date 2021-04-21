package com.jfjara.retail.test.infraestructure.db.springdata.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity(name = "brands")
public class Brand {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Price> prices;

}
