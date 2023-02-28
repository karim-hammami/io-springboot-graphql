package com.example.io;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.io.model.Todo;
import com.example.io.repository.TodoCollectionRepository;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(TodoCollectionRepository todoCollectionRepository) {
        return args -> {
            Todo gym = new Todo(1, "gym", "goto gym", "Pending");
            todoCollectionRepository.create(gym);
        };
    }
}
