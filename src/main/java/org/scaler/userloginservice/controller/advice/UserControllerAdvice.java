package org.scaler.userloginservice.controller.advice;

import org.scaler.userloginservice.dtos.ExceptionDto;
import org.scaler.userloginservice.exception.IncorrectPasswordException;
import org.scaler.userloginservice.exception.InvalidEmailException;
import org.scaler.userloginservice.exception.UserAlreadyAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice {
    @ExceptionHandler(InvalidEmailException.class)
    private ResponseEntity<ExceptionDto> handleInvalidEmailException(InvalidEmailException e){
        ExceptionDto exceptionDto = ExceptionDto.builder()
                .message(e.getMessage())
                .status("Failure")
                .build();
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;

    }
    @ExceptionHandler(UserAlreadyAvailableException.class)
    private ResponseEntity<ExceptionDto> handleUserAlreadyAvailableException(UserAlreadyAvailableException e){
        ExceptionDto exceptionDto = ExceptionDto.builder()
                .message(e.getMessage())
                .status("Failure")
                .build();
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;

    }

    @ExceptionHandler(IncorrectPasswordException.class)
    private ResponseEntity<ExceptionDto> handleUserAlreadyAvailableException(IncorrectPasswordException e){
        ExceptionDto exceptionDto = ExceptionDto.builder()
                .message(e.getMessage())
                .status("Failure")
                .build();
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;

    }




}
