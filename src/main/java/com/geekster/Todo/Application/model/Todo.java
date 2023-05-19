package com.geekster.Todo.Application.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Todo {
    private String id;
    @JsonProperty("name")
    private String todoName;
    private boolean todoStatus;

    public Todo(String id, String todoName, boolean todoStatus) {
        this.todoName = todoName;
        this.id = id;
        this.todoStatus = todoStatus;
    }
    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(boolean todoStatus) {
        this.todoStatus = todoStatus;
    }
}
