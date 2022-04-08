package tech.thuexe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.thuexe.DTO.util.ErrorDetails;
import tech.thuexe.utility.CustomException;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    // handler custom validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Error", exception.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    // handle custom exception
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> customV(CustomException exception){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Error", exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
