package com.msante.todo.services;

import com.msante.todo.entities.TodoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
    TodoEntity createTask(TodoEntity task);
    TodoEntity updateTask(TodoEntity task);
    void deleteTask(Long id);
    TodoEntity getTaskById(Long id);
    List<TodoEntity> getAllTasks();

}
