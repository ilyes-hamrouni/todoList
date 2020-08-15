package com.msante.todo.services.Impl;

import com.msante.todo.entities.TodoEntity;
import com.msante.todo.exceptions.ResourceNotFoundException;
import com.msante.todo.repositories.TodoRepository;
import com.msante.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
     private TodoRepository todoRepository;

    private static final String EXCEPTION_MESSAGE = "Task not found with id: ";




    @Override
    public TodoEntity createTask(TodoEntity task) {
        return this.todoRepository.save(task);
    }

    @Override
    public TodoEntity updateTask(TodoEntity task) {
        Optional<TodoEntity> taskdb = this.todoRepository.findById(task.getTaskId());
        if(taskdb.isPresent()){
           return  this.todoRepository.save(task);
        }else{
            throw new ResourceNotFoundException(EXCEPTION_MESSAGE+task.getTaskId());
        }

    }

    @Override
    public void deleteTask(Long id) {
        Optional<TodoEntity> taskdb = this.todoRepository.findById(id);

        if (taskdb.isPresent()) {

            this.todoRepository.deleteById(id);

        } else {

            throw new ResourceNotFoundException(EXCEPTION_MESSAGE + id);

        }


    }

    @Override
    public TodoEntity getTaskById(Long id) {
        Optional<TodoEntity> taskdb = this.todoRepository.findById(id);

        if (taskdb.isPresent()) {

            return taskdb.get();

        } else {

            throw new ResourceNotFoundException(EXCEPTION_MESSAGE + id);
        }

    }

    @Override
    public List<TodoEntity> getAllTasks() {
        return this.todoRepository.findAll();
    }
}
