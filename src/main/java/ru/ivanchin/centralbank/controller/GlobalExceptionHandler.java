package ru.ivanchin.centralbank.controller;

import jakarta.xml.bind.JAXBException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ivanchin.centralbank.dto.response.ErrorResponse;
import ru.ivanchin.centralbank.exception.AbstractAlreadyExistException;
import ru.ivanchin.centralbank.exception.AbstractNotFoundException;

import java.io.FileNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AbstractNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(AbstractNotFoundException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AbstractAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> alreadyExistHandler(AbstractAlreadyExistException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ErrorResponse> fileExceptionHandler(FileNotFoundException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JAXBException.class)
    public ResponseEntity<ErrorResponse> fileExceptionHandler(JAXBException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
