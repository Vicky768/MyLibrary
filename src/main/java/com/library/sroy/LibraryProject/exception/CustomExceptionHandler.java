package com.library.sroy.LibraryProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    /***
     *
     * @param userEx
     * @param req
     * @return
     */
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userEx, WebRequest req){
        ErrorResponse errorResponse = new ErrorResponse(new Date(), userEx.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /***
     *
     * @param bookEx
     * @param req
     * @return
     */
    @ExceptionHandler(BookNotFoundException.class)
    public final ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException bookEx, WebRequest req){
        ErrorResponse errorResponse = new ErrorResponse(new Date(), bookEx.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LibraryCardNotFoundException.class)
    public final ResponseEntity<Object> handleLibraryCardNotFoundException(LibraryCardNotFoundException libCardEx, WebRequest req){
        ErrorResponse errorResponse = new ErrorResponse(new Date(), libCardEx.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CardAlreadyPresentException.class)
    public final ResponseEntity<Object> handleCardAlreadyPresentException(CardAlreadyPresentException cardpresentEx, WebRequest req){
        ErrorResponse errorResponse = new ErrorResponse(new Date(), cardpresentEx.getMessage(),req.getDescription(false));
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(BookAlreadyBeenIssuedException.class)
    public final ResponseEntity<Object> handleBookhasAlreadyBeenIssued(BookAlreadyBeenIssuedException bookAlreadyEx, WebRequest webReq){
        ErrorResponse errorResponse = new ErrorResponse(new Date(), bookAlreadyEx.getMessage(),webReq.getDescription(false));
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
    }
}
