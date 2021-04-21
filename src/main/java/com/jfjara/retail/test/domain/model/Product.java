package com.jfjara.retail.test.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({
    "id",
    "name",
    "prices"   
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

	@JsonProperty("id")
	private long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("prices")
	private List<Price> prices;

}
