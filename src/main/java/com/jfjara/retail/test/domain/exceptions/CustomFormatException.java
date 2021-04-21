package com.jfjara.retail.test.domain.exceptions;

public class CustomFormatException extends AbstractCustomException {

    @Override
    public int getCode() {
        return 1;
    }

    @Override
    public String getMessage() {
        return "Error parsing a date";
    }


}
