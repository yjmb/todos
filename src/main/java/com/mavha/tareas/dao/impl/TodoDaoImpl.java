package com.mavha.tareas.dao.impl;

import com.mavha.tareas.dao.TodoDao;
import com.mavha.tareas.dto.TodoDto;
import com.mavha.tareas.entity.TodoEntity;
import com.mavha.tareas.entity.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoDaoImpl implements TodoDao {
    @Autowired
    TodoRepository repository;

    @Override
    public List<TodoDto> findAll() {
        return getDtoListByEntityList(repository.findAll());
    }

    @Override
    public TodoDto findById(long id) {
        TodoEntity entity = repository.getOne(id);
        TodoDto dto = new TodoDto();
        dto.setId(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        dto.setEstado(entity.getEstado());
        dto.setFoto(entity.getFoto());
        return dto;
    }

    @Override
    public TodoDto save(TodoDto dto) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setId(dto.getId());
        todoEntity.setDescripcion(dto.getDescripcion());
        todoEntity.setEstado(dto.getEstado());
        todoEntity.setFoto(dto.getFoto());
        repository.save(todoEntity);
        return dto;
    }

    @Override
    public List<TodoDto> getByDescripcionEstado(String desc, String estado) {
        return getDtoListByEntityList(repository.findByDescripcionEstado(desc, estado));
    }

    @Override
    public List<TodoDto> getByDescripcion(String desc) {
        return getDtoListByEntityList(repository.findByDescripcion(desc));
    }

    @Override
    public List<TodoDto> getByEstado(String estado){
        return getDtoListByEntityList(repository.findByEstado(estado));
    }

    private List<TodoDto> getDtoListByEntityList(List<TodoEntity> entityList){
        List<TodoDto> dtoList = new ArrayList<>();
        for (TodoEntity todoEntity: entityList){
            TodoDto dto = new TodoDto();
            dto.setId(todoEntity.getId());
            dto.setDescripcion(todoEntity.getDescripcion());
            dto.setEstado(todoEntity.getEstado());
            dto.setFoto(todoEntity.getFoto());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
