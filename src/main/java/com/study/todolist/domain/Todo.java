package com.study.todolist.domain;

import com.study.todolist.request.TodoCreate;
import com.study.todolist.util.DateTimeUtils;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "TODO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {
    @Id
    @GeneratedValue
    @Column(name = "TODO_ID")
    private Long id;
    @Lob
    private String content;
    private LocalDateTime modifyDate;
    private String modifierId;

    @Builder
    public Todo(String content, String modifierId) {
        this.content = content;
        this.modifyDate = DateTimeUtils.getCurrentLocalDateTime();
        this.modifierId = modifierId;
    }

    public Todo(TodoCreate todoCreate) {
        this.content = todoCreate.getContent();
        this.modifyDate = DateTimeUtils.getCurrentLocalDateTime();
        this.modifierId = todoCreate.getModifierId();
    }

    public TodoEditor.TodoEditorBuilder toEditor() {
        return TodoEditor.builder().content(this.content);
    }

    public void edit(TodoEditor todoEditor) {
        this.content = todoEditor.getContent();
    }
}
