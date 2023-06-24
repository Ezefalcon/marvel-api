package com.openpay.marvelapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceHandler {
    @ExceptionHandler(CharacterNotFoundException.class)
    public ResponseEntity<ErrorDto> characterNotFound(CharacterNotFoundException e) {
        return new ResponseEntity<>(new ErrorDto(e), HttpStatus.NOT_FOUND);
    }
}
