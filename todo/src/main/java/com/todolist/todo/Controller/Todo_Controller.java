package com.todolist.todo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todo.Models.todolist_model;
import com.todolist.todo.Repository.todo_repo;


@RestController
@RequestMapping("api/v1")
public class Todo_Controller {
 
    @Autowired
    todo_repo todo_repos;


    @GetMapping("/alltext")
    public ResponseEntity<List<todolist_model>> send_to_list(){

        List<todolist_model>  dummy_model = todo_repos.findAll();
        return new ResponseEntity<>( dummy_model , HttpStatus.CREATED);
            
    }



    @PostMapping("/todos")
    public ResponseEntity<String> createTodo(@RequestBody todolist_model todoss) {
        // Logic to save the todo item (e.g., save to a database)
        System.out.println("Todo ID: " + todoss.getId());
        System.out.println("Todo Text: " + todoss.getText());
        System.out.println("Todo Username: " + todoss.getUsename());
        todo_repos.save(todoss);
        // Returning a response indicating the todo item was created successfully
        return new ResponseEntity<>("Todo item created successfully & inserted into database!", HttpStatus.CREATED);
    }

    @GetMapping("/user/{usename}")
    public ResponseEntity<List<todolist_model>> getByUer(@PathVariable String usename){

        List<todolist_model>  dummy_model = todo_repos.findtodobyUsername(usename);
        System.out.println(usename);
        if (!dummy_model.isEmpty()) {
            return new ResponseEntity<>(dummy_model, HttpStatus.OK);
        }
         else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
           
   }


}
