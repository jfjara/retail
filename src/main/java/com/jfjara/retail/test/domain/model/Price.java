package com.jfjara.retail.test.domain.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({
    "id",
    "brandId",
    "startDate",
    "endDate",
    "priceList",
    "productId",
    "priority",
    "price",
    "currency"   
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Price {

	@JsonProperty("brandId")
	private long brandId;
	
	@JsonProperty("startDate")
	private Date startDate;
	
	@JsonProperty("endDate")
	private Date endDate;
	
	@JsonProperty("priceList")
	private long priceList;
	
	@JsonProperty("productId")
	private long productId;

	@JsonIgnore
	private int priority;
	
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("currency")
	private Currency currency;
	
}
