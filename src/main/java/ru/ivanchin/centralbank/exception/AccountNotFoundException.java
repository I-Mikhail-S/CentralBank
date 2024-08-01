package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class AccountNotFoundException extends AbstractNotFoundException {
    public AccountNotFoundException() {super(new ErrorResponse("Account not found."));}
}
