package com.marcpfrancisco.springtemplate.controllers;

import com.marcpfrancisco.springtemplate.dto.ToDosDTO;
import com.marcpfrancisco.springtemplate.models.ToDo;
import com.marcpfrancisco.springtemplate.services.ToDosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/todo")
public class ToDosController {

    private final ToDosService toDosService;

    @Autowired
    public ToDosController(ToDosService toDosService) {
        this.toDosService = toDosService;
    }

    @GetMapping()
    public List<ToDosDTO> getTodos() {
        return toDosService.getAllToDos();
    }

    @PostMapping
    public void createToDos(@RequestBody ToDo todo) {
        toDosService.createToDos(todo);
    }
}
