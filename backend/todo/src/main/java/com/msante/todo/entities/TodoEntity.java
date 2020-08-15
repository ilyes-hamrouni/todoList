package com.msante.todo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String description;

    public TodoEntity(){

    }

}
