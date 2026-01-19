package com.onayquem.taskmanager.controller;

import com.onayquem.taskmanager.entity.Task;
import com.onayquem.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    //Criar tarefa
    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.create(task);
    }

    //Listar todas
    @GetMapping
    public List<Task> findAll() {
        return service.findAll();
    }
}
