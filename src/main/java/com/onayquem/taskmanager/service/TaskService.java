package com.onayquem.taskmanager.service;

import com.onayquem.taskmanager.dto.CreateTaskRequest;
import com.onayquem.taskmanager.dto.TaskResponse;
import com.onayquem.taskmanager.dto.UpdateTaskRequest;
import com.onayquem.taskmanager.entity.Task;
import com.onayquem.taskmanager.entity.User;
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
    public TaskResponse create(CreateTaskRequest req, User user) {
        Task task = new Task();
        task.setTitle(req.title());
        task.setDescription(req.description());
        task.setCompleted(false);
        task.setUser(user);
        return toResponse(repository.save(task));
    }

    public List<TaskResponse> findAllByUser(User user) {
        return repository.findByUser(user).stream()
                .map(this::toResponse)
                .toList();
    }

    public TaskResponse findByIdAndUser(Long id, User user) {
        return toResponse(getEntity(id, user));
    }

    @Transactional
    public TaskResponse update(Long id, UpdateTaskRequest req, User user) {
        Task task = getEntity(id, user);

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
    public TaskResponse markCompleted(Long id, User user) {
        Task task = getEntity(id, user);
        task.setCompleted(true);
        return toResponse(repository.save(task));
    }

    @Transactional
    public void delete(Long id, User user) {
        Task task = getEntity(id, user);
        repository.delete(task);
    }

    private Task getEntity(Long id, User user) {
        return repository.findByIdAndUser(id, user)
                .orElseThrow(() -> new ResourceNotFoundException("Task " + id + " não encontrada"));
    }

    private TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted()
        );
    }

}

