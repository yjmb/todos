package com.mavha.tareas;

import com.mavha.tareas.dto.TodoDto;
import com.mavha.tareas.entity.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TareasApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:application-integrationtest.properties")
public class TareasApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private TodoRepository repository;

	@Test
	public void givenEmployees_whenGetEmployees_thenStatus200()
			throws Exception {

		TodoDto todoEntity = new TodoDto(Long.parseLong("1"),"Tarea 1", "POR INICIAR", "image.jpg");



//		mvc.perform(get("/api/employees")
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(content()
//						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.jsonPath("$[0].descripcion", is("Tarea 1")));
	}


	@Test
	public void contextLoads() {
	}

}
