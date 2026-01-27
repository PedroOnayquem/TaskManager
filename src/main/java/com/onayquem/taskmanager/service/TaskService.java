package com.onayquem.taskmanager.service;

import com.onayquem.taskmanager.dto.CreateTaskRequest;
import com.onayquem.taskmanager.dto.TaskResponse;
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
    public TaskResponse create(CreateTaskRequest req) {
        Task task = new Task();
        task.setTitle(req.title());
        task.setDescription(req.description());
        task.setCompleted(false);
        return toResponse(repository.save(task));
    }
    public List<TaskResponse> findAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }
    public TaskResponse findById(Long id) {
        return toResponse(getEntity(id));
    }
    @Transactional
    public TaskResponse update(Long id, UpdateTaskRequest req) {
        Task task = getEntity(id);

        if (req.title() != null) {
            task.setTitle(req.title());
        }
        if (req.description() != null) {
            task.setDescription(req.description());
        }
        if (req.completed() != null) {
            task.setCompleted(req.completed());
        }
        return toResponse(repository.save(task));
    }
    @Transactional
    public TaskResponse markCompleted(Long id){
        Task task = getEntity(id);
        task.setCompleted(true);
        return toResponse(repository.save(task));
    }
    @Transactional
    public void delete(Long id){
        Task task = getEntity(id);
        repository.delete(task);
    }
    private Task getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task" + id + "não encontrada"));
    }
    private TaskResponse toResponse(Task task){
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted()
        );
    }

}

