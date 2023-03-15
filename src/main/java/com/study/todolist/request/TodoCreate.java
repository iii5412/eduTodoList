package com.study.todolist.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoCreate {
    private String content;
    private String modifierId;

    @Builder
    public TodoCreate(String content, String modifierId) {
        this.content = content;
        this.modifierId = modifierId;
    }
}
