package com.geekster.Todo.Application.controller;

import com.geekster.Todo.Application.model.Todo;
import com.geekster.Todo.Application.service.TodoService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.NestingKind;
import javax.print.attribute.HashPrintRequestAttributeSet;
import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping(value = "/Todos")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
    @GetMapping(value ="/todos/status{status}")
    public List<Todo> getTodosByStatus(@PathVariable String status){
        return todoService.getTodosByStatus(status);
    }

    @PostMapping(value = "/Todos")
    public String addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }


    @RequestMapping(value = "/getTodosById/{todoId}", method = RequestMethod.GET)
    public Todo getTodosBasedOnId(@PathVariable String id ) {
         return todoService.getTodosBasedOnId(id);
    }
    @DeleteMapping(value = "/todo/{todoId}")
    public String deleteTodoById(@PathVariable String id){
        return todoService.removeTodoById(id);
    }
    @PutMapping(value = "todos/{todoId}/{status}")
    public String updateTodoStatusById(@PathVariable String id,@PathVariable String status){
        return todoService.updateTodoStatusById(id,status);

    }
}


