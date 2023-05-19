package com.geekster.Todo.Application.repository;

import com.geekster.Todo.Application.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDao {
   private List<Todo>todoList;
    public ToDao(){
        todoList= new ArrayList<>();
         todoList.add(new Todo("0","Dummy todo for testing",true));
    }
    public List<Todo> getAllTodoFromDao(){
        return todoList;
    }
    public boolean save(Todo todo){
        todoList.add(todo);
        return true;
    }
    public boolean remove(Todo todo){
        todoList.remove(todo);
        return  true;
    }
    boolean updateStatus=false;
    public boolean update(String id, boolean status){
        for(Todo todo:todoList){
            if(todo.getId().equals(id)){
                //remove todo from todo list
                remove(todo);

                // update status
                 todo.setTodoStatus(status);

                 //save todo
                save(todo);
                return true;
            }
        }
        return false;
    }
}
