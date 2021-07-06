package com.library.sroy.LibraryProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class CardAlreadyPresentException extends RuntimeException{
    public CardAlreadyPresentException(String message) {
        super(message);
    }
}
