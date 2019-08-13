package com.mavha.tareas;

import com.mavha.tareas.api.TodoRestController;
import com.mavha.tareas.dto.TodoDto;
import com.mavha.tareas.service.TodoService;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoRestController.class)
public class TodoRestControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TodoService service;

    @Test
    public void givenTodos_whenGetTodoList_thenReturnJsonArray()
            throws Exception {

        TodoDto todoEntity = new TodoDto(Long.parseLong("1"),"Tarea 1", "POR INICIAR", "image.jpg");


        List<TodoDto> allTodos = Arrays.asList(todoEntity);

        BDDMockito.given(service.getList()).willReturn(allTodos);

        mvc.perform(MockMvcRequestBuilders.get("/listartareas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].descripcion", Matchers.is(todoEntity.getDescripcion())));


    }
}
