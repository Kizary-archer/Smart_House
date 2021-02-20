package com.smart_house.exception;

public class EntityNotFoundException extends AbstractRuntimeExceptionWithFieldName{

    public EntityNotFoundException(String message, String fieldName) {
        super(message, fieldName);
    }
}
