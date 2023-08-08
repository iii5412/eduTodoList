package com.study.todolist.controller;

import com.study.todolist.request.TodoCreate;
import com.study.todolist.response.TodoResponse;
import com.study.todolist.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TodoService todoService;

    @Test
    void getAllTodos() throws Exception {
        // given
        final TodoCreate todoCreate = TodoCreate.builder()
                .content("할일1")
                .build();
        final TodoResponse savedTodo = todoService.save(todoCreate);

        //expected
        this.mockMvc.perform(
                        get("/todo")
                                .accept(APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(
                        document("post-inquiry", responseFields(
                                fieldWithPath("[].id").description("TODO ID"),
                                fieldWithPath("[].content").description("할 일")
                                )
                        )
                );
    }

    @Test
    void getTodo() throws Exception {
        // given
        final TodoCreate todoCreate = TodoCreate.builder()
                .content("할일1")
                .build();
        final TodoResponse savedTodo = todoService.save(todoCreate);

        //expected
        this.mockMvc.perform(get("/todo/{todoId}", savedTodo.getId()).accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(
                        document("todo", pathParameters(
                                parameterWithName("todoId").description("TODO ID")
                        ),
                                responseFields(
                                        fieldWithPath("id").description("TODO ID"),
                                        fieldWithPath("content").description("할 일")
                                )
                        )
                );
    }

}
