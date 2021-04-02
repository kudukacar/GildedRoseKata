package com.example.gildedrose.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class IncorrectProposedItemAdvice {
    @ResponseBody
    @ExceptionHandler(IncorrectProposedItemException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String incorrectProposedItemHandler(IncorrectProposedItemException exception) {
        return exception.getMessage();
    }
}
