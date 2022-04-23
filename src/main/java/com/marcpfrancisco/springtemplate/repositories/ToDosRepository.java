package com.marcpfrancisco.springtemplate.repositories;

import com.marcpfrancisco.springtemplate.models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDosRepository
        extends JpaRepository<ToDo, Long> {

    Optional<ToDo> findToDoByTitle(String title);
}
