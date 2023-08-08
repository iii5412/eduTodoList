package com.study.todolist.controller;

import com.study.todolist.request.TodoEdit;
import com.study.todolist.response.TodoResponse;
import com.study.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/todo", "/todo/"})
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public List<TodoResponse> getAllTodos() {
        return todoService.getAll();
    }

    @GetMapping("/{todoId}")
    public TodoResponse get(@PathVariable Long todoId) {
        return todoService.get(todoId);
    }

    @PostMapping("/{todoId}")
    public TodoResponse edit(@PathVariable Long todoId, TodoEdit todoEdit) {
        return todoService.edit(todoId, todoEdit);
    }

    @DeleteMapping("/{todoId}")
    public void delete(@PathVariable Long todoId) {
        todoService.delete(todoId);
    }

}
