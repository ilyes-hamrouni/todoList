package com.msante.todo.controllers;

import com.msante.todo.entities.TodoEntity;
import com.msante.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoEntity> createTask(@RequestBody TodoEntity task){
        return new ResponseEntity<>(this.todoService.createTask(task), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<TodoEntity>> getAllTasks(){
        return new ResponseEntity<>(this.todoService.getAllTasks(), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<TodoEntity> updateTask(@RequestBody TodoEntity task){
        return new ResponseEntity<>(this.todoService.updateTask(task), HttpStatus.OK);
    }
    @DeleteMapping
    public HttpStatus deleteTask(@PathVariable Long id){
        this.todoService.deleteTask(id);
        return HttpStatus.NO_CONTENT;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TodoEntity> getTaskById(@PathVariable long id){
        return new ResponseEntity<>(this.todoService.getTaskById(id), HttpStatus.OK);
    }
}   

