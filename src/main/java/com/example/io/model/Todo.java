package com.example.io.model;

public record Todo(
        Integer id,
        String title,
        String desc,
        String status) {
}
