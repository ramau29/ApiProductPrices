package com.exercise.ApiPrices.controller;

import com.exercise.ApiPrices.model.dto.ErrorDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<ErrorDTO> NoElementExceptionHandler(NoSuchElementException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().code("E100").message("The resource cannot be found").build();
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDTO> ArgumentExceptionHandler(MethodArgumentTypeMismatchException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().code("E101").message("The request cannot be fulfilled due to bad syntax.").build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DataAccessException.class)
    public ResponseEntity<ErrorDTO> DataAccessExceptionHandler(DataAccessException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().code("E102").message("There is som problem with the database connection.").build();
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
