package com.jfjara.retail.test.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public enum Currency {
	EUR("EUR"), USD("USD");

	public final String label;

	private Currency(String value) {
		this.label = value;
	}

}
