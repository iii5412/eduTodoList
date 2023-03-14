package com.study.todolist.exception;

import org.springframework.http.HttpStatus;

public class NotFoundMemberException extends TodoException {
    private static final String MESSAGE = "존재하지 않는 사용자 입니다.";

    public NotFoundMemberException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
