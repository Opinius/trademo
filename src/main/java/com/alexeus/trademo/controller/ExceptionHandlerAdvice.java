package com.alexeus.trademo.controller;

import com.alexeus.trademo.dto.StatusInfo;
import com.alexeus.trademo.exception.ConflictException;
import com.alexeus.trademo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({NotFoundException.class})
    @ResponseBody
    public ResponseEntity<StatusInfo> notFoundErrorHandler(Exception e) {
        return new ResponseEntity<>(new StatusInfo(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ConflictException.class})
    @ResponseBody
    public ResponseEntity<StatusInfo> conflictErrorHandler(Exception e) {
        return new ResponseEntity<>(new StatusInfo(e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponseEntity<StatusInfo> defaultErrorHandler(Exception e) {
        return new ResponseEntity<>(new StatusInfo(e), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
