package com.jfjara.retail.test.domain.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractCustomException extends Exception implements ICustomException {

    @JsonProperty("errorCode")
    private int errorCode;

    @JsonProperty("messageError")
    private String messageError;

}
