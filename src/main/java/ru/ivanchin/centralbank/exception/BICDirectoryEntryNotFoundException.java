package ru.ivanchin.centralbank.exception;

import ru.ivanchin.centralbank.dto.response.ErrorResponse;

public class BICDirectoryEntryNotFoundException extends AbstractNotFoundException {
    public BICDirectoryEntryNotFoundException() {super(new ErrorResponse("BICDirectoryEntry not found."));}
}
