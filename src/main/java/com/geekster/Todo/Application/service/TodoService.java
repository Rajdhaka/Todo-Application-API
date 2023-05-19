package com.geekster.Todo.Application.service;

import com.geekster.Todo.Application.repository.ToDao;
import com.geekster.Todo.Application.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    ToDao toDao;

    public List<Todo> getAllTodos() {
        return toDao.getAllTodoFromDao();
    }

    public String addTodo(Todo todo) {
        boolean insertionStatus = toDao.save(todo);
        if (insertionStatus) {
            return "Todo is added successfully !!!";
        }
        return "Failed ,Todo not possible, Database Error";
    }

    public Todo getTodosBasedOnId(String id) {
        List<Todo> todoList = toDao.getAllTodoFromDao();
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }
     public List<Todo>getTodosByStatus(String status){
         List<Todo> todoList = toDao.getAllTodoFromDao();
         List<Todo>statusTodoList= new ArrayList<>();
         for (Todo todo : todoList) {
             if (todo.getTodoStatus()==Boolean.parseBoolean(status)) {
                 statusTodoList.add(todo);
             }
         }
         return statusTodoList;
     }

    public String removeTodoById(String id) {
        boolean deleteResponse = false;
        String status;
        if (id != null) {
            List<Todo> todoList = toDao.getAllTodoFromDao();
            for (Todo todo : todoList) {
                if (todo.getId().equals(id)) {
                    deleteResponse = toDao.remove(todo);
                    if (deleteResponse) {
                        status = "Todo with id " + id + " was deleted !!!";
                    } else {
                        status = "Todo with id " + id + " was not deleted.... Database Error !!! ";
                    }
                    return status;
                }
            }
            return "Todo with id " + id + " does not exist !!!";
        }
        else{
            return "Invalid Id.... Can not accept Null Id !!!";
        }
    }


    public String updateTodoStatusById(String id, String  status){
        boolean updateTodoStatus= toDao.update(id,Boolean.parseBoolean(status));
        if(updateTodoStatus){
            return "Todo with id " + id + " was updated !!!";
        }
        else{
            return "Todo with id " + id + " does not exist !!!";
        }
    }

}


