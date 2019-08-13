package com.mavha.tareas.service;

import com.mavha.tareas.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto save(TodoDto todoEntity);

    TodoDto getById(long id);

    List<TodoDto> getListByParameters(Long id, String descripcion, String estado);

    List<TodoDto> getList();


}
