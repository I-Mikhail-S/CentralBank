package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class AccRstrListNotFoundException extends AbstractNotFoundException {
    public AccRstrListNotFoundException() {super(new ErrorResponse("AccRstrList not found."));}
}
