package com.onayquem.taskmanager.service;

import com.onayquem.taskmanager.entity.Task;
import com.onayquem.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }
    public Task create(Task task) {
        return repository.save(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }
}

