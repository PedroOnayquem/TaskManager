package com.onayquem.taskmanager.controller;

import com.onayquem.taskmanager.dto.CreateTaskRequest;
import com.onayquem.taskmanager.dto.TaskResponse;
import com.onayquem.taskmanager.dto.UpdateTaskRequest;
import com.onayquem.taskmanager.entity.User;
import com.onayquem.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public TaskResponse create(@Valid @RequestBody CreateTaskRequest req, @AuthenticationPrincipal User user) {
        return service.create(req, user);
    }

    @GetMapping
    public List<TaskResponse> findAll(@AuthenticationPrincipal User user) {
        return service.findAllByUser(user);
    }

    @GetMapping("/{id}")
    public TaskResponse findById(@PathVariable Long id, @AuthenticationPrincipal User user) {
        return service.findByIdAndUser(id, user);
    }

    @PatchMapping("/{id}")
    public TaskResponse update(@PathVariable Long id, @Valid @RequestBody UpdateTaskRequest req, @AuthenticationPrincipal User user) {
        return service.update(id, req, user);
    }

    @PatchMapping("/{id}/complete")
    public TaskResponse complete(@PathVariable Long id, @AuthenticationPrincipal User user) {
        return service.markCompleted(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, @AuthenticationPrincipal User user) {
        service.delete(id, user);
    }

}
