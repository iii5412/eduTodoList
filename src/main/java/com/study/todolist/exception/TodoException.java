package com.study.todolist.exception;

import lombok.Getter;

@Getter
public abstract class TodoException extends RuntimeException {
    public TodoException() {
    }

    public TodoException(String message) {
        super(message);
    }

    public TodoException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();

}
