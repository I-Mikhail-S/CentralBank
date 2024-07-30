package ru.ivanchin.centralbank.controller;

import jakarta.xml.bind.JAXBException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ivanchin.centralbank.dto.response.ErrorResponse;
import ru.ivanchin.centralbank.exception.AbstractCustomException;

import java.io.FileNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AbstractCustomException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(AbstractCustomException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ErrorResponse> fileExceptionHandler(FileNotFoundException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(JAXBException.class)
    public ResponseEntity<ErrorResponse> fileExceptionHandler(JAXBException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.OK);
    }

}
