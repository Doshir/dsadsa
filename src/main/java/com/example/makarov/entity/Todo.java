package com.example.makarov.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    private boolean completed;

    @ManyToOne
    private User user;





}
