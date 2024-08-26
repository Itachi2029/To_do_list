package com.todolist.todo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class todolist_model {
    @Id
    private int id;
    private String text;
    private String usename;

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for text
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // Getter and Setter for usename
    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }
}
