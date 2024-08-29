package com.example.step.rasp;

import java.util.List;

public class Teacher {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    List<Subject> list;

    public Teacher(String name) {
        this.name = name;
    }
}
