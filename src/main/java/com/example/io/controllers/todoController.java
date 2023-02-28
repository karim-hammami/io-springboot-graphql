package com.example.io.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    record TodoInput(int id, String title, String desc, String status) {
    }

    @MutationMapping
    Todo addTodo(@Argument TodoInput input) {
        System.out.print("executed");
        Todo newTodo = new Todo(input.id(), input.title(), input.desc(), input.status());
        System.out.print(newTodo);
        return newTodo;
    }

}
