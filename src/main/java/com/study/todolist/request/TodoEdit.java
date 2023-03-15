package com.study.todolist.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Service;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoEdit {
    @NotBlank(message = "내용이 없습니다.")
    private String content;

    @Builder
    public TodoEdit(String content) {
        this.content = content;
    }
}
