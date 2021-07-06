package com.library.sroy.LibraryProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LibraryCardNotFoundException extends RuntimeException{
    public LibraryCardNotFoundException(String message) {
        super(message);
    }
}
