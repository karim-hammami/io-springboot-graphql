package com.example.io.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

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
}
