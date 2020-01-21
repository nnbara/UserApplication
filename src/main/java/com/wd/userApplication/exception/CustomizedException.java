package com.wd.userApplication.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedException {

    @Value("${UserApplication.message.file.format.error}")
    private String fileFormatException;

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request){

        ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),fileFormatException);
        return  new ResponseEntity(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);

    }

}
