package com.onayquem.taskmanager.dto;

import jakarta.validation.constraints.Size;

public record UpdateTaskRequest(

    @Size(min = 3, max = 100, message = "Titulo deve ter entre 3 e 100 caracteres")
    String title,

    @Size(max = 300, message = "Descrição deve ter no máximo 300 caractere")
    String description,

    boolean completed
) {}
