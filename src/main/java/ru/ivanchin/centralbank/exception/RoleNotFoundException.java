package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class RoleNotFoundException extends AbstractCustomException {
    public RoleNotFoundException() {
        super(new ErrorResponse("Role not found."));
    }
}
