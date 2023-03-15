package com.study.todolist.domain;

import com.study.todolist.request.TodoEdit;
import lombok.Getter;

@Getter
public class TodoEditor {
    private final String content;

    public TodoEditor(TodoEditorBuilder builder) {
        this.content = builder.content;
    }

    public static TodoEditorBuilder builder() {
        return new TodoEditorBuilder();
    }

    public static class TodoEditorBuilder {
        private String content;

        public TodoEditorBuilder content(String content) {
            this.content = content;
            return this;
        }

        public TodoEditor build() {
            return new TodoEditor(this);
        }
    }
}
