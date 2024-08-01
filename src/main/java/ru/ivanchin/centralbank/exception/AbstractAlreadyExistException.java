package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public abstract class AbstractAlreadyExistException extends Exception {
    public AbstractAlreadyExistException(ErrorResponse errorResponse) {super(errorResponse.getMessage());}
    public AbstractAlreadyExistException() {super();}
}
