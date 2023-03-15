package com.study.todolist.service;

import com.study.todolist.Repository.TodoRepository;
import com.study.todolist.domain.Todo;
import com.study.todolist.domain.TodoEditor;
import com.study.todolist.request.TodoCreate;
import com.study.todolist.request.TodoEdit;
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

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }
    //TODO : TodoResponse 생성 후 반환타입 변경 필요
    public Todo get(Long id) {
        return todoRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
    //TODO : TodoResponse 생성 후 반환타입 변경 필요
    public Todo save(TodoCreate todoCreate) {
        return todoRepository.save(new Todo(todoCreate));
    }
    //TODO : TodoResponse 생성 후 반환타입 변경 필요
    /**
        @Transactional 추가로 save 따로 하지 않음.
        트랜잭션이 끝나면 더티체킹을하여 Persistence Context에서 update한다.
    */
    @Transactional
    public Todo edit(Long id, TodoEdit todoEdit) {
        final Todo findTodo = todoRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        final TodoEditor.TodoEditorBuilder builder = findTodo.toEditor();
        final TodoEditor todoEditor = builder.content(todoEdit.getContent()).build();

        findTodo.edit(todoEditor);

        return findTodo;
    }

    public void delete(Long id) {
        final Todo findTodo = todoRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        todoRepository.delete(findTodo);
    }

}
