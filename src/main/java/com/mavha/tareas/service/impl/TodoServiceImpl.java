package com.mavha.tareas.service.impl;

import com.mavha.tareas.dao.TodoDao;
import com.mavha.tareas.dto.TodoDto;
import com.mavha.tareas.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoDao dao;

    public TodoDto save(TodoDto todoDto){
        TodoDto todoForUpdate;
        if (todoDto.getId() != null){
            todoForUpdate = getById(todoDto.getId());
            todoForUpdate.setEstado(todoDto.getEstado());
        }else {
            todoForUpdate = todoDto;
        }
        dao.save(todoForUpdate);
        return todoForUpdate;
    }

    public List<TodoDto> getList(){
        return dao.findAll();
    }


    public TodoDto getById(long id){
        return dao.findById(id);
    }

    @Override
    public List<TodoDto> getListByParameters(Long id, String descripcion, String estado) {
        List<TodoDto> todoDtoList = new ArrayList<>();
        if ((id != null) || (descripcion != null) || (estado != null) ) {
            if (id != null){
                todoDtoList.add(getById(id));
                return todoDtoList;
            }
            if(descripcion != null && estado != null){
                return dao.getByDescripcionEstado(descripcion, estado);
            }else{
                if(descripcion != null){
                    return dao.getByDescripcion(descripcion);
                }
                if(estado != null){
                    return dao.getByEstado(estado);
                }
            }

        }
        return todoDtoList;
    }

}
