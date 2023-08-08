package com.study.todolist.response;

import com.study.todolist.domain.Todo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TodoResponse {
    private final Long id;
    private final String content;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.content = todo.getContent();
    }
    @Builder
    public TodoResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
