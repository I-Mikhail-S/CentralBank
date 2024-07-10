package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class UserNotFoundException extends AbstractCustomException {
    public UserNotFoundException() {
        super(new ErrorResponse("User not found."));
    }
}
