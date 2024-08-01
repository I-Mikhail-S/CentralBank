package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class SWBICSNotFoundException extends AbstractNotFoundException {
    public SWBICSNotFoundException() {super(new ErrorResponse("SWBICS not found."));}
}
