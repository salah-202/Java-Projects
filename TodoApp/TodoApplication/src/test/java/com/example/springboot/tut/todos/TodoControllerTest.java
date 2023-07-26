package com.example.springboot.tut.todos;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TodoControllerTest {
    @MockBean
    private TodoService todoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllTodosTest() throws Exception {
        Todo todo1 = new Todo(1L,"ft","first task description");
        Todo todo2 = new Todo(2L,"st","second task description");
        List<Todo> data = Arrays.asList(todo1,todo2);

        given(todoService.findAll()).willReturn(data);

        mockMvc.perform(get("/api/v1/todos").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));
    }

    @Test
    public void CreateNewTodoTest() throws Exception {
        Todo todo1 = new Todo();
        todo1.setTitle("Title of todo");
        todo1.setDesc("Title of todo");


        given(todoService.save(Mockito.any(Todo.class))).willReturn(todo1);

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/api/v1/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(todo1))
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title",is(todo1.getTitle())));

    }
}
