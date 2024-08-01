package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public abstract class AbstractNotFoundException extends Exception {
    public AbstractNotFoundException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
    }
    public AbstractNotFoundException() {
        super();
    }
}
