package com.example.lesson4.model;

import java.io.Serializable;

public class BookModel implements Serializable {
    private final String name;
    private final String description;

    public BookModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
