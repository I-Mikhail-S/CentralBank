package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class UserNotFoundException extends AbstractNotFoundException {
    public UserNotFoundException() {
        super(new ErrorResponse("User not found."));
    }
}
