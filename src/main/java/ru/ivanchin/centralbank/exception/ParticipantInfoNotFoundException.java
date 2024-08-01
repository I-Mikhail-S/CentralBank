package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class ParticipantInfoNotFoundException extends AbstractNotFoundException {
    public ParticipantInfoNotFoundException() {super(new ErrorResponse("ParticipantInfo not found."));}
}
