package com.onayquem.taskmanager.service;

import com.onayquem.taskmanager.dto.CreateTaskRequest;
import com.onayquem.taskmanager.dto.UpdateTaskRequest;
import com.onayquem.taskmanager.entity.Task;
import com.onayquem.taskmanager.exception.ResourceNotFoundException;
import com.onayquem.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public Task create(CreateTaskRequest req) {
        Task task = new Task();
        task.setTitle(req.title());
        task.setDescription(req.description());
        task.setCompleted(false);
        return repository.save(task);
    }
    public List<Task> findAll() {
        return repository.findAll();
    }
    public Task findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task " + id + " não encontrada"));
    }
    @Transactional
    public Task update(Long id, UpdateTaskRequest req) {
        Task task = findById(id);

        if (req.title() != null) {
            task.setTitle(req.title());
        }
        if (req.description() != null) {
            task.setDescription(req.description());
        }
        if (req.completed() != null) {
            task.setCompleted(req.completed());
        }
        return repository.save(task);
    }
    @Transactional
    public Task markCompleted(Long id){
        Task task = findById(id);
        task.setCompleted(true);
        return repository.save(task);
    }
    @Transactional
    public void delete(Long id){
        Task task = findById(id);
        repository.delete(task);
    }

}

