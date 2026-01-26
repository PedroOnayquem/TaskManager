package com.onayquem.taskmanager.controller;

import com.onayquem.taskmanager.dto.CreateTaskRequest;
import com.onayquem.taskmanager.dto.UpdateTaskRequest;
import com.onayquem.taskmanager.entity.Task;
import com.onayquem.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {

        this.service = service;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@Valid @RequestBody CreateTaskRequest req) {
        return service.create(req);
    }
    @GetMapping
    public List<Task> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id){
        return service.findById(id);
    }
    @PatchMapping("/{id}")
    public Task update(@PathVariable Long id, @Valid @RequestBody UpdateTaskRequest req){
        return service.update(id, req);
    }
    @PatchMapping("/{id}/complete")
    public Task complete(@PathVariable Long id){
        return service.markCompleted(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
