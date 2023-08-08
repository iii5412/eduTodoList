package com.study.todolist.service;

import com.study.todolist.Repository.TodoRepository;
import com.study.todolist.exception.TodoNotFound;
import com.study.todolist.request.TodoCreate;
import com.study.todolist.request.TodoEdit;
import com.study.todolist.response.TodoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

@SpringBootTest
class TodoServiceTest {
    @Autowired
    TodoService todoService;

    @Autowired
    TodoRepository todoRepository;

    @BeforeEach
    void before() {
        todoRepository.deleteAll();
        final TodoCreate todoCreate = TodoCreate.builder()
                .content("할 일 1")
                .build();
        final TodoCreate todoCreate2 = TodoCreate.builder()
                .content("할 일 2")
                .build();
        todoService.save(todoCreate);
        todoService.save(todoCreate2);
    }

    @Test
    @DisplayName("Todo를 등록한다.")
    void saveTest() {
        final TodoCreate todoCreate = TodoCreate.builder()
                .content("할일 1")
                .build();
        final TodoResponse savedTodo = todoService.save(todoCreate);
        assertEquals(savedTodo.getContent(), "할일 1");
    }

    @Test
    @DisplayName("모든 Todo를 조회한다.")
    void getAll() {
        final List<TodoResponse> all = todoService.getAll();
        assertEquals(all.size(), 2);
    }

    @Test
    @DisplayName("Todo를 수정한다.")
    void editTest() {
        final List<TodoResponse> all = todoService.getAll();
        final TodoResponse todoResponse = all.get(0);
        final Long todoId = todoResponse.getId();
        final TodoEdit todoEdit = TodoEdit.builder().content("수정 1").build();

        final TodoResponse editedTodo = todoService.edit(todoId, todoEdit);
        assertEquals(editedTodo.getContent(), "수정 1");
    }

    @Test
    @DisplayName("Todo를 삭제한다.")
    void deleteTodo() {
        final TodoResponse todoResponse = todoService.getAll().get(0);
        final Long findTodoId = todoResponse.getId();

        todoService.delete(findTodoId);

        assertThrowsExactly(TodoNotFound.class, () -> todoService.get(findTodoId));
    }
}
