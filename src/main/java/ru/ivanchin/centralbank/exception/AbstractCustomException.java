package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public abstract class AbstractCustomException extends Exception {
    public AbstractCustomException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
    }
    public AbstractCustomException() {
        super();
    }
}
