package com.todolist.todo.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todolist.todo.Models.todolist_model;
import com.todolist.todo.Repository.todo_repo;


@Service
public class todo_Service {

    private todo_repo todos;

    public List<todolist_model> getAllTodos() {
        return todos.findAll();
    }

    public todolist_model saveTodo(todolist_model todo) {
        return todos.save(todo);
    }

    public void deleteTodoById(int id) {
        todos.deleteById(id);
    }


    public List<todolist_model> findbyUsername(String usename){
          return  todos.findtodobyUsername(usename);
    }

}
