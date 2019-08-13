package com.mavha.tareas.api;

import com.mavha.tareas.dto.TodoDto;
import com.mavha.tareas.dto.TodoRequest;
import com.mavha.tareas.dto.TodoResponse;
import com.mavha.tareas.service.TodoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TodoRestController {
    @Autowired
    TodoService todoService;
//    @Autowired
    Mapper mapper;

    @GetMapping(value="/listartareas")
    @ResponseBody
    public List<TodoDto> getTodoList(){
        return todoService.getList();
    }

    @GetMapping(value="/getbyparameters")
    @ResponseBody
    public List<TodoDto> getByParameters(@RequestParam(required = false) Long id, @RequestParam(required = false) String descripcion, @RequestParam(required = false) String estado){
        return todoService.getListByParameters(id, descripcion, estado);
    }


    @PostMapping(value="/guardartarea")
    public TodoResponse updateOrSave(@RequestBody @Valid TodoRequest request){
        TodoDto todoEntity = mapper.map(request, TodoDto.class);
        TodoDto updateTodo = todoService.save(todoEntity);
        return mapper.map(updateTodo, TodoResponse.class);
    }


    @GetMapping(value="/getbyid")
    @ResponseBody
    public TodoDto getById(long id){
        return todoService.getById(id);
    }

}
