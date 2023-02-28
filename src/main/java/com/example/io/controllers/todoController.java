package com.example.io.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.io.model.Status;
import com.example.io.model.Todo;
import com.example.io.repository.TodoCollectionRepository;

@Controller
public class todoController {

    @Autowired
    private TodoCollectionRepository repository;

    @QueryMapping
    Iterable<Todo> todos() {
        return repository.findAll();
    }

    record TodoInput(Integer id, String title, String desc, Status status) {
    }

    Todo addTodo(@Argument TodoInput input) {
        Todo newTodo = new Todo(input.id(), input.title(), input.desc(), input.status());
        return repository.create(newTodo);
    }

}
