package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class CentralBankNotFoundException extends AbstractNotFoundException {
    public CentralBankNotFoundException() {super(new ErrorResponse("CentralBank not found."));}
}
