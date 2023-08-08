package com.study.todolist.exception;

import org.springframework.http.HttpStatus;

public class TodoNotFound extends TodoException {
    private static final String MESSAGE = "존재하지 않는 할 일 입니다.";

    public TodoNotFound() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
