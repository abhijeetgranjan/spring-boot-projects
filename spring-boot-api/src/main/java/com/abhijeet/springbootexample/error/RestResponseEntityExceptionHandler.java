package com.abhijeet.springbootexample.error;

import com.abhijeet.springbootexample.entity.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<Error> invalidDataInRequest (InvalidDataException exception) {
        Error message = new Error(HttpStatus.BAD_REQUEST,
                "Please check the input parameters");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(message);
    }

}
