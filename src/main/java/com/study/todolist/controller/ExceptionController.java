package com.study.todolist.controller;

import com.study.todolist.exception.TodoException;
import com.study.todolist.response.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(TodoException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> todoException(TodoException e) {
        final int statusCode = e.getStatusCode();
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .code(String.valueOf(statusCode))
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(statusCode)
                .body(errorResponse);
    }
}
