package com.ayaankhan.newproductservice.exceptionhandlers;

import com.ayaankhan.newproductservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmaticException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setErrormessage("arithmatic exception");
        exceptionDto.setResovle("try to resolve arithmatic");
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleAllException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setErrormessage("Global exception");
        exceptionDto.setResovle("try to check code");
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }


}
