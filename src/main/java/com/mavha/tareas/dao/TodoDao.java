package com.mavha.tareas.dao;

import com.mavha.tareas.dto.TodoDto;


import java.util.List;

public interface TodoDao {
    List<TodoDto> findAll();

    TodoDto findById(long id);

    TodoDto  save(TodoDto entity);

    List<TodoDto> getByDescripcionEstado(String desc, String estado);

    List<TodoDto> getByDescripcion(String desc);

    List<TodoDto> getByEstado(String estado);
}
