package com.example.makarov.controller;

import com.example.makarov.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TodoController  {
    private TodoRepository todoRepository;
    @Autowired
    public TodoController (TodoRepository todoRepository){
        this.todoRepository= todoRepository;
    }

}
