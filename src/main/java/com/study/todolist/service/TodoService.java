package com.study.todolist.service;

import com.study.todolist.Repository.TodoRepository;
import com.study.todolist.domain.Todo;
import com.study.todolist.domain.TodoEditor;
import com.study.todolist.exception.TodoNotFound;
import com.study.todolist.request.TodoCreate;
import com.study.todolist.request.TodoEdit;
import com.study.todolist.response.TodoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<TodoResponse> getAll() {
        final List<Todo> allTodos = todoRepository.findAll();
        return allTodos.stream().map(TodoResponse::new).toList();
    }
    public TodoResponse get(Long id) {
        final Todo todo = todoRepository.findById(id).orElseThrow(TodoNotFound::new);
        return new TodoResponse(todo);
    }
    public TodoResponse save(TodoCreate todoCreate) {
        final Todo savedTodo = todoRepository.save(new Todo(todoCreate));
        return new TodoResponse(savedTodo);
    }
    /**
        @Transactional 추가로 save 따로 하지 않음.
        트랜잭션이 끝나면 더티체킹을하여 Persistence Context에서 update한다.
    */
    @Transactional
    public TodoResponse edit(Long id, TodoEdit todoEdit) {
        final Todo findTodo = todoRepository.findById(id).orElseThrow(TodoNotFound::new);
        final TodoEditor todoEditor = findTodo.toEditor().content(todoEdit.getContent()).build();

        findTodo.edit(todoEditor);

        return new TodoResponse(findTodo);
    }

    public void delete(Long id) {
        final Todo findTodo = todoRepository.findById(id).orElseThrow(TodoNotFound::new);
        todoRepository.delete(findTodo);
    }

}
