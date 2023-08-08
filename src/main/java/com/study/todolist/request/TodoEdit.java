package com.study.todolist.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoEdit {
    @NotBlank
    private String content;

    @Builder
    public TodoEdit(String content) {
        this.content = content;
    }
}
