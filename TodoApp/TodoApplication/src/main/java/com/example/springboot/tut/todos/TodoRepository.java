package com.example.springboot.tut.todos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;



import javax.persistence.Column;

@Repository
public interface TodoRepository extends CrudRepository<Todo,Long> {
    Todo findByTitle(String title);
}
