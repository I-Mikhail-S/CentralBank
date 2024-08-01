package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class UserAlreadyExistException extends AbstractAlreadyExistException {
    public UserAlreadyExistException() {
        super(new ErrorResponse("User already exist."));
    }
}
