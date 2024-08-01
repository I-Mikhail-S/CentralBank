package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class RstrListNotFoundException extends AbstractNotFoundException {
    public RstrListNotFoundException() {super(new ErrorResponse("RstrList not found."));}
}
