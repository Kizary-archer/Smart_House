package com.smart_house.exception;

import lombok.Getter;

@Getter
public class AbstractRuntimeExceptionWithFieldName extends RuntimeException{

    private final String fieldName;

    AbstractRuntimeExceptionWithFieldName(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }
}
