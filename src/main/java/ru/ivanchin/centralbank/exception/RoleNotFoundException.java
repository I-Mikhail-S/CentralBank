package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class RoleNotFoundException extends AbstractNotFoundException {
    public RoleNotFoundException() {
        super(new ErrorResponse("Role not found."));
    }
}
