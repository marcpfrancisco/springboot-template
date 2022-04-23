package com.marcpfrancisco.springtemplate.services;

import com.marcpfrancisco.springtemplate.dto.ToDosDTO;
import com.marcpfrancisco.springtemplate.models.ToDo;
import com.marcpfrancisco.springtemplate.repositories.ToDosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDosService {

    private final ToDosRepository toDosRepository;

    @Autowired
    public ToDosService(ToDosRepository toDosRepository) {
        this.toDosRepository = toDosRepository;
    }

    public List<ToDosDTO> getAllToDos() {
        return toDosRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public void createToDos(ToDo todo) {
        Optional<ToDo> optionalToDo = toDosRepository.findToDoByTitle(todo.getTitle());

        if (optionalToDo.isPresent()) {
            throw new IllegalStateException("Title already exists!");
        }

        toDosRepository.save(todo);
    }

    private ToDosDTO convertEntityToDTO(ToDo toDo) {
        ToDosDTO toDosDTO = new ToDosDTO();

        toDosDTO.setTodoId(toDo.getId());
        toDosDTO.setTitle(toDo.getTitle());
        toDosDTO.setDescription(toDo.getDescription());
        return toDosDTO;
    }


}
