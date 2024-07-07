package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class UserAlreadyExistException extends AbstractCustomException {
    public UserAlreadyExistException() {
        super(new ErrorResponse("User already exist."));
    }
}
